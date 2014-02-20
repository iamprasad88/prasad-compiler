package com.prasad.cs6413.scanner;
/**
 * 
 * @author Prasad Thondamuthur Vasanth (POly Id 0529494)
 * 
 * Extends Simple Token and specialized functions to accommodate Number tokens
 *
 */
public class NumberToken extends SimpleToken {

	private double value;

	public NumberToken(String Lexeme, String sourceFile, int lineNumber,
			int columnNumber) {
		// TODO Auto-generated constructor stub
		super(Lexeme, sourceFile, lineNumber, columnNumber, "toknumber");
		this.value = Double.parseDouble(Lexeme);
	}

	@Override
	public String toString() {
		return this.getTokName() + " Value: " + this.getLexeme() + " File:"
				+ this.getSourceFile().toString() + " Line:"
				+ this.getLineNumber() + " Column:" + this.getColumnNumber();
	}

	@Override
	String getValue() {
		// TODO Auto-generated method stub
		return Double.toString(value);
	}
}
