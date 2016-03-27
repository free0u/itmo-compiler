// Generated from D:/Programming/compiler-course/src/ru/ifmo/ctd/evdokimov/alang\Alang.g4 by ANTLR 4.5.1
package ru.ifmo.ctd.evdokimov.alang.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, ID=24, NUM=25, 
		WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "ID", "NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'()'", "'{'", "'}'", "'='", "'while'", "'('", "')'", "'if'", 
		"'else'", "'print'", "'write'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", 
		"'int'", "'bool'", "'void'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "NUM", "WS"
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


	public AlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Alang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u009d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u0088\n\31\f\31\16\31\u008b"+
		"\13\31\3\32\5\32\u008e\n\32\3\32\3\32\7\32\u0092\n\32\f\32\16\32\u0095"+
		"\13\32\3\33\6\33\u0098\n\33\r\33\16\33\u0099\3\33\3\33\2\2\34\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\b\4\2C\\c|\5\2\62"+
		";C\\c|\4\2--//\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\u00a0\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7<\3\2\2\2\t>\3\2\2"+
		"\2\13@\3\2\2\2\rB\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23L\3\2\2\2\25O\3\2"+
		"\2\2\27T\3\2\2\2\31Z\3\2\2\2\33`\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2!f\3\2"+
		"\2\2#h\3\2\2\2%j\3\2\2\2\'l\3\2\2\2)p\3\2\2\2+u\3\2\2\2-z\3\2\2\2/\177"+
		"\3\2\2\2\61\u0085\3\2\2\2\63\u008d\3\2\2\2\65\u0097\3\2\2\2\678\7=\2\2"+
		"8\4\3\2\2\29:\7*\2\2:;\7+\2\2;\6\3\2\2\2<=\7}\2\2=\b\3\2\2\2>?\7\177\2"+
		"\2?\n\3\2\2\2@A\7?\2\2A\f\3\2\2\2BC\7y\2\2CD\7j\2\2DE\7k\2\2EF\7n\2\2"+
		"FG\7g\2\2G\16\3\2\2\2HI\7*\2\2I\20\3\2\2\2JK\7+\2\2K\22\3\2\2\2LM\7k\2"+
		"\2MN\7h\2\2N\24\3\2\2\2OP\7g\2\2PQ\7n\2\2QR\7u\2\2RS\7g\2\2S\26\3\2\2"+
		"\2TU\7r\2\2UV\7t\2\2VW\7k\2\2WX\7p\2\2XY\7v\2\2Y\30\3\2\2\2Z[\7y\2\2["+
		"\\\7t\2\2\\]\7k\2\2]^\7v\2\2^_\7g\2\2_\32\3\2\2\2`a\7-\2\2a\34\3\2\2\2"+
		"bc\7/\2\2c\36\3\2\2\2de\7,\2\2e \3\2\2\2fg\7\61\2\2g\"\3\2\2\2hi\7>\2"+
		"\2i$\3\2\2\2jk\7@\2\2k&\3\2\2\2lm\7k\2\2mn\7p\2\2no\7v\2\2o(\3\2\2\2p"+
		"q\7d\2\2qr\7q\2\2rs\7q\2\2st\7n\2\2t*\3\2\2\2uv\7x\2\2vw\7q\2\2wx\7k\2"+
		"\2xy\7f\2\2y,\3\2\2\2z{\7v\2\2{|\7t\2\2|}\7w\2\2}~\7g\2\2~.\3\2\2\2\177"+
		"\u0080\7h\2\2\u0080\u0081\7c\2\2\u0081\u0082\7n\2\2\u0082\u0083\7u\2\2"+
		"\u0083\u0084\7g\2\2\u0084\60\3\2\2\2\u0085\u0089\t\2\2\2\u0086\u0088\t"+
		"\3\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\62\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\t\4\2"+
		"\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0093"+
		"\t\5\2\2\u0090\u0092\t\6\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\64\3\2\2\2\u0095\u0093\3\2\2"+
		"\2\u0096\u0098\t\7\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\33\2\2"+
		"\u009c\66\3\2\2\2\7\2\u0089\u008d\u0093\u0099\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}