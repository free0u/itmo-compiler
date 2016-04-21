package ru.ifmo.ctd.evdokimov.alang

class ByteCodeLoader : ClassLoader() {

    fun loadClass(bytecode: ByteArray): Class<*> {
        return defineClass(null, bytecode, 0, bytecode.size)
    }

    companion object {
        val clazz = ByteCodeLoader()
    }
}