package com.prasad.cs6413.scanner;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (Poly Id 0529494)
 * 
 *         Extends Simple Token and specialized functions to accommodate
 *         Operator tokens
 *         
 *         27th Mar 2014 Integrated with Symbol Table
 * 
 */
public class OperatorToken extends SimpleToken {

	public OperatorToken(String lexeme, String sourceFile, int lineNumber,
			int columnNumber) {
		// TODO Auto-generated constructor stub
		super(lexeme, sourceFile, lineNumber, columnNumber, SymbolTable
				.geOperatorTokenName(lexeme));
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

	@Override
	String getValue() {
		// TODO Auto-generated method stub
		return getLexeme();
	}

}
