package ru.ifmo.ctd.evdokimov.sandbox;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import ru.ifmo.ctd.evdokimov.simple.ByteCodeLoader;

import java.lang.reflect.Method;

public class MainDump implements Opcodes {

    public static byte[] dump() throws Exception {

//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "ru/ifmo/ctd/evdokimov/simple/Main", null, "java/lang/Object", null);

        cw.visitSource("Main.java", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
//            mv.visitMaxs(0, 0);
            mv.visitMaxs(0, 0);
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("hello hell");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitInsn(RETURN);
//           mv.visitMaxs(2, 1);
            mv.visitMaxs(0, 0);
        }
        cw.visitEnd();

        return cw.toByteArray();
    }



//    public static byte[] dump() throws Exception {
//
//        //        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        FieldVisitor fv;
//        MethodVisitor mv;
//        AnnotationVisitor av0;
//
//        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "ru/ifmo/ctd/evdokimov/simple/Main", null, "java/lang/Object", null);
//
//        cw.visitSource("Main.java", null);
//
//        {
//            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
//            //            mv.visitCode();
//            //            Label l0 = new Label();
//            //            mv.visitLabel(l0);
//            //            mv.visitLineNumber(3, l0);
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
//            mv.visitInsn(RETURN);
//            //            Label l1 = new Label();
//            //            mv.visitLabel(l1);
//            //            mv.visitLocalVariable("this", "Lru/ifmo/ctd/evdokimov/simple/Main;", null, l0, l1, 0);
//            //            mv.visitMaxs(1, 1);
//            //            mv.visitEnd();
//        }
//        {
//            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
//            //            mv.visitCode();
//            //            Label l0 = new Label();
//            //            mv.visitLabel(l0);
//            //            mv.visitLineNumber(5, l0);
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("hello hell");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            //            Label l1 = new Label();
//            //            mv.visitLabel(l1);
//            //            mv.visitLineNumber(7, l1);
//            mv.visitInsn(RETURN);
//            //            Label l2 = new Label();
//            //            mv.visitLabel(l2);
//            //            mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l2, 0);
//            //            mv.visitMaxs(2, 1);
//            //            mv.visitEnd();
//        }
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = ByteCodeLoader.clazz.loadClass(dump());

        Method meth = aClass.getMethod("main", String[].class);
        String[] params = null;
        meth.invoke(null, (Object) null);
    }
}

