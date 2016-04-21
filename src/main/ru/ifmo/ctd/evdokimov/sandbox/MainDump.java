package ru.ifmo.ctd.evdokimov.sandbox;

import org.objectweb.asm.*;
import ru.ifmo.ctd.evdokimov.simple.ByteCodeLoader;

import java.lang.reflect.Method;

public class MainDump implements Opcodes {
    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "ru/ifmo/ctd/evdokimov/sandbox/Sums", null, "java/lang/Object", null);


        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

//            // int i = 0;
//            mv.visitInsn(ICONST_0);
//            mv.visitVarInsn(ISTORE, 1);
//
//            Label l1 = new Label();
//            mv.visitLabel(l1);
//            mv.visitVarInsn(ILOAD, 1);
//            mv.visitInsn(ICONST_5);
//            Label l2 = new Label();
//            mv.visitJumpInsn(IF_ICMPGE, l2);
//
//            // int t = i * 10
//            mv.visitVarInsn(ILOAD, 1);
//            mv.visitIntInsn(BIPUSH, 10);
//            mv.visitInsn(IMUL);
//            mv.visitVarInsn(ISTORE, 2);
//
//            // sout
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitVarInsn(ILOAD, 2);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
//
//            // i = i + 1
//            mv.visitVarInsn(ILOAD, 1);
//            mv.visitInsn(ICONST_1);
//            mv.visitInsn(IADD);
//            mv.visitVarInsn(ISTORE, 1);
//
//            mv.visitJumpInsn(GOTO, l1);
//            mv.visitLabel(l2);
//            mv.visitInsn(RETURN);
//            mv.visitMaxs(0, 0);




            mv.visitIntInsn(SIPUSH, 4);
            mv.visitVarInsn(ISTORE, 1);

            mv.visitIntInsn(SIPUSH, 5);
            mv.visitVarInsn(ISTORE, 2);

            mv.visitVarInsn(ILOAD, 1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 3);

            mv.visitVarInsn(ILOAD, 3);
            mv.visitIntInsn(SIPUSH, 7);
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 4);



            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(ILOAD, 4);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);


            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
        }

        return cw.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = ByteCodeLoader.clazz.loadClass(dump());

        Method meth = aClass.getMethod("main", String[].class);
        String[] params = null;
        meth.invoke(null, (Object) null);
    }
}

