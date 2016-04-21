package ru.ifmo.ctd.evdokimov.alang

import main.ru.ifmo.ctd.evdokimov.alang.testProgram
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangLexer
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import java.io.DataOutputStream
import java.io.FileOutputStream
import java.util.*

fun generateJavaType(typeRaw : String) : String {
    var type = "("
    for (i in typeRaw.substring(1)) {
        type += i
    }
    type += ")"
    type += typeRaw.first()
    return type;
}

fun getByteCode(listener: AlangListener) : ByteArray {

    val functions = listener.functionOps
    val functionTypes = listener.functionTypes
    val globalVarNames = listener.globalVarNames
    val globalVarTypes = listener.globalVarTypes

    var className = "Main" + ((Math.random() * 1000).toInt())

    fun loadFromVarToStack(mv : MethodVisitor, idx : Int) {
        if (idx < 0) {
            val name = globalVarNames.get(idx)!!
            val type = globalVarTypes.get(idx)!!
            mv.visitFieldInsn(GETSTATIC, className, name, type);
        } else {
            mv.visitVarInsn(ILOAD, idx)
        }
    }

    fun storeFromStackToVar(mv : MethodVisitor, idx : Int) {
        if (idx < 0) {
            val name = globalVarNames.get(idx)!!
            val type = globalVarTypes.get(idx)!!
            mv.visitFieldInsn(PUTSTATIC, className, name, type);
        } else {
            mv.visitVarInsn(ISTORE, idx)
        }
    }

    val cw = ClassWriter(ClassWriter.COMPUTE_FRAMES)
    var mv: MethodVisitor
    var fv: FieldVisitor
    cw.visit(52, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null)

    run {
        fv = cw.visitField(ACC_PRIVATE + ACC_STATIC, "_sc", "Ljava/util/Scanner;", null, null);
        fv.visitEnd();
    }

    run {
        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null)
        mv.visitVarInsn(ALOAD, 0)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        mv.visitInsn(RETURN)
        mv.visitMaxs(0, 0);
    }

    val labelMapping = HashMap<Int, Label>()



    for (id in globalVarNames.keys) {
        val name = globalVarNames.get(id)!!
        val type = globalVarTypes.get(id)!!

        fv = cw.visitField(ACC_PRIVATE + ACC_STATIC, name, type, null, null);
    }


    for (funcName in functions.keys) {
        val ops = functions.get(funcName)!!
        val typeRaw = functionTypes.get(funcName)!!

        val type = generateJavaType(typeRaw)

        run {
            mv = cw.visitMethod(ACC_PRIVATE + ACC_STATIC, funcName, type, null, null)

            // start generating main method

            for (op in ops) {
                val x = op.x
                val y = op.y
                val res = op.res

                if (op.type == OpType.IADD ||
                    op.type == OpType.ISUB ||
                    op.type == OpType.IMUL ||
                    op.type == OpType.IDIV ||
                    op.type == OpType.IMOD) {
                    if (x.type == ArgType.INT) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in add..mod group: $x")
                    }
                    if (y.type == ArgType.INT) {
                        mv.visitLdcInsn(y.value as Int)
                    } else if (y.type == ArgType.IDX) {
                        loadFromVarToStack(mv, y.value as Int)
                    } else {
                        error("unexpected type in add..mod group: $y")
                    }

                    val jvmOp = when (op.type) {
                        OpType.IADD -> IADD
                        OpType.ISUB -> ISUB
                        OpType.IMUL -> IMUL
                        OpType.IDIV -> IDIV
                        OpType.IMOD -> IREM
                        else -> error("Unmatched op in add..mod group")
                    }

                    mv.visitInsn(jvmOp);
                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.ASSIGN) {
                    if (x.type == ArgType.INT) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in assign group: $x")
                    }
                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.PRINT) {
                    if (x.type == ArgType.INT || x.type == ArgType.BOOL) {
                        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        mv.visitLdcInsn(x.value as Int)
                        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                    } else if (x.type == ArgType.IDX) {
                        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        loadFromVarToStack(mv, x.value as Int)
                        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                    } else {
                        error("unexpected type in print group: $x")
                    }
                } else if (op.type == OpType.IG ||
                        op.type == OpType.IL ||
                        op.type == OpType.IGE ||
                        op.type == OpType.ILE ||
                        op.type == OpType.EQ ||
                        op.type == OpType.NEQ) {

                    if (x.type == ArgType.INT || x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in comp group: $x")
                    }
                    if (y.type == ArgType.INT || y.type == ArgType.BOOL) {
                        mv.visitLdcInsn(y.value as Int)
                    } else if (y.type == ArgType.IDX) {
                        loadFromVarToStack(mv, y.value as Int)
                    } else {
                        error("unexpected type in comp group: $y")
                    }

                    val jvmOp = when (op.type) {
                        OpType.IG -> IF_ICMPLE // >
                        OpType.IL -> IF_ICMPGE // <
                        OpType.IGE -> IF_ICMPLT // >=
                        OpType.ILE -> IF_ICMPGT // <=
                        OpType.EQ -> IF_ICMPNE // ==
                        OpType.NEQ -> IF_ICMPEQ // !=
                        else -> error("Unmatched op in comp group")
                    }

                    val l2 = Label()
                    mv.visitJumpInsn(jvmOp, l2)
                    mv.visitInsn(ICONST_1)
                    val l3 = Label()
                    mv.visitJumpInsn(GOTO, l3)
                    mv.visitLabel(l2)
                    mv.visitInsn(ICONST_0)
                    mv.visitLabel(l3)

                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.BAND) {
                    if (x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in badd group: $x")
                    }
                    val l3 = Label();
                    mv.visitJumpInsn(IFEQ, l3);
                    if (y.type == ArgType.BOOL) {
                        mv.visitLdcInsn(y.value as Int)
                    } else if (y.type == ArgType.IDX) {
                        loadFromVarToStack(mv, y.value as Int)
                    } else {
                        error("unexpected type in badd group: $y")
                    }

                    mv.visitJumpInsn(IFEQ, l3);
                    mv.visitInsn(ICONST_1);
                    val l4 = Label();
                    mv.visitJumpInsn(GOTO, l4);
                    mv.visitLabel(l3);
                    mv.visitInsn(ICONST_0);
                    mv.visitLabel(l4);

                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.BOR) {

                    if (x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in bor group: $x")
                    }


                    val l3 = Label();
                    mv.visitJumpInsn(IFNE, l3);
                    if (y.type == ArgType.BOOL) {
                        mv.visitLdcInsn(y.value as Int)
                    } else if (y.type == ArgType.IDX) {
                        loadFromVarToStack(mv, y.value as Int)
                    } else {
                        error("unexpected type in bor group: $y")
                    }

                    val l4 = Label();
                    mv.visitJumpInsn(IFEQ, l4);
                    mv.visitLabel(l3);
                    mv.visitInsn(ICONST_1);
                    val l5 = Label();
                    mv.visitJumpInsn(GOTO, l5);
                    mv.visitLabel(l4);
                    mv.visitInsn(ICONST_0);
                    mv.visitLabel(l5);

                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.LABEL) {
                    val labelId = x.value as Int
                    if (!labelMapping.containsKey(labelId)) {
                        labelMapping.put(labelId, Label())
                    }
                    val label : Label = labelMapping.get(labelId)!!

                    mv.visitLabel(label);
                } else if (op.type == OpType.JMP) {
                    val labelId = x.value as Int
                    if (!labelMapping.containsKey(labelId)) {
                        labelMapping.put(labelId, Label())
                    }
                    val label : Label = labelMapping.get(labelId)!!

                    mv.visitJumpInsn(GOTO, label);
                } else if (op.type == OpType.JMPT || op.type == OpType.JMPF) {
                    val labelId = y.value as Int
                    if (!labelMapping.containsKey(labelId)) {
                        labelMapping.put(labelId, Label())
                    }
                    val label : Label = labelMapping.get(labelId)!!

                    if (x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in jmpt/jmpf group: $x")
                    }

                    val jvmOp = when (op.type) {
                        OpType.JMPT -> IFNE // == 1
                        OpType.JMPF -> IFEQ // == 0
                        else -> error("Unmatched op in jmpt/jmpf group")
                    }

                    mv.visitJumpInsn(jvmOp, label);
                } else if (op.type == OpType.RET) {
                    mv.visitInsn(RETURN);
                } else if (op.type == OpType.IRET) {
                    if (x.type == ArgType.INT || x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in iret group: $x")
                    }
                    mv.visitInsn(IRETURN);
                } else if (op.type == OpType.ARG) {
                    if (x.type == ArgType.INT || x.type == ArgType.BOOL) {
                        mv.visitLdcInsn(x.value as Int)
                    } else if (x.type == ArgType.IDX) {
                        loadFromVarToStack(mv, x.value as Int)
                    } else {
                        error("unexpected type in arg group: $x")
                    }
                } else if (op.type == OpType.ICALL) {
                    if (x.type != ArgType.FUNCTION) {
                        error("arg 1 for ICALL should be function")
                    }
                    val callingFunction = x.value as String
                    if (res.type != ArgType.IDX) {
                        error("arg 3 for ICALL should be idx")
                    }

                    val typeRaw = functionTypes.get(callingFunction)!!
                    val retType = generateJavaType(typeRaw)

                    mv.visitMethodInsn(INVOKESTATIC, className, callingFunction, retType, false);
                    storeFromStackToVar(mv, res.value as Int)
                } else if  (op.type == OpType.CALL) {
                    if (x.type != ArgType.FUNCTION) {
                        error("arg 1 for ICALL should be function")
                    }
                    val callingFunction = x.value as String

                    val typeRaw = functionTypes.get(callingFunction)!!
                    val retType = generateJavaType(typeRaw)

                    mv.visitMethodInsn(INVOKESTATIC, className, callingFunction, retType, false);
                } else if (op.type == OpType.IREAD) {
                    if (res.type != ArgType.IDX) {
                        error("arg 3 for IREAD should be idx")
                    }
                    mv.visitFieldInsn(GETSTATIC, className, "_sc", "Ljava/util/Scanner;");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.BREAD) {
                    if (res.type != ArgType.IDX) {
                        error("arg 3 for BREAD should be idx")
                    }
                    mv.visitFieldInsn(GETSTATIC, className, "_sc", "Ljava/util/Scanner;");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextBoolean", "()Z", false);
                    storeFromStackToVar(mv, res.value as Int)
                } else if (op.type == OpType.BREAK) {
                    val labelId = x.value as Int
                    if (!labelMapping.containsKey(labelId)) {
                        labelMapping.put(labelId, Label())
                    }
                    val label : Label = labelMapping.get(labelId)!!

                    mv.visitJumpInsn(GOTO, label);
                } else if (op.type == OpType.CONTINUE) {
                    val labelId = x.value as Int
                    if (!labelMapping.containsKey(labelId)) {
                        labelMapping.put(labelId, Label())
                    }
                    val label : Label = labelMapping.get(labelId)!!

                    mv.visitJumpInsn(GOTO, label);
                } else {
                    error("Unexpected operation: $op")
                }
            }

            // end generating main method
            mv.visitInsn(RETURN)
            mv.visitMaxs(0, 0)
        }

    }

    // main method
    run {
        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        mv.visitMethodInsn(INVOKESTATIC, className, "main", "()V", false);
        mv.visitInsn(RETURN);

        mv.visitMaxs(1, 2);
    }

    // static init
    run {
        mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
        mv.visitTypeInsn(NEW, "java/util/Scanner");
        mv.visitInsn(DUP);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
        mv.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
        mv.visitFieldInsn(PUTSTATIC, className, "_sc", "Ljava/util/Scanner;");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 2);
    }



    val d = cw.toByteArray()
    val dout = DataOutputStream(FileOutputStream("Main.class"));
    dout.write(d);
    dout.flush();
    dout.close();

    return d
}

fun parseFuncTypes(filename : String) : HashMap<String, String> {
    val lexer = AlangLexer(ANTLRFileStream(filename))
    val parser = AlangParser(CommonTokenStream(lexer))

    val walker = ParseTreeWalker();
    val funcListener = AlangFuncListener()
    walker.walk(funcListener, parser.program())

    return funcListener.functionTypes
}



fun main(args: Array<String>) {
    println("Result : " + testProgram("progs/sum.a", "2 3", "5"))
    println("Result : " + testProgram("progs/sum.a", "-1 1", "0"))
    println("Result : " + testProgram("progs/sum.a", "0 0", "0"))
    println("Result : " + testProgram("progs/sum.a", "-1 2", "1"))
    println("Result : " + testProgram("progs/sum.a", "2 -1", "1"))
    println("Result : " + testProgram("progs/sum.a", "-3 -2", "-5"))



//    var filename = "progs/functions.a"
//
//    filename = "progs/fib-rec.a"
//    filename = "progs/power-interactive.a"
//    filename = "progs/break.a"
//    filename = "progs/switch.a"
//
//    val functionTypes = parseFuncTypes(filename)
//
//
//    val lexer = AlangLexer(ANTLRFileStream(filename))
//    val parser = AlangParser(CommonTokenStream(lexer))
//
//    val walker = ParseTreeWalker();
//    val listener = AlangListener(functionTypes)
//    walker.walk(listener, parser.program())
//    val bytes = getByteCode(listener)
//
//
//    println("run compiled class")
//    val aClass = ByteCodeLoader.clazz.loadClass(bytes)
//    val meth = aClass.getMethod("main", Array<String>::class.java)
//    meth.invoke(null, args)
}
