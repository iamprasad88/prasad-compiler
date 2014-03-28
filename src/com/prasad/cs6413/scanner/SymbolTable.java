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

	static final String[] reservedWords = { "and", "array", "asm", "begin",
			"break", "case", "const", "constructor", "continue", "destructor",
			"div", "do", "downto", "else", "end", "false", "file", "for",
			"function", "goto", "if", "implementation", "in", "inline",
			"interface", "label", "mod", "nil", "not", "object", "of", "on",
			"operator", "or", "packed", "procedure", "program", "record",
			"repeat", "set", "shl", "shr", "string", "then", "to", "true",
			"type", "unit", "until", "uses", "var", "while", "with", "xor", ";" };

	static final String[] reservedTokens = { "andtok", "arraytok", "asmtok",
			"begintok", "breaktok", "casetok", "consttok", "constructortok",
			"continuetok", "destructortok", "divtok", "dotok", "downtotok",
			"elsetok", "endtok", "falsetok", "filetok", "fortok",
			"functiontok", "gototok", "iftok", "implementationtok", "intok",
			"inlinetok", "interfacetok", "labeltok", "modtok", "niltok",
			"nottok", "objecttok", "oftok", "ontok", "operatortok", "ortok",
			"packedtok", "proceduretok", "programtok", "recordtok",
			"repeattok", "settok", "shltok", "shrtok", "stringtok", "thentok",
			"totok", "truetok", "typetok", "unittok", "untiltok", "usestok",
			"vartok", "whiletok", "withtok", "xor", "semicolontoken" };

	static final String[] operators = { "*", "+", "-", "/", "=", ";", ",", ".",
			">", "<", "!", "(", ")", ":=" };

	static final String[] operatorTokens = { "startoken", "plustoken",
			"minustoken", "slashtoken", "equalstoken", "semicolontoken",
			"commatoken", "periodtoken", "greatertoken", "lesstoken",
			"notequaltoken", "openparentoken", "closeparentoken", "assigntoken" };

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
