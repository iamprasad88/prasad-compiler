package com.prasad.cs6413.scanner;

public abstract class SimpleToken {
	private String SourceFile; // Stores source file path (for future use)
	private int LineNumber; // Stores Line Number (for future use)
	private int ColumnNumber; // Stores Column Number (for future use)
	private String TokName; // Stores Token Name (tokword, toknumber or tokop)
							// (for future use). Each subclass must pass this
							// value in constructor.
	protected String Lexeme; // Text that matched in the stream

	public SimpleToken(String Lexeme, String sourceFile, int lineNumber,
			int columnNumber, String tokName) {
		// TODO Auto-generated constructor stub
		this.Lexeme = Lexeme;
		this.SourceFile = sourceFile;
		this.LineNumber = lineNumber;
		this.ColumnNumber = columnNumber;
		this.TokName = tokName.toUpperCase();
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

		return this.TokName + " File:" + this.SourceFile + " Line:"
				+ this.LineNumber + " Column:" + this.ColumnNumber;
	}

	abstract String getValue();
}
