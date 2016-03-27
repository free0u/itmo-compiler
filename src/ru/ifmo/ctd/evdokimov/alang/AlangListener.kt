package ru.ifmo.ctd.evdokimov.alang

import ru.ifmo.ctd.evdokimov.alang.antlr.AlangBaseListener
import ru.ifmo.ctd.evdokimov.alang.antlr.AlangParser
import java.util.*

class AlangListener : AlangBaseListener() {
    val globalVarScope = VarScope();
    var inGlobalScope = false;

    val scopes = Stack<VarScope>();
    var varIdx = 0;

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
            scopes.peek().put(name, VarDescr(name, VarTypes.parse(type), varIdx))
            varIdx++
        }
    }

    override fun enterFuncDef(ctx: AlangParser.FuncDefContext) {
        scopes.clear()
        scopes.push(globalVarScope)
    }

    override fun enterScope(ctx: AlangParser.ScopeContext) {
        scopes.push(VarScope())
    }

    override fun exitScope(ctx: AlangParser.ScopeContext) {
        scopes.pop()
    }

    override fun exitProgram(ctx: AlangParser.ProgramContext) {
    }
}