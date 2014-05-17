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

	Scanner File; // Object reference to the file stream
	String Path; // stores Path to file that must be scanned

	StreamTokenizer STokenizer; /*
								 * Is a specialized java library class which is
								 * used to extract workd from a File stream.
								 * Based on how it is setup (see constructor) it
								 * can break a stream to words.
								 * 
								 * I have broken the stream to simple words
								 * here. Word is a sequence of alphabets,
								 * numbers, '_', '.' and '-'. _ was added as
								 * some variables can have _ in their name as
								 * per pascal specs in Dragon book '.' was added
								 * to check for floating poit numbers '-'
								 * (minus) was added to check for negative
								 * numbers or exponents.
								 * 
								 * Note: Current version only supports
								 * subtraction operator if space is included
								 * between '-' and second operand e.g. (A- B) or
								 * (A - B).
								 */

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
				tokenString.add(new EndOfFileToken(SymbolTable.ENDOFFILETOKEN,
						sourceFile, lineNumber, columnNumber,
						SymbolTable.ENDOFFILETOKEN));
				break;

			case StreamTokenizer.TT_EOL: // Just to store extra info like line
											// number and column number for
											// future use
				columnNumber = 0;
				lineNumber++;
				break;

			case StreamTokenizer.TT_WORD:
				// if (Pattern.matches("(div|mod|and|or)",
				// STokenizer.sval)) {
				// tokenString.add(new OperatorToken(STokenizer.sval,
				// sourceFile, lineNumber, columnNumber));
				// } else
				if (Pattern.matches("[a-zA-z]([a-zA-Z0-9])*", STokenizer.sval)) {
					// matches id->letter(letter|digit)*
					tokenString.add(new WordToken(STokenizer.sval, sourceFile,
							lineNumber, columnNumber));
				} else if (Pattern.matches("-[a-zA-z]([a-zA-Z0-9])*",
						STokenizer.sval)) {
					// matches id->letter(letter|digit)*
					tokenString.add(new OperatorToken("-", sourceFile,
							lineNumber, columnNumber));
					tokenString.add(new WordToken(STokenizer.sval.substring(1),
							sourceFile, lineNumber, columnNumber + 1));
				} else if (Pattern.matches("[a-zA-z]([a-zA-Z0-9])*\\.",
						STokenizer.sval)) {
					// matches id->letter(letter|digit)*
					String sub = STokenizer.sval.substring(0,
							STokenizer.sval.indexOf('.'));
					tokenString.add(new WordToken(sub, sourceFile, lineNumber,
							columnNumber));
					tokenString.add(new OperatorToken(".", sourceFile,
							lineNumber, columnNumber + sub.length()));

				} else if (Pattern.matches(
						"-[0-9]+(.[0-9]+)?([eE](-)?[0-9]+)?", STokenizer.sval)) {
					// Matches -ve num -> digit optional _fraction
					// optional_exponent
					// '-' is added as operator
					tokenString.add(new OperatorToken("-", sourceFile,
							lineNumber, columnNumber));

					tokenString.add(new NumberToken(STokenizer.sval
							.substring(1), sourceFile, lineNumber,
							columnNumber + 1));
				} else if (Pattern.matches("[0-9]+(.[0-9]+)?([eE](-)?[0-9]+)?",
						STokenizer.sval)) {
					// Matches +ve num -> digit optional _fraction
					// optional_exponent

					tokenString.add(new NumberToken(STokenizer.sval,
							sourceFile, lineNumber, columnNumber + 1));
				} else if (STokenizer.sval.equals("-")) {
					tokenString.add(new OperatorToken(STokenizer.sval,
							sourceFile, lineNumber, columnNumber));
				} else if (STokenizer.sval.equals(";")) {
					tokenString.add(new WordToken(STokenizer.sval, sourceFile,
							lineNumber, columnNumber));
				}
				columnNumber += STokenizer.sval.length() + 1;
				break;

			default: // Checking for all operators
				char chr = (char) STokenizer.ttype;
				if (chr == '{') { // Try to avoid comments. More testing is
									// required.
					boolean comment = true;
					do {
						nextToken = STokenizer.nextToken();
						if ((char) STokenizer.ttype == '}') {
							comment = false;
						}
					} while (comment == true
							&& nextToken != StreamTokenizer.TT_EOF);
				} else {
					// Checking for <= or <> operators
					if (chr == '<') {
						nextToken = STokenizer.nextToken();
						char chr2 = (char) STokenizer.ttype;
						if (chr2 == '=') {
							tokenString.add(new OperatorToken("<=", sourceFile,
									lineNumber, columnNumber));
							columnNumber++;
						} else if (chr2 == '>') {
							tokenString.add(new OperatorToken("<>", sourceFile,
									lineNumber, columnNumber));
							columnNumber++;
						} else {
							tokenString.add(new OperatorToken("<", sourceFile,
									lineNumber, columnNumber));
							STokenizer.pushBack();
						}
					}
					// Checking for >= operator
					else if (chr == '>') {
						nextToken = STokenizer.nextToken();
						char chr2 = (char) STokenizer.ttype;
						if (chr2 == '=') {
							tokenString.add(new OperatorToken(">=", sourceFile,
									lineNumber, columnNumber));
							columnNumber++;
						} else {
							tokenString.add(new OperatorToken(">", sourceFile,
									lineNumber, columnNumber));
							STokenizer.pushBack();
						}
					}
					// Checking for ':='
					// if only : is found, we still enter ':' as Operator as
					// correct definition is not provided in question
					else if (chr == ':') {
						nextToken = STokenizer.nextToken();
						char chr2 = (char) STokenizer.ttype;
						if (chr2 == '=') {
							tokenString.add(new OperatorToken(":=", sourceFile,
									lineNumber, columnNumber));
							columnNumber++;
						} else {
							tokenString.add(new OperatorToken(":", sourceFile,
									lineNumber, columnNumber));
							STokenizer.pushBack();
						}
					} else {
						tokenString.add(new OperatorToken(String.valueOf(chr),
								sourceFile, lineNumber, columnNumber));
					}

				}

				break;
			}
		}

		return tokenString.toArray(new SimpleToken[0]);
	}
}
