// Generated from D:/MyDocs/compiler-course/src/ru/ifmo/ctd/evdokimov/alang\Alang.g4 by ANTLR 4.5.1
package ru.ifmo.ctd.evdokimov.alang.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlangParser}.
 */
public interface AlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AlangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AlangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#globalVars}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVars(AlangParser.GlobalVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#globalVars}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVars(AlangParser.GlobalVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#funcs}.
	 * @param ctx the parse tree
	 */
	void enterFuncs(AlangParser.FuncsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#funcs}.
	 * @param ctx the parse tree
	 */
	void exitFuncs(AlangParser.FuncsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(AlangParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(AlangParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(AlangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(AlangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AlangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AlangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(AlangParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(AlangParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#funArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunArgs(AlangParser.FunArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#funArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunArgs(AlangParser.FunArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(AlangParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(AlangParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AlangParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AlangParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AlangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AlangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AlangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AlangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#procStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcStatement(AlangParser.ProcStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#procStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcStatement(AlangParser.ProcStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(AlangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(AlangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(AlangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(AlangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(AlangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(AlangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(AlangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(AlangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#whileScope}.
	 * @param ctx the parse tree
	 */
	void enterWhileScope(AlangParser.WhileScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#whileScope}.
	 * @param ctx the parse tree
	 */
	void exitWhileScope(AlangParser.WhileScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(AlangParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(AlangParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#switchScope}.
	 * @param ctx the parse tree
	 */
	void enterSwitchScope(AlangParser.SwitchScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#switchScope}.
	 * @param ctx the parse tree
	 */
	void exitSwitchScope(AlangParser.SwitchScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#caseScope}.
	 * @param ctx the parse tree
	 */
	void enterCaseScope(AlangParser.CaseScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#caseScope}.
	 * @param ctx the parse tree
	 */
	void exitCaseScope(AlangParser.CaseScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpr(AlangParser.CaseExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpr(AlangParser.CaseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(AlangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(AlangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#ifThenScope}.
	 * @param ctx the parse tree
	 */
	void enterIfThenScope(AlangParser.IfThenScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#ifThenScope}.
	 * @param ctx the parse tree
	 */
	void exitIfThenScope(AlangParser.IfThenScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#ifElseScope}.
	 * @param ctx the parse tree
	 */
	void enterIfElseScope(AlangParser.IfElseScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#ifElseScope}.
	 * @param ctx the parse tree
	 */
	void exitIfElseScope(AlangParser.IfElseScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(AlangParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(AlangParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(AlangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(AlangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(AlangParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(AlangParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(AlangParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(AlangParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(AlangParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(AlangParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolCompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolCompExpr(AlangParser.BoolCompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolCompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolCompExpr(AlangParser.BoolCompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(AlangParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(AlangParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(AlangParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(AlangParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(AlangParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(AlangParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(AlangParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(AlangParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(AlangParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(AlangParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqCompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqCompExpr(AlangParser.EqCompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqCompExpr}
	 * labeled alternative in {@link AlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqCompExpr(AlangParser.EqCompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(AlangParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(AlangParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#funArg}.
	 * @param ctx the parse tree
	 */
	void enterFunArg(AlangParser.FunArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#funArg}.
	 * @param ctx the parse tree
	 */
	void exitFunArg(AlangParser.FunArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(AlangParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(AlangParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(AlangParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(AlangParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#intType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(AlangParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#intType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(AlangParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#boolType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(AlangParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#boolType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(AlangParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(AlangParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(AlangParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlangParser#boolConst}.
	 * @param ctx the parse tree
	 */
	void enterBoolConst(AlangParser.BoolConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlangParser#boolConst}.
	 * @param ctx the parse tree
	 */
	void exitBoolConst(AlangParser.BoolConstContext ctx);
}