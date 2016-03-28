package ru.ifmo.ctd.evdokimov.alang

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangLexer
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser

fun main(args: Array<String>) {
    val lexer = AlangLexer(ANTLRFileStream("progs/expr.a"))
    val parser = AlangParser(CommonTokenStream(lexer))

    val walker = ParseTreeWalker();
    val listener = AlangListener()
    walker.walk(listener, parser.program())

    //        val bytes = dump(listener.ops)
//    val bytes = ByteArray(0)
//
//    println("run compiled class")
//    val aClass = ByteCodeLoader.clazz.loadClass(bytes)
//    val meth = aClass.getMethod("main", Array<String>::class.java)
//    meth.invoke(null, args)
}
