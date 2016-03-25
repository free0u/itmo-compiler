package ru.ifmo.ctd.evdokimov.sandbox

import ru.ifmo.ctd.evdokimov.simple.ByteCodeLoader
import ru.ifmo.ctd.evdokimov.simple.antlr.ExprLexer




fun main(args: Array<String>) {
    val lexer = ExprLexer(null)

    val dump = KDump().dump()
    val aClass = ByteCodeLoader.clazz.loadClass(dump)

    val meth = aClass.getMethod("main", Array<String>::class.java)
    meth.invoke(null, args)
}