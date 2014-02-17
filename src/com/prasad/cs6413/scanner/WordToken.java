package com.prasad.cs6413.scanner;

public class WordToken extends SimpleToken {

	private String Lexeme;

	public WordToken(String sourceFile, int lineNumber, int columnNumber,
			String lexeme) {
		// TODO Auto-generated constructor stub
		super(sourceFile, lineNumber, columnNumber, "tokword");
		this.Lexeme = lexeme;
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
}
