package com.prasad.cs6413;

import static com.prasad.cs6413.scanner.ParseHelper.parseTable;
import static com.prasad.cs6413.scanner.SymbolTable.ENDOFFILETOKEN;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import javax.crypto.EncryptedPrivateKeyInfo;

import com.prasad.cs6413.scanner.FileScanner;
import com.prasad.cs6413.scanner.ParseHelper;
import com.prasad.cs6413.scanner.Production;
import com.prasad.cs6413.scanner.SimpleToken;
import com.prasad.cs6413.scanner.SymbolTable;

/**
 * 
 * @author Prasad Thondamuthur Vasanth (POly Id 0529494)
 * @version 0.1 Below class has the main thread.
 * 
 *          It calls the File Scanner and provides it with the file path It
 *          prints the token strings obtained by getToken()
 * 
 * 
 */

public class Compiler {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			System.out.println("Please provide a path to Input file...");
			BufferedReader scanf = new BufferedReader(new InputStreamReader(
					System.in));

			// FileScanner fs = new FileScanner("D:\\test.txt");
			FileScanner fs = new FileScanner(scanf.readLine());
			System.out
					.println("Please provide a path to Output scanner file...");
			SimpleToken st[] = fs.getToken();
			// FileWriter ofs = new FileWriter("D:\\test2.txt");
			FileWriter ofs = new FileWriter(scanf.readLine());
			System.out
					.println("Please provide a path to Output parser file...");
			FileWriter pfs = new FileWriter(scanf.readLine());
			for (SimpleToken s : st) {

				String text = s.getLexeme() + "\t" + s.getTokName();

				System.out.println(text);
				ofs.write(text + "\r\n");
				// System.out.println(s.toString());

			}
			ofs.close();

			/*
			 * Predictive Parsing Algorithms used (Please refer to ParseHelper and SymbolTable class as well)
			 * 
			 * procedure Parser
			 * Push the start symbol S onto the stack
			 * Initialize lookahead symbol
			 * fetch next token while not
			 * Empty(stack) do top = Top(stack)
			 * if top is a nonterminal then
			 * 		action = ParseTable[top,NextInputSymbol] 
			 * 		if action > 0 then Pop
			 *		top symbol Pop(stack)
			 * 	
			 * Push RHS of production in reverse order
			 * 	for each symbol on RHS #action do Push(symbol) else
			 * 	print("syntax error")
			 * 
			 * else if NextInputSymbol == top then Match
			 * 	terminal symbol in input Pop(stack) Get next terminal symbol in
			 * input scanner(NextInputSymbol) else print("syntax error")
			 */

			Stack<String> parseStack = new Stack<String>();

			parseStack.push(ENDOFFILETOKEN);
			parseStack.push(SymbolTable.PROGRAM);
			int currentToken = 1;
			String X;
			while (!parseStack.isEmpty()) {
				X = parseStack.pop();
				SimpleToken cTok = st[currentToken];
				String ctoks = cTok.getTokName();

				pfs.write("Scanned Token : " + ctoks + ":" + cTok.getLexeme()
						+ " with " + X + " on stack\r\n");
				// if X is a terminal or $
				if (X.equals(ENDOFFILETOKEN)) {
					System.out.println("Success!");
					break;
				}
				if (X.equals(SymbolTable.EPSILONTOKEN)) {
					continue;
				}
				if (X.contains("TOK"))
					if (cTok.getTokName().equals(X)) {
						currentToken++;
					} else {
						error(st[currentToken]);
					}
				else {
					// X is non terminal
					// Get next token
					SimpleToken tok = st[currentToken];
					String tokenName = tok.getTokName();
					if (parseTable.containsKey(X)) {
						Production[] prods = parseTable.get(X);
						boolean prodFound = false;
						for (Production p : prods) {
							if (p.getTokName().equals(tokenName)) {
								prodFound = true;
								int prodNum = p.getProductionNumber();
								if (prodNum < ParseHelper.LL1Productions.length) {
									String[] prodRHS = ParseHelper.LL1Productions[prodNum];

									for (int i = prodRHS.length - 1; i >= 0; i--) {
										parseStack.push(prodRHS[i]);
									}
								}
							}
						}
						if (prodFound == false) {
							error(tok);
						}
					}
				}
			}
			pfs.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please provide a valid path to file.");

			e.printStackTrace();
		}

	}

	private static void error(SimpleToken simpleToken) {
		System.out.println("Error found at in file: "
				+ simpleToken.getSourceFile() + " Line: "
				+ simpleToken.getLineNumber() + " Col: "
				+ simpleToken.getColumnNumber() + " ( "
				+ simpleToken.getLexeme() + ")");
	}
}
