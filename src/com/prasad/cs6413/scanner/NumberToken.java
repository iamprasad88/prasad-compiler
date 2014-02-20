package com.prasad.cs6413.scanner;

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
