package ru.ifmo.ctd.evdokimov.alang

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangLexer
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import java.io.DataOutputStream
import java.io.FileOutputStream
import java.util.*

fun getByteCode(ops : ArrayList<Op>) : ByteArray {
    val cw = ClassWriter(ClassWriter.COMPUTE_FRAMES)
    var mv: MethodVisitor
    cw.visit(52, ACC_PUBLIC + ACC_SUPER, "Main", null, "java/lang/Object", null)
    run {
        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null)
        mv.visitVarInsn(ALOAD, 0)
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        mv.visitInsn(RETURN)
        mv.visitMaxs(0, 0);
    }

//    var idxLabel = 10000;
    val labelMapping = HashMap<Int, Label>()


    run {
        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null)

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
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in add..mod group: $x")
                }
                if (y.type == ArgType.INT) {
                    mv.visitLdcInsn(y.value as Int)
                } else if (y.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, y.value as Int)
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
                mv.visitVarInsn(ISTORE, res.value as Int)
            } else if (op.type == OpType.ASSIGN) {
                if (x.type == ArgType.INT) {
                    mv.visitLdcInsn(x.value as Int)
                } else if (x.type == ArgType.BOOL) {
                    mv.visitLdcInsn(x.value as Int)
                } else if (x.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in assign group: $x")
                }
                mv.visitVarInsn(ISTORE, res.value as Int);
            } else if (op.type == OpType.PRINT) {
                if (x.type == ArgType.INT || x.type == ArgType.BOOL) {
                    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                    mv.visitLdcInsn(x.value as Int)
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                } else if (x.type == ArgType.IDX) {
                    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                    mv.visitVarInsn(ILOAD, x.value as Int);
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
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in comp group: $x")
                }
                if (y.type == ArgType.INT || y.type == ArgType.BOOL) {
                    mv.visitLdcInsn(y.value as Int)
                } else if (y.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, y.value as Int)
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

                mv.visitVarInsn(ISTORE, res.value as Int)
            } else if (op.type == OpType.BAND) {
                if (x.type == ArgType.BOOL) {
                    mv.visitLdcInsn(x.value as Int)
                } else if (x.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in badd group: $x")
                }
                val l3 = Label();
                mv.visitJumpInsn(IFEQ, l3);
                if (y.type == ArgType.BOOL) {
                    mv.visitLdcInsn(y.value as Int)
                } else if (y.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, y.value as Int)
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

                mv.visitVarInsn(ISTORE, res.value as Int);
            } else if (op.type == OpType.BOR) {

//                mv.visitVarInsn(ILOAD, 0);
                if (x.type == ArgType.BOOL) {
                    mv.visitLdcInsn(x.value as Int)
                } else if (x.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in bor group: $x")
                }


                val l3 = Label();
                mv.visitJumpInsn(IFNE, l3);
//                mv.visitVarInsn(ILOAD, 1);
                if (y.type == ArgType.BOOL) {
                    mv.visitLdcInsn(y.value as Int)
                } else if (y.type == ArgType.IDX) {
                    mv.visitVarInsn(ILOAD, y.value as Int)
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

                mv.visitVarInsn(ISTORE, res.value as Int);
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
                    mv.visitVarInsn(ILOAD, x.value as Int)
                } else {
                    error("unexpected type in jmpt/jmpf group: $x")
                }

                val jvmOp = when (op.type) {
                    OpType.JMPT -> IFNE // == 1
                    OpType.JMPF -> IFEQ // == 0
                    else -> error("Unmatched op in jmpt/jmpf group")
                }

                mv.visitJumpInsn(jvmOp, label);
            } else {
                error("Unexpected operation: $op")
            }
        }

        // end generating main method
        mv.visitInsn(RETURN)
        mv.visitMaxs(0, 0)
    }


    val d = cw.toByteArray()
    val dout = DataOutputStream(FileOutputStream("Main.class"));
    dout.write(d);
    dout.flush();
    dout.close();

    return d
}

fun main(args: Array<String>) {
    val lexer = AlangLexer(ANTLRFileStream("progs/power.a"))
    val parser = AlangParser(CommonTokenStream(lexer))

    val walker = ParseTreeWalker();
    val listener = AlangListener()
    walker.walk(listener, parser.program())

    val bytes = getByteCode(listener.ops)

    println("run compiled class")
    val aClass = ByteCodeLoader.clazz.loadClass(bytes)
    val meth = aClass.getMethod("main", Array<String>::class.java)
    meth.invoke(null, args)
}
