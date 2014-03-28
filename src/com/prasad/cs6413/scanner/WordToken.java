package com.prasad.cs6413.scanner;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (Poly Id 0529494)
 * 
 *         Extends Simple Token and specialized functions to accommodate Word
 *         tokens
 *         27th Mar 2014 Integrated with Symbol Table
 * 
 */
public class WordToken extends SimpleToken {

	public WordToken(String lexeme, String sourceFile, int lineNumber,
			int columnNumber) {
		// TODO Auto-generated constructor stub
		super(lexeme, sourceFile, lineNumber, columnNumber, SymbolTable
				.getWordTokenName(lexeme));
	}

	public String getLexeme() {
		return Lexeme;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTokName() + " Value: " + this.getLexeme() + " File:"
				+ this.getSourceFile().toString() + " Line:"
				+ this.getLineNumber() + " Column:" + this.getColumnNumber();
	}

	String getValue() {
		return getLexeme();
	}
}
