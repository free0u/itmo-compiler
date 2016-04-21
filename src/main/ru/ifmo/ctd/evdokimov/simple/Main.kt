package ru.ifmo.ctd.evdokimov.simple

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import ru.ifmo.ctd.evdokimov.simple.antlr.CalcLexer
import ru.ifmo.ctd.evdokimov.simple.antlr.CalcParser
import java.io.DataOutputStream
import java.io.FileOutputStream
import java.util.*

fun dump(ops: ArrayList<Op>): ByteArray {
    val cw = ClassWriter(ClassWriter.COMPUTE_FRAMES)
    var mv: MethodVisitor
    cw.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "Main", null, "java/lang/Object", null)
    run {
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null)
        mv.visitVarInsn(Opcodes.ALOAD, 0)
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        mv.visitInsn(Opcodes.RETURN)
        mv.visitMaxs(0, 0);
    }


    run {
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null)

        // start generating main method

//        val values = HashMap<String, Int>()
        val varIdx = HashMap<String, Int> ()

        for (op in ops) {
            if (op.type == OpType.PRINT) {
                if (op.a is String) {
                    val varName: String = op.a
//                    println(v + " = " + values.get(v))


                    mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
                    mv.visitVarInsn(Opcodes.ILOAD, varIdx.get(varName)!! + 1);
                    mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false)

                }
            } else if (op.type == OpType.ADD) {
                when (op.a) {
                    is Int ->
                            mv.visitLdcInsn(op.a)
                    is String ->
                        mv.visitVarInsn(Opcodes.ILOAD, varIdx.get(op.a)!! + 1);
                    else -> {
                        error("Wrong type a in $op")
                    }
                }
                when (op.b) {
                    is Int ->
                        mv.visitLdcInsn(op.b)
                    is String ->
                        mv.visitVarInsn(Opcodes.ILOAD, varIdx.get(op.b)!! + 1);
                    else -> {
                        error("Wrong type b in $op")
                    }
                }

                val varName = op.res as String

                // find index for var
                if (!varIdx.containsKey(varName)) {
                    varIdx.put(varName, varIdx.size + 1)
                }
                val idx = varIdx.get(varName)

                mv.visitInsn(Opcodes.IADD);
                mv.visitVarInsn(Opcodes.ISTORE, idx!! + 1);
            } else if (op.type == OpType.ASSIGN) {
                if (op.res is String) {
                    when (op.a) {
                        is Int ->
                            mv.visitLdcInsn(op.a)
                        is String ->
                            mv.visitVarInsn(Opcodes.ILOAD, varIdx.get(op.a)!! + 1);
                    }

                    val varName = op.res
                    // find index for var
                    if (!varIdx.containsKey(varName)) {
                        varIdx.put(varName, varIdx.size + 1)
                    }
                    val idx = varIdx.get(varName)
                    mv.visitVarInsn(Opcodes.ISTORE, idx!! + 1);
                } else {
                    error("Wrong res for $op")
                }
            } else {
                throw UnsupportedOperationException(op.type.toString())
            }

        }







// print
//        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
//        mv.visitLdcInsn("test ad")
//        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)


        mv.visitInsn(Opcodes.RETURN)
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
    val lexer = CalcLexer(ANTLRFileStream("test1.simple"))
    val parser = CalcParser(CommonTokenStream(lexer))

    val walker = ParseTreeWalker();
    val listener = CalcListener()
    walker.walk(listener, parser.prog())

    val bytes = dump(listener.ops)

    println("run compiled class")
    val aClass = ByteCodeLoader.clazz.loadClass(bytes)
    val meth = aClass.getMethod("main", Array<String>::class.java)
    meth.invoke(null, args)
}