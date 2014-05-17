package com.prasad.cs6413.scanner;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (POly Id 0529494)
 * @version 0.1
 * 
 *          Provides a foundation of a basic token type. Provides mandatory
 *          fields which must be provided by all sub classes.
 * 
 */

public abstract class SimpleToken {
	private String SourceFile; // Stores source file path (for future use)
	private int LineNumber; // Stores Line Number (for future use)
	private int ColumnNumber; // Stores Column Number (for future use)
	private String TokName; // Stores Token Name (tokword, toknumber or tokop)
							// (for future use). Each subclass must pass this
							// value in constructor.
	protected String Lexeme; // Text that matched in the stream

	/**
	 * 
	 * @param Lexeme
	 *            String Text that matched in the stream
	 * @param sourceFile
	 *            String Stores source file path (for future use)
	 * @param lineNumber
	 *            int Stores Line Number (for future use)
	 * @param columnNumber
	 *            int Stores Column Number (for future use)
	 * @param tokName
	 *            String Stores Token Name (tokword, toknumber or tokop etc...)
	 */

	SimpleToken() {

	}

	public SimpleToken(String Lexeme, String sourceFile, int lineNumber,
			int columnNumber, String tokName) {
		// TODO Auto-generated constructor stub
		this.Lexeme = Lexeme;
		this.SourceFile = sourceFile;
		this.LineNumber = lineNumber;
		this.ColumnNumber = columnNumber;
		this.setTokName(tokName.toUpperCase());
	}

	public int getColumnNumber() {
		return ColumnNumber;
	}

	public String getLexeme() {
		return Lexeme;
	}

	public int getLineNumber() {
		return LineNumber;
	}

	public String getSourceFile() {
		return SourceFile;
	}

	public String getTokName() {
		return TokName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();

		return this.getTokName() + " File:" + this.SourceFile + " Line:"
				+ this.LineNumber + " Column:" + this.ColumnNumber;
	}

	abstract String getValue();

	boolean equals(SimpleToken simpleToken) {
		return getTokName().equals(simpleToken.getTokName());
	}

	public void setTokName(String tokName) {
		TokName = tokName;
	}
}
