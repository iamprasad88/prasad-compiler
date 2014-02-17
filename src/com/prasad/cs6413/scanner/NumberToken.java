package com.prasad.cs6413.scanner;

public class NumberToken extends SimpleToken {

	private double Lexeme;

	public NumberToken(String sourceFile, int lineNumber, int columnNumber,
			double lexeme) {
		// TODO Auto-generated constructor stub
		super(sourceFile, lineNumber, columnNumber, "toknumber");
		this.Lexeme = lexeme;
	}

	public double getLexeme() {
		return Lexeme;
	}

	@Override
	public String toString() {
		return this.getTokName() + " Value: " + this.getLexeme() + " File:"
				+ this.getSourceFile().toString() + " Line:"
				+ this.getLineNumber() + " Column:" + this.getColumnNumber();
	}
}
