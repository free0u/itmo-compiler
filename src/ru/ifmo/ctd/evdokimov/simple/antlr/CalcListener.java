// Generated from D:/Programming/compiler-course/src/ru/ifmo/ctd/evdokimov/simple\Calc.g4 by ANTLR 4.5.1
package ru.ifmo.ctd.evdokimov.simple.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalcParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalcParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CalcParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CalcParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CalcParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CalcParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CalcParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CalcParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalcParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalcParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(CalcParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(CalcParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CalcParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CalcParser.PrintContext ctx);
}