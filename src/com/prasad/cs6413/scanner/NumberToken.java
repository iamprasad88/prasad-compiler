package com.prasad.cs6413.scanner;

import java.util.regex.Pattern;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (POly Id 0529494)
 * 
 *         Extends Simple Token and specialized functions to accommodate Number
 *         tokens
 * 
 */
public class NumberToken extends SimpleToken {

	private double value;

	public NumberToken(String Lexeme, String sourceFile, int lineNumber,
			int columnNumber) {
		// TODO Auto-generated constructor stub

		super(Lexeme, sourceFile, lineNumber, columnNumber, "toknumber");
		if (Pattern.matches("[0-9]+(.[0-9]+)?([eE](-)?[0-9]+)?", Lexeme)) {
			this.setTokName(SymbolTable.REALTOKEN);
		} else if (Pattern
				.matches("-[0-9]+(.[0-9]+)?([eE](-)?[0-9]+)?", Lexeme)) {
			this.setTokName(SymbolTable.REALTOKEN);
		} else if (Pattern.matches("[0-9]+(.[0-9]+)", Lexeme)) {
			this.setTokName(SymbolTable.INTEGERTOKEN);
		} else if (Pattern.matches("-[0-9]+(.[0-9]+)", Lexeme)) {
			this.setTokName(SymbolTable.INTEGERTOKEN);
		}
		this.value = Double.parseDouble(Lexeme);
	}

	@Override
	public String toString() {
		return this.getTokName() + " Value: " + this.getValue() + " File:"
				+ this.getSourceFile().toString() + " Line:"
				+ this.getLineNumber() + " Column:" + this.getColumnNumber();
	}

	@Override
	String getValue() {
		// TODO Auto-generated method stub
		return Double.toString(value);
	}
}
