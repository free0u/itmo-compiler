package ru.ifmo.ctd.evdokimov.sandbox

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class KDump {
    fun dump(): ByteArray {
        val cw = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        var mv: MethodVisitor
        cw.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "ru/ifmo/ctd/evdokimov/simple/Main", null, "java/lang/Object", null)

        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null)
        mv.visitVarInsn(Opcodes.ALOAD, 0)
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        mv.visitInsn(Opcodes.RETURN)
        mv.visitMaxs(0, 0);

        mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null)
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
        mv.visitLdcInsn("test string")
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
        mv.visitInsn(Opcodes.RETURN)
        mv.visitMaxs(0, 0)

        return cw.toByteArray()
    }
}
