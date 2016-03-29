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

//    override fun enterPrintStatement(ctx: AlangParser.PrintStatementContext) {
//        val v = ctx.expr().text
//        val op = Op(OpType.PRINT, OpArg(ArgType.INT, v.toInt()), OpArg.empty, OpArg.empty)
//        println(op)
//    }

    override fun exitPrintStatement(ctx: AlangParser.PrintStatementContext) {
        val res = stackExpr.pop()
        val op = when (res) {
            is Int -> Op(OpType.PRINT, OpArg.int(res), OpArg.empty, OpArg.empty)
            is String -> Op(OpType.PRINT, OpArg.bool(res), OpArg.empty, OpArg.empty)
            is VarDescr -> Op(OpType.PRINT, OpArg.idx(res.id), OpArg.empty, OpArg.empty)
            else -> error("Unexpected type in stackExpr: $res")
        }
        ops.add(op)
        println(op)
    }

    override fun exitAssign(ctx: AlangParser.AssignContext) {
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
//            stackExpr.push(descr)
            val res = stackExpr.pop()
            val to = OpArg.idx(descr.id)
            val op : Op
            if (res is Int) {
                if (descr.type != VarTypes.INT) {
                    error("Type mismatch var=$descr but expr=INT")
                }
                op = Op(OpType.ASSIGN, OpArg.int(res), OpArg.empty, to)
            } else if (res is String) {
                if (descr.type != VarTypes.BOOL) {
                    error("Type mismatch var=$descr but expr=BOOL")
                }
                op = Op(OpType.ASSIGN, OpArg.bool(res), OpArg.empty, to)
            } else if (res is VarDescr) {
                if (descr.type != res.type) {
                    error("Type mismatch var=$descr but expr=${res.type}")
                }
                op = Op(OpType.ASSIGN, OpArg.idx(res.id), OpArg.empty, to)
            } else {
                error("Unexpected type in stackExpr: $res")
            }
            ops.add(op)
            println(op)
        }
    }

    /////////////////////////////////////////////////
    // expressions
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

    // + and -
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

    // * and /
    override fun exitMulExpr(ctx: AlangParser.MulExprContext) {
        val opSign = ctx.op.text
        val opType = when (opSign) {
            "*" -> OpType.IMUL
            "/" -> OpType.IDIV
            "%" -> OpType.IMOD
            else -> error("Unexpected sign in MulExpr: $opSign")
        }

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

    override fun exitBoolCompExpr(ctx: AlangParser.BoolCompExprContext) {
        val opSign = ctx.op.text
        val opType = when (opSign) {
            "&&" -> OpType.BAND
            "||" -> OpType.BOR
            else -> error("Unexpected sign in MulExpr: $opSign")
        }

        val b = stackExpr.pop()
        val a = stackExpr.pop()

        var av : OpArg
        if (a is String) {
            av = OpArg.bool(a)
        } else if (a is VarDescr) {
            if (a.type != VarTypes.BOOL) {
                error("Wrong type for first operand for $opSign: $a")
            }
            av = OpArg.idx(a.id)
        } else {
            error("wrong type of operand in $opType: $a")
        }

        var bv : OpArg
        if (b is String) {
            bv = OpArg.bool(b)
        } else if (b is VarDescr) {
            if (b.type != VarTypes.BOOL) {
                error("Wrong type for second operand for $opSign: $b")
            }
            bv = OpArg.idx(b.id)
        } else {
            error("wrong type of operand in $opType: $b")
        }

        stackExpr.push(VarDescr("#$varIdx", VarTypes.BOOL, varIdx))
        val op = Op(opType, av, bv, OpArg.idx(varIdx))
        println(op)
        ops.add(op)
        varIdx++
    }

    // > < >= <=
    override fun exitCompExpr(ctx: AlangParser.CompExprContext) {
        val opSign = ctx.op.text
        val opType = when (opSign) {
            "<" -> OpType.IL
            ">" -> OpType.IG
            "<=" -> OpType.ILE
            ">=" -> OpType.IGE
            else -> error("Unexpected sign in CompExpr: $opSign")
        }

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

        stackExpr.push(VarDescr("#$varIdx", VarTypes.BOOL, varIdx))
        val op = Op(opType, av, bv, OpArg.idx(varIdx))
        println(op)
        ops.add(op)
        varIdx++
    }


    // == !=
    override fun exitEqCompExpr(ctx: AlangParser.EqCompExprContext) {
        val opSign = ctx.op.text
        val opType = when (opSign) {
            "==" -> OpType.EQ
            "!=" -> OpType.NEQ
            else -> error("Unexpected sign in CompExpr: $opSign")
        }

        val b = stackExpr.pop()
        val a = stackExpr.pop()

        var av : OpArg
        var at : VarTypes
        when (a) {
            is Int -> {
                at = VarTypes.INT
                av = OpArg.int(a)
            }
            is String -> {
                at = VarTypes.BOOL
                av = OpArg.bool(a)
            }
            is VarDescr -> {
                at = a.type
                av = OpArg.idx(a.id)
            }
            else -> error("Wrong type for first operand for $opSign: $a")
        }
        var bv : OpArg
        var bt : VarTypes
        when (b) {
            is Int -> {
                bt = VarTypes.INT
                bv = OpArg.int(b)
            }
            is String -> {
                bt = VarTypes.BOOL
                bv = OpArg.bool(b)
            }
            is VarDescr -> {
                bt = b.type
                bv = OpArg.idx(b.id)
            }
            else -> error("Wrong type for second operand for $opSign: $b")
        }

        if (at == VarTypes.INT && bt != VarTypes.INT) {
            error("Type mismatch: $a not equat $b")
        }
        if (at == VarTypes.BOOL && bt != VarTypes.BOOL) {
            error("Type mismatch: $a not equat $b")
        }

        stackExpr.push(VarDescr("#$varIdx", VarTypes.BOOL, varIdx))
        val op = Op(opType, av, bv, OpArg.idx(varIdx))
        println(op)
        ops.add(op)
        varIdx++
    }

    ////////////////////////////////////////////////////////
    // if and while
    val labelsStack = Stack<Int>()
    var labelInd = 0

    override fun enterIfStatement(ctx: AlangParser.IfStatementContext) {
        val labelElse = labelInd++
        val labelEnd = labelInd++
        labelsStack.push(labelEnd)
        labelsStack.push(labelElse)
        labelsStack.push(labelEnd)
        labelsStack.push(labelElse)
    }

    override fun enterIfThenScope(ctx: AlangParser.IfThenScopeContext) {
        val labelElse = labelsStack.pop()

        val res = stackExpr.pop()
        val arg : OpArg
        if (res is String) {
            arg = OpArg.bool(res)
        } else if (res is VarDescr && res.type == VarTypes.BOOL) {
            arg = OpArg.idx(res.id)
        } else {
            error("Wrong expr for if: $res")
        }

        val op = Op(OpType.JMPF, arg, OpArg.label(labelElse), OpArg.empty)
        ops.add(op)
        println(op)
    }

    override fun exitIfThenScope(ctx: AlangParser.IfThenScopeContext) {
        val labelEnd = labelsStack.pop()
        val labelElse = labelsStack.pop()

        var op = Op(OpType.JMP, OpArg.label(labelEnd), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)

        op = Op(OpType.LABEL, OpArg.label(labelElse), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)
    }

    override fun exitIfElseScope(ctx: AlangParser.IfElseScopeContext) {
        val labelEnd = labelsStack.pop()
        var op = Op(OpType.LABEL, OpArg.label(labelEnd), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)
    }

    //////////////////////////////////////////////////////////////
    // while


    override fun enterWhileStatement(ctx: AlangParser.WhileStatementContext) {
        val labelEnd = labelInd++
        val labelBegin = labelInd++

        val op = Op(OpType.LABEL, OpArg.label(labelBegin), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)

        labelsStack.push(labelEnd)
        labelsStack.push(labelBegin)
        labelsStack.push(labelEnd)
    }

    override fun enterWhileScope(ctx: AlangParser.WhileScopeContext) {
        val labelEnd = labelsStack.pop()

        val res = stackExpr.pop()
        val arg : OpArg
        if (res is String) {
            arg = OpArg.bool(res)
        } else if (res is VarDescr && res.type == VarTypes.BOOL) {
            arg = OpArg.idx(res.id)
        } else {
            error("Wrong expr for if: $res")
        }

        val op = Op(OpType.JMPF, arg, OpArg.label(labelEnd), OpArg.empty)
        ops.add(op)
        println(op)


    }

    override fun exitWhileScope(ctx: AlangParser.WhileScopeContext) {
        val labelBegin = labelsStack.pop()
        val labelEnd = labelsStack.pop()

        var op = Op(OpType.JMP, OpArg.label(labelBegin), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)

        op = Op(OpType.LABEL, OpArg.label(labelEnd), OpArg.empty, OpArg.empty)
        ops.add(op)
        println(op)
    }


    override fun exitProgram(ctx: AlangParser.ProgramContext) {
    }
}