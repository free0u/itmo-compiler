// Generated from D:/Programming/compiler-course/src/ru/ifmo/ctd/evdokimov/simple\Calc.g4 by ANTLR 4.5.1
package ru.ifmo.ctd.evdokimov.simple.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NUM=3, ID=4, WS=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "NUM", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "NUM", "ID", "WS"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7)\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\4\5\4\23\n\4\3\4\3\4"+
		"\7\4\27\n\4\f\4\16\4\32\13\4\3\5\3\5\7\5\36\n\5\f\5\16\5!\13\5\3\6\6\6"+
		"$\n\6\r\6\16\6%\3\6\3\6\2\2\7\3\3\5\4\7\5\t\6\13\7\3\2\b\4\2--//\3\2\63"+
		";\3\2\62;\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17\"\",\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\17\3\2"+
		"\2\2\7\22\3\2\2\2\t\33\3\2\2\2\13#\3\2\2\2\r\16\7?\2\2\16\4\3\2\2\2\17"+
		"\20\7-\2\2\20\6\3\2\2\2\21\23\t\2\2\2\22\21\3\2\2\2\22\23\3\2\2\2\23\24"+
		"\3\2\2\2\24\30\t\3\2\2\25\27\t\4\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\b\3\2\2\2\32\30\3\2\2\2\33\37\t\5\2\2\34\36"+
		"\t\6\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \n\3\2\2"+
		"\2!\37\3\2\2\2\"$\t\7\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'"+
		"\3\2\2\2\'(\b\6\2\2(\f\3\2\2\2\7\2\22\30\37%\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}