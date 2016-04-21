package ru.ifmo.ctd.evdokimov.simple

import ru.ifmo.ctd.evdokimov.simple.antlr.CalcBaseListener
import ru.ifmo.ctd.evdokimov.simple.antlr.CalcParser
import java.util.*


enum class OpType {
    ADD, ASSIGN, PRINT;
}

class Op(
        val type: OpType,
        val a: Any?,
        val b: Any?,
        val res: Any?) {

    override fun toString(): String {
        return "$type: a=$a, b=$b, res=$res"
    }
}

class CalcListener : CalcBaseListener() {
    val stackExpr = Stack<Any>()
    var indTempVar = 0;

    val ops = ArrayList<Op>();

    override fun exitAdd(ctx: CalcParser.AddContext) {
        val a = stackExpr.pop()
        val b = stackExpr.pop()
        ops.add(Op(OpType.ADD, b, a, "#$indTempVar"))
        stackExpr.push("#$indTempVar")
        ++indTempVar
    }

    override fun exitNumber(ctx: CalcParser.NumberContext) {
        stackExpr.push(ctx.NUM().toString().toInt())
    }

    override fun exitVar(ctx: CalcParser.VarContext) {
        stackExpr.push(ctx.ID().toString())
    }

    override fun enterAssign(ctx: CalcParser.AssignContext) {
        stackExpr.clear()
    }

    override fun exitAssign(ctx: CalcParser.AssignContext) {
        val id = ctx.ID().toString()
        val expr = ctx.expr();

        ops.add(Op(OpType.ASSIGN, stackExpr.pop(), null, id))
    }

    override fun exitPrint(ctx: CalcParser.PrintContext) {
        ops.add(Op(OpType.PRINT, ctx.ID().toString(), null, null))
    }


}