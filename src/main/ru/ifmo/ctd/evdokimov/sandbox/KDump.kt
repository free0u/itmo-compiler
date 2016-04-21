package ru.ifmo.ctd.evdokimov.sandbox

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import java.io.DataOutputStream
import java.io.FileOutputStream

class KDump {
    fun dump(): ByteArray {
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

//            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
//            mv.visitLdcInsn("test ad")
//            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
//            mv.visitIntInsn(Opcodes.BIPUSH, 4)
//            mv.visitInsn(Opcodes.POP)


//            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitIntInsn(Opcodes.SIPUSH, 500);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitIntInsn(Opcodes.SIPUSH, 500);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitIntInsn(Opcodes.SIPUSH, 500);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitIntInsn(Opcodes.SIPUSH, 500);
            mv.visitIntInsn(Opcodes.SIPUSH, 500);
            mv.visitInsn(Opcodes.IADD);
            mv.visitVarInsn(Opcodes.ISTORE, 1);

//            mv.visitIntInsn(Opcodes.SIPUSH, 600);
//            mv.visitInsn(Opcodes.IADD);

//            mv.visitInsn(Opcodes.ICONST_1);
//            mv.visitVarInsn(Opcodes.ISTORE, 1);
//            mv.visitInsn(Opcodes.ICONST_1);
//            mv.visitVarInsn(Opcodes.ISTORE, 2);
//
//            mv.visitVarInsn(Opcodes.ILOAD, 1);
//            mv.visitLdcInsn(200000);
//            mv.visitInsn(Opcodes.IADD);
//            mv.visitVarInsn(Opcodes.ISTORE, 1);
//

            mv.visitInsn(Opcodes.RETURN)
            mv.visitMaxs(0, 0)
////            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
////            mv.visitLocalVariable()
        }



        val d = cw.toByteArray()
        val dout = DataOutputStream(FileOutputStream("Main.class"));
        dout.write(d);
        dout.flush();
        dout.close();

        return d
    }
}
