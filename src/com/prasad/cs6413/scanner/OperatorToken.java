package com.prasad.cs6413.scanner;

public class OperatorToken extends SimpleToken {

	public OperatorToken(String lexeme, String sourceFile, int lineNumber,
			int columnNumber) {
		// TODO Auto-generated constructor stub
		super(lexeme, sourceFile, lineNumber, columnNumber, "tokop");
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
