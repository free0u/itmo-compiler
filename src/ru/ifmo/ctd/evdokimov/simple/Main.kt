package ru.ifmo.ctd.evdokimov.simple

import ru.ifmo.ctd.evdokimov.simple.antlr.ExprLexer

fun main(args: Array<String>) {
    println("Hello")
    val lexer = ExprLexer(null)
    for (ruleName in lexer.getRuleNames()) {
        println(ruleName)
    }
}