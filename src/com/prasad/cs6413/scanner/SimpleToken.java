package com.prasad.cs6413.scanner;

public class SimpleToken {
	private String SourceFile;
	private int LineNumber;
	private int ColumnNumber;
	private String TokName;

	public SimpleToken(String sourceFile, int lineNumber, int columnNumber,
			String tokName) {
		// TODO Auto-generated constructor stub

		this.SourceFile = sourceFile;
		this.LineNumber = lineNumber;
		this.ColumnNumber = columnNumber;
		this.TokName = tokName.toUpperCase();
	}

	public int getColumnNumber() {
		return ColumnNumber;
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
}
