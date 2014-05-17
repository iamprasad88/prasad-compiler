package com.prasad.cs6413.scanner;

public class EndOfFileToken extends SimpleToken {

	@Override
	String getValue() {
		return SymbolTable.ENDOFFILETOKEN;
	}

	public EndOfFileToken(String Lexeme, String sourceFile, int lineNumber,
			int columnNumber, String tokName) {
		super(Lexeme, sourceFile, lineNumber, columnNumber, tokName);
	}

	public String getLexeme() {
		return SymbolTable.ENDOFFILETOKEN;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return this.getTokName() + " Value: " + this.getLexeme() + " File:"
				+ this.getSourceFile().toString() + " Line:"
				+ this.getLineNumber() + " Column:" + this.getColumnNumber();
	}

}
