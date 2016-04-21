package ru.ifmo.ctd.evdokimov.simple;

public class ByteCodeLoader extends ClassLoader {
    public static final ByteCodeLoader clazz = new ByteCodeLoader();

    public Class<?> loadClass(byte[] bytecode) {
        return defineClass(null, bytecode, 0, bytecode.length);
    }
}