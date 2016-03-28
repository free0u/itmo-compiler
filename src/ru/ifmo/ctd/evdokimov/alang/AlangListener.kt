package ru.ifmo.ctd.evdokimov.alang

import ru.ifmo.ctd.evdokimov.alang.antlr.AlangBaseListener
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import java.util.*

class AlangListener : AlangBaseListener() {
    val globalVarScope = VarScope();
    var inGlobalScope = false;

    val scopes = ArrayList<VarScope>();
    var varIdx = 0;

    val stackExpr = Stack<Any>()

    val ops = ArrayList<Op>();

    fun printScopes() {
        for (scope in scopes) {
            println(scopes)
        }
    }

    override fun exitGlobalVars(ctx: AlangParser.GlobalVarsContext) {
        inGlobalScope = false;
    }

    override fun enterGlobalVars(ctx: AlangParser.GlobalVarsContext) {
        inGlobalScope = true;
    }

    override fun exitVarDecl(ctx: AlangParser.VarDeclContext) {
        val name = ctx.`var`().ID().text
        val type = ctx.type().text
        if (inGlobalScope) {
            globalVarScope.put(name, VarDescr(name, VarTypes.parse(type), -1))
        } else {
            scopes.last().put(name, VarDescr(name, VarTypes.parse(type), varIdx))
            varIdx++
        }
    }

    override fun enterFuncDef(ctx: AlangParser.FuncDefContext) {
        scopes.clear()
        scopes.add(globalVarScope)
    }

    override fun enterScope(ctx: AlangParser.ScopeContext) {
        scopes.add(VarScope())
    }

    override fun exitScope(ctx: AlangParser.ScopeContext) {
        scopes.removeAt(scopes.size - 1)
    }

    override fun enterPrintStatement(ctx: AlangParser.PrintStatementContext) {
        val v = ctx.expr().text
        val op = Op(OpType.PRINT, OpArg(ArgType.INT, v.toInt()), OpArg.empty, OpArg.empty)
        println(op)
    }

    /////////////////////////////////////////////////
    //
    // stackExpr : Int | String (bool) | VarDescr for idx

    override fun exitNumExpr(ctx: AlangParser.NumExprContext) {
        val v = ctx.NUM().text.toInt()
        stackExpr.push(v)
    }

    override fun exitVarExpr(ctx: AlangParser.VarExprContext) {
        val varName = ctx.`var`().text
        var descr : VarDescr? = null
        for (scope in scopes) {
            if (scope.containsKey(varName)) {
                descr = scope.get(varName)
            }
        }
        if (descr == null) {
            printScopes()
            error("var $varName not found in scopes")
        } else {
            stackExpr.push(descr)
        }
    }

    override fun exitBoolExpr(ctx: AlangParser.BoolExprContext) {
        val v = ctx.boolConst().text
        stackExpr.push(v)
    }

    override fun exitAddExpr(ctx: AlangParser.AddExprContext) {
        val opSign = ctx.op.text
        val opType = if (opSign.equals("+")) OpType.IADD else OpType.ISUB
        val b = stackExpr.pop()
        val a = stackExpr.pop()

        var av : OpArg
        if (a is Int) {
            av = OpArg.int(a)
        } else if (a is VarDescr) {
            if (a.type != VarTypes.INT) {
                error("Wrong type for first operand for $opSign: $a")
            }
            av = OpArg.idx(a.id)
        } else {
            error("wrong type of operand in $opType: $a")
        }

        var bv : OpArg
        if (b is Int) {
            bv = OpArg.int(b)
        } else if (b is VarDescr) {
            if (b.type != VarTypes.INT) {
                error("Wrong type for second operand for $opSign: $b")
            }
            bv = OpArg.idx(b.id)
        } else {
            error("wrong type of operand in $opType: $b")
        }

        stackExpr.push(VarDescr("#$varIdx", VarTypes.INT, varIdx))
        val op = Op(opType, av, bv, OpArg.idx(varIdx))
        println(op)
        ops.add(op)
        varIdx++
    }

    override fun exitProgram(ctx: AlangParser.ProgramContext) {
    }
}