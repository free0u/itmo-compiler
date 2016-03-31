// Generated from D:/MyDocs/compiler-course/src/ru/ifmo/ctd/evdokimov/alang\Alang.g4 by ANTLR 4.5.1
package ru.ifmo.ctd.evdokimov.alang.antlr;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		ID=32, NUM=33, WS=34;
	public static final int
		RULE_program = 0, RULE_globalVars = 1, RULE_funcs = 2, RULE_topLevelDecl = 3, 
		RULE_varDecl = 4, RULE_type = 5, RULE_funcDef = 6, RULE_funArgs = 7, RULE_scope = 8, 
		RULE_statements = 9, RULE_statement = 10, RULE_assign = 11, RULE_procStatement = 12, 
		RULE_whileStatement = 13, RULE_returnStatement = 14, RULE_whileScope = 15, 
		RULE_ifStatement = 16, RULE_ifThenScope = 17, RULE_ifElseScope = 18, RULE_readStatement = 19, 
		RULE_printStatement = 20, RULE_expr = 21, RULE_exprList = 22, RULE_funArg = 23, 
		RULE_var = 24, RULE_funcName = 25, RULE_intType = 26, RULE_boolType = 27, 
		RULE_voidType = 28, RULE_boolConst = 29;
	public static final String[] ruleNames = {
		"program", "globalVars", "funcs", "topLevelDecl", "varDecl", "type", "funcDef", 
		"funArgs", "scope", "statements", "statement", "assign", "procStatement", 
		"whileStatement", "returnStatement", "whileScope", "ifStatement", "ifThenScope", 
		"ifElseScope", "readStatement", "printStatement", "expr", "exprList", 
		"funArg", "var", "funcName", "intType", "boolType", "voidType", "boolConst"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'{'", "'}'", "'='", "'while'", "'return'", 
		"'if'", "'else'", "'read'", "'print'", "'*'", "'/'", "'%'", "'+'", "'-'", 
		"'<'", "'>'", "'>='", "'<='", "'!='", "'=='", "'&&'", "'||'", "'int'", 
		"'bool'", "'void'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "ID", "NUM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Alang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public GlobalVarsContext globalVars() {
			return getRuleContext(GlobalVarsContext.class,0);
		}
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			globalVars();
			setState(61);
			funcs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalVarsContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public GlobalVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterGlobalVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitGlobalVars(this);
		}
	}

	public final GlobalVarsContext globalVars() throws RecognitionException {
		GlobalVarsContext _localctx = new GlobalVarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalVars);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					varDecl();
					setState(64);
					match(T__0);
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncsContext extends ParserRuleContext {
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public FuncsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterFuncs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitFuncs(this);
		}
	}

	public final FuncsContext funcs() throws RecognitionException {
		FuncsContext _localctx = new FuncsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				{
				setState(71);
				funcDef();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelDeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitTopLevelDecl(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_topLevelDecl);
		try {
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				varDecl();
				setState(78);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				funcDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			type();
			setState(84);
			var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public BoolTypeContext boolType() {
			return getRuleContext(BoolTypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(89);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				intType();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				boolType();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				voidType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public FunArgsContext funArgs() {
			return getRuleContext(FunArgsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitFuncDef(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			type();
			setState(92);
			funcName();
			setState(93);
			match(T__1);
			setState(95);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				setState(94);
				funArgs();
				}
			}

			setState(97);
			match(T__2);
			setState(98);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunArgsContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public FunArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterFunArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitFunArgs(this);
		}
	}

	public final FunArgsContext funArgs() throws RecognitionException {
		FunArgsContext _localctx = new FunArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			varDecl();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(101);
				match(T__3);
				setState(102);
				varDecl();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitScope(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__4);
			setState(109);
			statements();
			setState(110);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << ID))) != 0)) {
				{
				{
				setState(112);
				statement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public ProcStatementContext procStatement() {
			return getRuleContext(ProcStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(138);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				varDecl();
				setState(119);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				assign();
				setState(122);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				printStatement();
				setState(127);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				readStatement();
				setState(130);
				match(T__0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(132);
				procStatement();
				setState(133);
				match(T__0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				returnStatement();
				setState(136);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			var();
			setState(141);
			match(T__6);
			setState(142);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcStatementContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ProcStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterProcStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitProcStatement(this);
		}
	}

	public final ProcStatementContext procStatement() throws RecognitionException {
		ProcStatementContext _localctx = new ProcStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_procStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			funcName();
			setState(145);
			match(T__1);
			setState(147);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(146);
				exprList();
				}
			}

			setState(149);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileScopeContext whileScope() {
			return getRuleContext(WhileScopeContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__7);
			setState(152);
			match(T__1);
			setState(153);
			expr(0);
			setState(154);
			match(T__2);
			setState(155);
			whileScope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__8);
			setState(159);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(158);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileScopeContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public WhileScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterWhileScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitWhileScope(this);
		}
	}

	public final WhileScopeContext whileScope() throws RecognitionException {
		WhileScopeContext _localctx = new WhileScopeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfThenScopeContext ifThenScope() {
			return getRuleContext(IfThenScopeContext.class,0);
		}
		public IfElseScopeContext ifElseScope() {
			return getRuleContext(IfElseScopeContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__9);
			setState(164);
			match(T__1);
			setState(165);
			expr(0);
			setState(166);
			match(T__2);
			setState(167);
			ifThenScope();
			setState(168);
			match(T__10);
			setState(169);
			ifElseScope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenScopeContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IfThenScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterIfThenScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitIfThenScope(this);
		}
	}

	public final IfThenScopeContext ifThenScope() throws RecognitionException {
		IfThenScopeContext _localctx = new IfThenScopeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifThenScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseScopeContext extends ParserRuleContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IfElseScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterIfElseScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitIfElseScope(this);
		}
	}

	public final IfElseScopeContext ifElseScope() throws RecognitionException {
		IfElseScopeContext _localctx = new IfElseScopeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifElseScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadStatementContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitReadStatement(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_readStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__11);
			setState(176);
			match(T__1);
			setState(177);
			var();
			setState(178);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__12);
			setState(181);
			match(T__1);
			setState(182);
			expr(0);
			setState(183);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitMulExpr(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public BoolConstContext boolConst() {
			return getRuleContext(BoolConstContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitBoolExpr(this);
		}
	}
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(AlangParser.NUM, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitNumExpr(this);
		}
	}
	public static class BoolCompExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolCompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterBoolCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitBoolCompExpr(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitParExpr(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitVarExpr(this);
		}
	}
	public static class CallExprContext extends ExprContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public CallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitCallExpr(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitAddExpr(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitCompExpr(this);
		}
	}
	public static class EqCompExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqCompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterEqCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitEqCompExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				match(NUM);
				}
				break;
			case 2:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				boolConst();
				}
				break;
			case 3:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				var();
				}
				break;
			case 4:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				funcName();
				setState(190);
				match(T__1);
				setState(192);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__29) | (1L << T__30) | (1L << ID) | (1L << NUM))) != 0)) {
					{
					setState(191);
					exprList();
					}
				}

				setState(194);
				match(T__2);
				}
				break;
			case 5:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(T__1);
				setState(197);
				expr(0);
				setState(198);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MulExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(203);
						((MulExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(204);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(206);
						((AddExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(207);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(209);
						((CompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(210);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new EqCompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(212);
						((EqCompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((EqCompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(213);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new BoolCompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(215);
						((BoolCompExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((BoolCompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(216);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<FunArgContext> funArg() {
			return getRuleContexts(FunArgContext.class);
		}
		public FunArgContext funArg(int i) {
			return getRuleContext(FunArgContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			funArg();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(223);
				match(T__3);
				setState(224);
				funArg();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunArgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterFunArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitFunArg(this);
		}
	}

	public final FunArgContext funArg() throws RecognitionException {
		FunArgContext _localctx = new FunArgContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitFuncName(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntTypeContext extends ParserRuleContext {
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitIntType(this);
		}
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolTypeContext extends ParserRuleContext {
		public BoolTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitBoolType(this);
		}
	}

	public final BoolTypeContext boolType() throws RecognitionException {
		BoolTypeContext _localctx = new BoolTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_boolType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidTypeContext extends ParserRuleContext {
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitVoidType(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolConstContext extends ParserRuleContext {
		public BoolConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).enterBoolConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AlangListener ) ((AlangListener)listener).exitBoolConst(this);
		}
	}

	public final BoolConstContext boolConst() throws RecognitionException {
		BoolConstContext _localctx = new BoolConstContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_boolConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( !(_la==T__29 || _la==T__30) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u00f7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\4\7\4K\n\4\f\4\16\4N\13\4\3\5"+
		"\3\5\3\5\3\5\5\5T\n\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3"+
		"\b\5\bb\n\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tj\n\t\f\t\16\tm\13\t\3\n\3\n\3"+
		"\n\3\n\3\13\7\13t\n\13\f\13\16\13w\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008d\n\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\5\16\u0096\n\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\5\20\u00a2\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00c3\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u00cb\n\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00dc\n\27\f\27\16"+
		"\27\u00df\13\27\3\30\3\30\3\30\7\30\u00e4\n\30\f\30\16\30\u00e7\13\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3\37\2\3, \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<\2\b\3\2\20\22\3\2\23\24\3\2\25\30\3\2\31\32\3\2\33\34\3\2 !\u00f4"+
		"\2>\3\2\2\2\4F\3\2\2\2\6L\3\2\2\2\bS\3\2\2\2\nU\3\2\2\2\f[\3\2\2\2\16"+
		"]\3\2\2\2\20f\3\2\2\2\22n\3\2\2\2\24u\3\2\2\2\26\u008c\3\2\2\2\30\u008e"+
		"\3\2\2\2\32\u0092\3\2\2\2\34\u0099\3\2\2\2\36\u009f\3\2\2\2 \u00a3\3\2"+
		"\2\2\"\u00a5\3\2\2\2$\u00ad\3\2\2\2&\u00af\3\2\2\2(\u00b1\3\2\2\2*\u00b6"+
		"\3\2\2\2,\u00ca\3\2\2\2.\u00e0\3\2\2\2\60\u00e8\3\2\2\2\62\u00ea\3\2\2"+
		"\2\64\u00ec\3\2\2\2\66\u00ee\3\2\2\28\u00f0\3\2\2\2:\u00f2\3\2\2\2<\u00f4"+
		"\3\2\2\2>?\5\4\3\2?@\5\6\4\2@\3\3\2\2\2AB\5\n\6\2BC\7\3\2\2CE\3\2\2\2"+
		"DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\5\3\2\2\2HF\3\2\2\2IK\5\16\b"+
		"\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NL\3\2\2\2OP\5\n"+
		"\6\2PQ\7\3\2\2QT\3\2\2\2RT\5\16\b\2SO\3\2\2\2SR\3\2\2\2T\t\3\2\2\2UV\5"+
		"\f\7\2VW\5\62\32\2W\13\3\2\2\2X\\\5\66\34\2Y\\\58\35\2Z\\\5:\36\2[X\3"+
		"\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\r\3\2\2\2]^\5\f\7\2^_\5\64\33\2_a\7\4\2\2"+
		"`b\5\20\t\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\5\2\2de\5\22\n\2e\17\3\2"+
		"\2\2fk\5\n\6\2gh\7\6\2\2hj\5\n\6\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2l\21\3\2\2\2mk\3\2\2\2no\7\7\2\2op\5\24\13\2pq\7\b\2\2q\23\3\2\2\2"+
		"rt\5\26\f\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\25\3\2\2\2wu\3\2"+
		"\2\2xy\5\n\6\2yz\7\3\2\2z\u008d\3\2\2\2{|\5\30\r\2|}\7\3\2\2}\u008d\3"+
		"\2\2\2~\u008d\5\"\22\2\177\u008d\5\34\17\2\u0080\u0081\5*\26\2\u0081\u0082"+
		"\7\3\2\2\u0082\u008d\3\2\2\2\u0083\u0084\5(\25\2\u0084\u0085\7\3\2\2\u0085"+
		"\u008d\3\2\2\2\u0086\u0087\5\32\16\2\u0087\u0088\7\3\2\2\u0088\u008d\3"+
		"\2\2\2\u0089\u008a\5\36\20\2\u008a\u008b\7\3\2\2\u008b\u008d\3\2\2\2\u008c"+
		"x\3\2\2\2\u008c{\3\2\2\2\u008c~\3\2\2\2\u008c\177\3\2\2\2\u008c\u0080"+
		"\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0089\3\2\2\2\u008d"+
		"\27\3\2\2\2\u008e\u008f\5\62\32\2\u008f\u0090\7\t\2\2\u0090\u0091\5,\27"+
		"\2\u0091\31\3\2\2\2\u0092\u0093\5\64\33\2\u0093\u0095\7\4\2\2\u0094\u0096"+
		"\5.\30\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\7\5\2\2\u0098\33\3\2\2\2\u0099\u009a\7\n\2\2\u009a\u009b\7\4\2"+
		"\2\u009b\u009c\5,\27\2\u009c\u009d\7\5\2\2\u009d\u009e\5 \21\2\u009e\35"+
		"\3\2\2\2\u009f\u00a1\7\13\2\2\u00a0\u00a2\5,\27\2\u00a1\u00a0\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\37\3\2\2\2\u00a3\u00a4\5\22\n\2\u00a4!\3\2"+
		"\2\2\u00a5\u00a6\7\f\2\2\u00a6\u00a7\7\4\2\2\u00a7\u00a8\5,\27\2\u00a8"+
		"\u00a9\7\5\2\2\u00a9\u00aa\5$\23\2\u00aa\u00ab\7\r\2\2\u00ab\u00ac\5&"+
		"\24\2\u00ac#\3\2\2\2\u00ad\u00ae\5\22\n\2\u00ae%\3\2\2\2\u00af\u00b0\5"+
		"\22\n\2\u00b0\'\3\2\2\2\u00b1\u00b2\7\16\2\2\u00b2\u00b3\7\4\2\2\u00b3"+
		"\u00b4\5\62\32\2\u00b4\u00b5\7\5\2\2\u00b5)\3\2\2\2\u00b6\u00b7\7\17\2"+
		"\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5,\27\2\u00b9\u00ba\7\5\2\2\u00ba+"+
		"\3\2\2\2\u00bb\u00bc\b\27\1\2\u00bc\u00cb\7#\2\2\u00bd\u00cb\5<\37\2\u00be"+
		"\u00cb\5\62\32\2\u00bf\u00c0\5\64\33\2\u00c0\u00c2\7\4\2\2\u00c1\u00c3"+
		"\5.\30\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\7\5\2\2\u00c5\u00cb\3\2\2\2\u00c6\u00c7\7\4\2\2\u00c7\u00c8\5,"+
		"\27\2\u00c8\u00c9\7\5\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00bb\3\2\2\2\u00ca"+
		"\u00bd\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00c6\3\2"+
		"\2\2\u00cb\u00dd\3\2\2\2\u00cc\u00cd\f\b\2\2\u00cd\u00ce\t\2\2\2\u00ce"+
		"\u00dc\5,\27\t\u00cf\u00d0\f\7\2\2\u00d0\u00d1\t\3\2\2\u00d1\u00dc\5,"+
		"\27\b\u00d2\u00d3\f\6\2\2\u00d3\u00d4\t\4\2\2\u00d4\u00dc\5,\27\7\u00d5"+
		"\u00d6\f\5\2\2\u00d6\u00d7\t\5\2\2\u00d7\u00dc\5,\27\6\u00d8\u00d9\f\4"+
		"\2\2\u00d9\u00da\t\6\2\2\u00da\u00dc\5,\27\5\u00db\u00cc\3\2\2\2\u00db"+
		"\u00cf\3\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d8\3\2"+
		"\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"-\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e5\5\60\31\2\u00e1\u00e2\7\6\2"+
		"\2\u00e2\u00e4\5\60\31\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6/\3\2\2\2\u00e7\u00e5\3\2\2\2"+
		"\u00e8\u00e9\5,\27\2\u00e9\61\3\2\2\2\u00ea\u00eb\7\"\2\2\u00eb\63\3\2"+
		"\2\2\u00ec\u00ed\7\"\2\2\u00ed\65\3\2\2\2\u00ee\u00ef\7\35\2\2\u00ef\67"+
		"\3\2\2\2\u00f0\u00f1\7\36\2\2\u00f19\3\2\2\2\u00f2\u00f3\7\37\2\2\u00f3"+
		";\3\2\2\2\u00f4\u00f5\t\7\2\2\u00f5=\3\2\2\2\21FLS[aku\u008c\u0095\u00a1"+
		"\u00c2\u00ca\u00db\u00dd\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}