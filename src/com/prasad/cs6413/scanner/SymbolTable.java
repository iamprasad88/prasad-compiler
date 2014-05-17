package com.prasad.cs6413.scanner;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (Poly Id 0529494)
 * @version 1.1
 * 
 *          Implementation of a Symbol Table for looking up lexemes and mapping tokens
 * 
 */

import java.util.Hashtable;

public class SymbolTable {

	public static final String PROGRAM = "PROGRAM";
	public static final String PROGRAMPRIME = "PROGRAMPRIME";
	public static final String DECLARATIONS = "DECLARATIONS";
	public static final String DECLARATIONSPRIME = "DECLARATIONSPRIME";
	public static final String TYPE = "TYPE";
	public static final String STANDARDTYPE = "TANDARDTYPE";
	public static final String SUBPROGRAMDECLARATIONS = "SUBPROGRAMDECLARATIONS";
	public static final String SUBPROGRAMDECLARATIONSPRIME = "SUBPROGRAMDECLARATIONSPRIME";
	public static final String SUBPROGRAMDECLARATION = "SUBPROGRAMDECLARATION";
	public static final String SUBPROGRAMHEAD = "SUBPROGRAMHEAD";
	public static final String ARGUMENTS = "ARGUMENTS";
	public static final String PARAMETERLIST = "PARAMETERLIST";
	public static final String PARAMETERLISTPRIME = "PARAMETERLISTPRIME";
	public static final String COMPOUNDSTATEMENT = "COMPOUNDSTATEMENT";
	public static final String OPTIONALSTATEMENTS = "OPTIONALSTATEMENTS";
	public static final String STATEMENTLIST = "STATEMENTLIST";
	public static final String STATEMENTLISTPRIME = "STATEMENTLISTPRIME";
	public static final String STATEMENT = "STATEMENT";
	public static final String VARIABLE = "VARIABLE";
	public static final String PROCEDURESTATEMENT = "PROCEDURESTATEMENT";
	public static final String EXPRESSIONLIST = "EXPRESSIONLIST";
	public static final String EXPRESSIONLISTPRIME = "EXPRESSIONLISTPRIME";
	public static final String EXPRESSION = "EXPRESSION";
	public static final String SIMPLEEXPRESSION = "SIMPLEEXPRESSION";
	public static final String SIMPLEEXPRESSIONPRIME = "SIMPLEEXPRESSIONPRIME";
	public static final String TERM = "TERM";
	public static final String TERMPRIME = "TERMPRIME";
	public static final String FACTOR = "FACTOR";
	public static final String SIGN = "SIGN";
	public static final String IDLIST = "IDLIST";
	public static final String IDLISTPRIME = "IDLISTPRIME";

	public static final String ANDTOK = "ANDTOK";
	public static final String ARRAYTOK = "ARRAYTOK";
	public static final String ASMTOK = "ASMTOK";
	public static final String BEGINTOK = "BEGINTOK";
	public static final String BREAKTOK = "BREAKTOK";
	public static final String CASETOK = "CASETOK";
	public static final String CONSTTOK = "CONSTTOK";
	public static final String CONSTRUCTORTOK = "CONSTRUCTORTOK";
	public static final String CONTINUETOK = "CONTINUETOK";
	public static final String DESTRUCTORTOK = "DESTRUCTORTOK";
	public static final String DIVTOK = "DIVTOK";
	public static final String DOTOK = "DOTOK";
	public static final String DOWNTOTOK = "DOWNTOTOK";
	public static final String ELSETOK = "ELSETOK";
	public static final String ENDTOK = "ENDTOK";
	public static final String FALSETOK = "FALSETOK";
	public static final String FILETOK = "FILETOK";
	public static final String FORTOK = "FORTOK";
	public static final String FUNCTIONTOK = "FUNCTIONTOK";
	public static final String GOTOTOK = "GOTOTOK";
	public static final String IFTOK = "IFTOK";
	public static final String IMPLEMENTATIONTOK = "IMPLEMENTATIONTOK";
	public static final String INTOK = "INTOK";
	public static final String INLINETOK = "INLINETOK";
	public static final String INTERFACETOK = "INTERFACETOK";
	public static final String LABELTOK = "LABELTOK";
	public static final String MODTOK = "MODTOK";
	public static final String NILTOK = "NILTOK";
	public static final String NOTTOK = "NOTTOK";
	public static final String OBJECTTOK = "OBJECTTOK";
	public static final String OFTOK = "OFTOK";
	public static final String ONTOK = "ONTOK";
	public static final String OPERATORTOK = "OPERATORTOK";
	public static final String ORTOK = "ORTOK";
	public static final String PACKEDTOK = "PACKEDTOK";
	public static final String PROCEDURETOK = "PROCEDURETOK";
	public static final String PROGRAMTOKEN = "PROGRAMTOKEN";
	public static final String RECORDTOK = "RECORDTOK";
	public static final String REPEATTOK = "REPEATTOK";
	public static final String SETTOK = "SETTOK";
	public static final String SHLTOK = "SHLTOK";
	public static final String SHRTOK = "SHRTOK";
	public static final String STRINGTOK = "STRINGTOK";
	public static final String THENTOK = "THENTOK";
	public static final String TOTOK = "TOTOK";
	public static final String TRUETOK = "TRUETOK";
	public static final String TYPETOK = "TYPETOK";
	public static final String UNITTOK = "UNITTOK";
	public static final String UNTILTOK = "UNTILTOK";
	public static final String USESTOK = "USESTOK";
	public static final String VARTOK = "VARTOK";
	public static final String WHILETOK = "WHILETOK";
	public static final String WITHTOK = "WITHTOK";
	public static final String XOR = "XOR";
	public static final String SEMICOLONTOKEN = "SEMICOLONTOKEN";
	public static final String COLONTOKEN = "COLONTOKEN";
	public static final String STARTOKEN = "STARTOKEN";
	public static final String PLUSTOKEN = "PLUSTOKEN";
	public static final String MINUSTOKEN = "MINUSTOKEN";
	public static final String SLASHTOKEN = "SLASHTOKEN";
	public static final String EQUALSTOKEN = "EQUALSTOKEN";
	public static final String COMMATOKEN = "COMMATOKEN";
	public static final String PERIODTOKEN = "PERIODTOKEN";
	public static final String GREATERTOKEN = "GREATERTOKEN";
	public static final String LESSTOKEN = "LESSTOKEN";
	public static final String NOTEQUALTOKEN = "NOTEQUALTOKEN";
	public static final String OPENPARENTOKEN = "OPENPARENTOKEN";
	public static final String CLOSEPARENTOKEN = "CLOSEPARENTOKEN";
	public static final String ASSIGNTOKEN = "ASSIGNTOKEN";
	public static final String EPSILONTOKEN = "EPSILONTOKEN";
	public static final String IDENTIFIERTOKEN = "IDENTIFIERTOKEN";
	public static final String ENDOFFILETOKEN = "$ENDOFFILETOKEN";
	public static final String INTEGERTOKEN = "INTEGERTOKEN";
	public static final String REALTOKEN = "REALTOKEN";
	public static final String NUMTOKEN = "NUMTOKEN";
	public static final String RELOP = "RELOP";
	public static final String ADDOP = "ADDOP";
	public static final String MULOP = "MULOP";

	// static final String[] reservedWords = { "and", "array", "asm", "begin",
	// "break", "case", "const", "constructor", "continue", "destructor",
	// "div", "do", "downto", "else", "end", "false", "file", "for",
	// "function", "goto", "if", "implementation", "in", "inline",
	// "interface", "label", "mod", "nil", "not", "object", "of", "on",
	// "operator", "or", "packed", "procedure", "program", "record",
	// "repeat", "set", "shl", "shr", "string", "then", "to", "true",
	// "type", "unit", "until", "uses", "var", "while", "with", "xor", ";" };
	//
	// static final String[] reservedTokens = { "andtok", "arraytok", "asmtok",
	// "begintok", "breaktok", "casetok", "consttok", "constructortok",
	// "continuetok", "destructortok", "divtok", "dotok", "downtotok",
	// "elsetok", "endtok", "falsetok", "filetok", "fortok",
	// "functiontok", "gototok", "iftok", "implementationtok", "intok",
	// "inlinetok", "interfacetok", "labeltok", "modtok", "niltok",
	// "nottok", "objecttok", "oftok", "ontok", "operatortok", "ortok",
	// "packedtok", "proceduretok", "programtoken", "recordtok",
	// "repeattok", "settok", "shltok", "shrtok", "stringtok", "thentok",
	// "totok", "truetok", "typetok", "unittok", "untiltok", "usestok",
	// "vartok", "whiletok", "withtok", "xor", "semicolontoken" };

	static final String[] reservedWords = { "var", "array", "function",
			"procedure", "begin", "if", "while", "not", "end", "program" };
	static final String[] reservedTokens = { VARIABLE, ARRAYTOK, FUNCTIONTOK,
			PROCEDURETOK, BEGINTOK, IFTOK, WHILETOK, NOTTOK, ENDTOK, PROGRAM };

	// static final String[] operators = { "*", "+", "-", "/", "=", ";", ",",
	// ".",
	// ">", "<", "!", "(", ")", ":=" };
	//
	// static final String[] operatorTokens = { "startoken", "plustoken",
	// "minustoken", "slashtoken", "equalstoken", "semicolontoken",
	// "commatoken", "periodtoken", "greatertoken", "lesstoken",
	// "notequaltoken", "openparentoken", "closeparentoken", "assigntoken" };

	static final String[] operators = { "*", "+", "-", "/", "=", ";", ",", ".",
			">", "<", "(", ")", ":=" };

	static final String[] operatorTokens = { MULOP, ADDOP, ADDOP, MULOP, RELOP,
			SEMICOLONTOKEN, COMMATOKEN, PERIODTOKEN, RELOP, RELOP,
			OPENPARENTOKEN, CLOSEPARENTOKEN, ASSIGNTOKEN };

	static Hashtable<String, String> symbols = new Hashtable<String, String>();
	// static Hashtable<String, String> operators2tokens = new Hashtable<String,
	// String>();

	static {
		// TODO Auto-generated constructor stub

		for (int i = 0; i < reservedWords.length; i++) {
			symbols.put(reservedWords[i], reservedTokens[i]);
		}
		for (int i = 0; i < operators.length; i++) {
			symbols.put(operators[i], operatorTokens[i]);
		}

	}

	public static String getWordTokenName(String lexeme) {
		return symbols.containsKey(lexeme) ? symbols.get(lexeme)
				: "identifiertoken";
	}

	public static String geOperatorTokenName(String lexeme) {
		return symbols.containsKey(lexeme) ? symbols.get(lexeme)
				: "<unidentfied operator>";
	}
}
