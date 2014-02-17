package com.prasad.cs6413.scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileScanner {

	Scanner File;
	String Path;
	StreamTokenizer STokenizer;

	public FileScanner(String Path) {
		// TODO Auto-generated constructor stub

		this.Path = Path;
		try {
			this.File = new Scanner(new java.io.File(Path));
			this.STokenizer = new StreamTokenizer(new FileReader(this.Path));

			// STokenizer.resetSyntax();
			// STokenizer.wordChars('a', 'z');
			// STokenizer.wordChars('A', 'Z');
			// STokenizer.wordChars('\u00A0', '\u00FF');
			// STokenizer.whitespaceChars('\u0000', '\u0020');
			STokenizer.quoteChar('\'');
			STokenizer.ordinaryChar('{');
			STokenizer.ordinaryChar('}');
			STokenizer.ordinaryChar('(');
			STokenizer.ordinaryChar(')');
			STokenizer.parseNumbers();
			STokenizer.ordinaryChar('.');
			STokenizer.eolIsSignificant(false);
			STokenizer.lowerCaseMode(true);
			STokenizer.slashStarComments(false);
			STokenizer.slashSlashComments(false);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	SimpleToken[] getToken() throws IOException {
		ArrayList<SimpleToken> tokenString = new ArrayList<SimpleToken>();

		int lineNumber = 0;
		String sourceFile = this.Path;
		int columnNumber = 0;
		int nextToken = 0;

		while (nextToken != StreamTokenizer.TT_EOF) {

			nextToken = STokenizer.nextToken();
			switch (nextToken) {

			case StreamTokenizer.TT_EOF:
				break;
			case StreamTokenizer.TT_NUMBER:
				tokenString.add(new NumberToken(sourceFile,
						STokenizer.lineno(), columnNumber, STokenizer.nval));
				break;
			case StreamTokenizer.TT_WORD:
				switch (STokenizer.sval) {
				case "+":
				case "-":
				case "*":
				case "/":
				case "OR":
				case "DIV":
				case "MOD":
				case "AND":
				case ":=":
				case "(":
				case ")":
					tokenString.add(new OperatorToken(sourceFile, lineNumber,
							columnNumber, STokenizer.sval));
					break;
				default:
					tokenString.add(new WordToken(sourceFile, lineNumber,
							columnNumber, STokenizer.sval));
					break;
				}
				break;
			default:
				tokenString
						.add(new OperatorToken(sourceFile, lineNumber,
								columnNumber, String
										.valueOf(((char) STokenizer.ttype))));
				break;

			}
		}

		return tokenString.toArray(new SimpleToken[0]);
	}
}
