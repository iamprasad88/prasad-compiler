package com.prasad.cs6413.scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (POly Id 0529494)
 * @version 0.1
 * 
 *          The below class reads a file (path provided in constructor) and
 *          breaks it into token.
 * 
 */
public class FileScanner {

	Scanner File;
	String Path;
	StreamTokenizer STokenizer;

	public FileScanner(String Path) {

		this.Path = Path;
		try {
			this.File = new Scanner(new java.io.File(Path));
			this.STokenizer = new StreamTokenizer(new FileReader(this.Path));
			STokenizer.resetSyntax();
			this.STokenizer.wordChars('0', '9');
			STokenizer.wordChars('a', 'z');
			STokenizer.wordChars('A', 'Z');
			STokenizer.wordChars('.', '.');
			STokenizer.wordChars('_', '_');
			STokenizer.wordChars('-', '-');
			STokenizer.whitespaceChars(0x00, 0x20);
			STokenizer.quoteChar('\'');
			STokenizer.ordinaryChar('{');
			STokenizer.ordinaryChar('}');
			STokenizer.ordinaryChar('(');
			STokenizer.ordinaryChar(')');
			STokenizer.eolIsSignificant(false);
			STokenizer.lowerCaseMode(true);
			STokenizer.slashStarComments(false);
			STokenizer.slashSlashComments(false);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return Scans the file provided in constructor and returns and array of
	 *         Simple Tokens with each token referring to a matched lexeme.
	 * @throws IOException
	 *             (when file in not readable)
	 */
	public SimpleToken[] getToken() throws IOException {
		ArrayList<SimpleToken> tokenString = new ArrayList<SimpleToken>();

		String sourceFile = this.Path;
		int columnNumber = 0;
		int lineNumber = 0;
		int nextToken = 0;

		while (nextToken != StreamTokenizer.TT_EOF) { // Read file till EOF

			nextToken = STokenizer.nextToken();
			switch (nextToken) {

			case StreamTokenizer.TT_EOF:
				break;

			case StreamTokenizer.TT_EOL: // Just to store extra info like line
											// number and column number for
											// future use
				columnNumber = 0;
				lineNumber++;
				break;

			case StreamTokenizer.TT_WORD:
				if (Pattern.matches("[a-zA-z][a-zA-Z0-9]*", STokenizer.sval)) {
					// matches id->letter(letter|digit)*
					tokenString.add(new WordToken(STokenizer.sval, sourceFile,
							lineNumber, columnNumber));
				} else if (Pattern.matches(
						"(-)?[0-9]+(.[0-9]+)?([eE](-)?[0-9]+)?",
						STokenizer.sval)) {
					// Matches num -> digit optional _fraction optional_exponent
					tokenString.add(new NumberToken(STokenizer.sval,
							sourceFile, lineNumber, columnNumber));
				}
				columnNumber += STokenizer.sval.length() + 1;
				break;

			default:
				char chr = (char) STokenizer.ttype;
				if (chr == '{') {
					boolean comment = true;
					do {
						nextToken = STokenizer.nextToken();
						if ((char) STokenizer.ttype == '}') {
							comment = false;
						}
					} while (comment == true
							&& nextToken != StreamTokenizer.TT_EOF);
				} else {
					tokenString.add(new OperatorToken(String.valueOf(chr),
							sourceFile, lineNumber, columnNumber));
				}
				break;
			}
		}

		return tokenString.toArray(new SimpleToken[0]);
	}
}