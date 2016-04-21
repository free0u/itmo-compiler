package ru.ifmo.ctd.evdokimov.alang

import ru.ifmo.ctd.evdokimov.alang.antlr.AlangBaseListener
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import java.util.*

class AlangFuncListener : AlangBaseListener() {
    val functionTypes = HashMap<String, String>()
    private var functionType = String()

    private var curFunction = String()

    private var inArgScope = false

    override fun exitVarDecl(ctx: AlangParser.VarDeclContext) {
        val type = ctx.type().text
        if (inArgScope) {
            functionType += when (type) {
                "int" -> "I"
                "bool" -> "Z"
                else -> error("Undefined arg type: $type")
            }
        }
    }

    override fun enterFuncDef(ctx: AlangParser.FuncDefContext) {
        val funcName = ctx.funcName().text
        curFunction = funcName

        val type = ctx.type().text
        functionType = when (type) {
            "int" -> "I"
            "bool" -> "Z"
            "void" -> "V"
            else -> error("Undefined return type for $funcName")
        }
    }

    override fun exitFuncDef(ctx: AlangParser.FuncDefContext) {
        functionTypes.put(curFunction, functionType)
    }

    override fun enterFunArgs(ctx: AlangParser.FunArgsContext) {
        inArgScope = true
    }

    override fun exitFunArgs(ctx: AlangParser.FunArgsContext) {
        inArgScope = false
    }
}