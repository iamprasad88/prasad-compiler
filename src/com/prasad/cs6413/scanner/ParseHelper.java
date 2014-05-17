package com.prasad.cs6413.scanner;

import static com.prasad.cs6413.scanner.SymbolTable.*;

import java.util.Hashtable;

/**
 * 
 * @authorPrasad TV (0529494)
 * 
 *               Stores basic Data Structures to help the parser algorithm
 *               
 *               LL1Productions - stores LL1 Production values
 *               
 *               parseTable - is a Java Hash Table that stores the LL1 Parse Table. Each node in
 *               the hash is an array of productions
 *               
 *               See production class also
 * 
 * 
 */
public class ParseHelper {

	public static final int TOTAL_PRODUCTIONS = 57;

	public static Hashtable<String, Production[]> parseTable;
	public static String[][] LL1Productions;

	static {

		// Initialize LL1 Production
		LL1Productions = new String[TOTAL_PRODUCTIONS][];
		LL1Productions[1] = new String[] { IDENTIFIERTOKEN, OPENPARENTOKEN,
				IDLIST, CLOSEPARENTOKEN, SEMICOLONTOKEN, DECLARATIONS,
				SUBPROGRAMDECLARATIONS, COMPOUNDSTATEMENT, PERIODTOKEN };
		LL1Productions[2] = new String[] { IDENTIFIERTOKEN, IDLISTPRIME };
		LL1Productions[3] = new String[] { COMMATOKEN, IDENTIFIERTOKEN,
				IDLISTPRIME };
		LL1Productions[4] = new String[] { EPSILONTOKEN };
		LL1Productions[5] = new String[] { DECLARATIONSPRIME };
		LL1Productions[6] = new String[] { VARIABLE, IDLIST, COLONTOKEN, TYPE,
				SEMICOLONTOKEN };
		LL1Productions[7] = new String[] { EPSILONTOKEN };
		LL1Productions[8] = new String[] { STANDARDTYPE };
		// Not supported as of now
		// LL1Productions[9] = new String[] { STANDARDTYPE };
		LL1Productions[10] = new String[] { INTEGERTOKEN };
		LL1Productions[11] = new String[] { REALTOKEN };
		LL1Productions[12] = new String[] { SUBPROGRAMDECLARATIONSPRIME };
		LL1Productions[13] = new String[] { SUBPROGRAMDECLARATION,
				SEMICOLONTOKEN, SUBPROGRAMDECLARATIONSPRIME };
		LL1Productions[14] = new String[] { EPSILONTOKEN };
		LL1Productions[15] = new String[] { SUBPROGRAMHEAD, DECLARATIONS,
				COMPOUNDSTATEMENT };
		LL1Productions[16] = new String[] { FUNCTIONTOK, ARGUMENTS, COLONTOKEN,
				STANDARDTYPE };
		LL1Productions[17] = new String[] { PROCEDURETOK, ARGUMENTS,
				SEMICOLONTOKEN };
		LL1Productions[18] = new String[] { OPENPARENTOKEN, PARAMETERLIST,
				CLOSEPARENTOKEN };
		LL1Productions[19] = new String[] { EPSILONTOKEN };
		LL1Productions[20] = new String[] { IDLIST, COLONTOKEN, TYPE,
				PARAMETERLISTPRIME };
		LL1Productions[21] = new String[] { SEMICOLONTOKEN, IDLIST, COLONTOKEN,
				TYPE, PARAMETERLISTPRIME };
		LL1Productions[22] = new String[] { EPSILONTOKEN };
		LL1Productions[23] = new String[] { BEGINTOK, OPTIONALSTATEMENTS,
				ENDTOK };
		LL1Productions[24] = new String[] { STATEMENTLIST };
		LL1Productions[25] = new String[] { EPSILONTOKEN };
		LL1Productions[26] = new String[] { STATEMENT, STATEMENTLISTPRIME };
		LL1Productions[27] = new String[] { SEMICOLONTOKEN, STATEMENT,
				STATEMENTLISTPRIME };
		LL1Productions[28] = new String[] { EPSILONTOKEN };
		LL1Productions[29] = new String[] { IDENTIFIERTOKEN, ASSIGNTOKEN,
				EXPRESSION };
		LL1Productions[30] = new String[] { PROCEDURESTATEMENT };
		LL1Productions[31] = new String[] { COMPOUNDSTATEMENT };
		LL1Productions[32] = new String[] { IFTOK, EXPRESSION, THENTOK,
				STATEMENT, ELSETOK };
		LL1Productions[33] = new String[] { WHILETOK, EXPRESSION, DOTOK,
				STATEMENT };
		LL1Productions[34] = new String[] { IDENTIFIERTOKEN };
		// LL1Productions[35] = new String[] { IDENTIFIERTOKEN,"[" };
		LL1Productions[36] = new String[] { IDENTIFIERTOKEN };
		LL1Productions[37] = new String[] { IDENTIFIERTOKEN, OPENPARENTOKEN,
				EXPRESSIONLIST, CLOSEPARENTOKEN };
		LL1Productions[38] = new String[] { EXPRESSION, EXPRESSIONLISTPRIME };
		LL1Productions[39] = new String[] { COMMATOKEN, EXPRESSION,
				EXPRESSIONLISTPRIME };
		LL1Productions[40] = new String[] { EPSILONTOKEN };
		LL1Productions[41] = new String[] { SIMPLEEXPRESSION };
		LL1Productions[42] = new String[] { SIMPLEEXPRESSION, RELOP,
				SIMPLEEXPRESSION };
		LL1Productions[43] = new String[] { TERM, SIMPLEEXPRESSIONPRIME };
		LL1Productions[44] = new String[] { SIGN, TERM, SIMPLEEXPRESSIONPRIME };
		LL1Productions[44] = new String[] { SIGN, TERM, SIMPLEEXPRESSIONPRIME };
		LL1Productions[45] = new String[] { ADDOP, TERM, SIMPLEEXPRESSIONPRIME };
		LL1Productions[46] = new String[] { EPSILONTOKEN };
		LL1Productions[47] = new String[] { FACTOR, TERMPRIME };
		LL1Productions[48] = new String[] { MULOP, FACTOR, TERMPRIME };
		LL1Productions[49] = new String[] { EPSILONTOKEN };
		LL1Productions[50] = new String[] { IDENTIFIERTOKEN };
		LL1Productions[51] = new String[] { IDENTIFIERTOKEN, OPENPARENTOKEN,
				EXPRESSIONLIST, CLOSEPARENTOKEN };
		LL1Productions[52] = new String[] { NUMTOKEN };
		LL1Productions[53] = new String[] { OPENPARENTOKEN, EXPRESSION,
				CLOSEPARENTOKEN };
		LL1Productions[54] = new String[] { NOTTOK, FACTOR };
		LL1Productions[56] = new String[] { PLUSTOKEN };
		LL1Productions[56] = new String[] { MINUSTOKEN };

		// Initialize Parse Table (implemented as a Java Hash Table)
		parseTable = new Hashtable<String, Production[]>();
		parseTable.put(PROGRAM, new Production[] { new Production(
				IDENTIFIERTOKEN, 1) });
		parseTable.put(PROGRAMPRIME, new Production[] { new Production(
				ENDOFFILETOKEN, 2) });
		parseTable.put(DECLARATIONS, new Production[] {
				new Production(VARTOK, 6), new Production(BEGINTOK, 7) });
		parseTable.put(DECLARATIONSPRIME, new Production[] {
				new Production(VARTOK, 4), new Production(SEMICOLONTOKEN, 5) });
		parseTable.put(TYPE, new Production[] {
				new Production(INTEGERTOKEN, 6), new Production(REALTOKEN, 6),
				new Production(ARRAYTOK, 7) });
		parseTable
				.put(STANDARDTYPE, new Production[] {
						new Production(INTEGERTOKEN, 8),
						new Production(REALTOKEN, 9) });
		parseTable.put(SUBPROGRAMDECLARATIONS,
				new Production[] { new Production(FUNCTIONTOK, 10),
						new Production(PROCEDURETOK, 10),
						new Production(BEGINTOK, 14) });
		parseTable.put(SUBPROGRAMDECLARATIONSPRIME,
				new Production[] { new Production(FUNCTIONTOK, 11),
						new Production(PROCEDURETOK, 11),
						new Production(BEGINTOK, 14) });
		parseTable.put(SUBPROGRAMDECLARATION,
				new Production[] { new Production(FUNCTIONTOK, 13),
						new Production(PROCEDURETOK, 13),
						new Production(BEGINTOK, 14) });
		parseTable.put(SUBPROGRAMHEAD, new Production[] {
				new Production(FUNCTIONTOK, 14),
				new Production(PROCEDURETOK, 14) });
		parseTable.put(ARGUMENTS, new Production[] {
				new Production(OPENPARENTOKEN, 15),
				new Production(SEMICOLONTOKEN, 16),
				new Production(COLONTOKEN, 16) });
		parseTable.put(PARAMETERLIST, new Production[] { new Production(
				IDENTIFIERTOKEN, 17) });
		parseTable.put(PARAMETERLISTPRIME, new Production[] {
				new Production(SEMICOLONTOKEN, 18),
				new Production(CLOSEPARENTOKEN, 19) });
		parseTable.put(COMPOUNDSTATEMENT, new Production[] { new Production(
				BEGINTOK, 23) });
		parseTable.put(OPTIONALSTATEMENTS, new Production[] {
				new Production(IDENTIFIERTOKEN, 24),
				new Production(BEGINTOK, 21), new Production(IFTOK, 21),
				new Production(WHILETOK, 21), new Production(ENDTOK, 25) });
		parseTable.put(STATEMENTLIST, new Production[] {
				new Production(IDENTIFIERTOKEN, 26),
				new Production(BEGINTOK, 22), new Production(IFTOK, 22),
				new Production(WHILETOK, 22) });
		parseTable.put(STATEMENTLISTPRIME,
				new Production[] { new Production(SEMICOLONTOKEN, 23),
						new Production(ENDTOK, 24) });
		parseTable.put(STATEMENT, new Production[] {
				new Production(IDENTIFIERTOKEN, 29),
				new Production(BEGINTOK, 27), new Production(IFTOK, 28),
				new Production(WHILETOK, 29) });
		parseTable.put(VARIABLE, new Production[] { new Production(
				IDENTIFIERTOKEN, 30) });
		parseTable.put(PROCEDURESTATEMENT, new Production[] { new Production(
				IDENTIFIERTOKEN, 33) });
		parseTable.put(EXPRESSIONLIST, new Production[] {
				new Production(PLUSTOKEN, 34), new Production(MINUSTOKEN, 34),
				new Production(IDENTIFIERTOKEN, 34),
				new Production(NUMTOKEN, 34), new Production(NOTTOK, 34) });
		parseTable.put(EXPRESSIONLISTPRIME, new Production[] {
				new Production(SEMICOLONTOKEN, 35),
				new Production(CLOSEPARENTOKEN, 36) });
		parseTable.put(EXPRESSION, new Production[] {
				new Production(IDENTIFIERTOKEN, 37),
				new Production(OPENPARENTOKEN, 37),
				new Production(NUMTOKEN, 37), new Production(NOTTOK, 37) });
		parseTable.put(SIMPLEEXPRESSION, new Production[] {
				new Production(IDENTIFIERTOKEN, 39),
				new Production(OPENPARENTOKEN, 39),
				new Production(NUMTOKEN, 39), new Production(NOTTOK, 39) });
		parseTable.put(SIMPLEEXPRESSIONPRIME, new Production[] {
				new Production(PLUSTOKEN, 40), new Production(MINUSTOKEN, 40),
				new Production(RELOP, 42), new Production(ADDOP, 41) });
		parseTable.put(TERM, new Production[] {
				new Production(IDENTIFIERTOKEN, 43),
				new Production(OPENPARENTOKEN, 43),
				new Production(NUMTOKEN, 43), new Production(NOTTOK, 43) });
		parseTable.put(TERMPRIME, new Production[] { new Production(RELOP, 45),
				new Production(MULOP, 44) });
		parseTable.put(FACTOR, new Production[] {
				new Production(IDENTIFIERTOKEN, 46),
				new Production(OPENPARENTOKEN, 48),
				new Production(NUMTOKEN, 47), new Production(NOTTOK, 49) });
		parseTable.put(SIGN, new Production[] { new Production(PLUSTOKEN, 50),
				new Production(MINUSTOKEN, 51) });
		parseTable.put(IDLIST, new Production[] { new Production(
				IDENTIFIERTOKEN, 2) });
		parseTable.put(IDLISTPRIME, new Production[] {
				new Production(COLONTOKEN, 54),
				new Production(CLOSEPARENTOKEN, 4),
				new Production(COMMATOKEN, 3) });
	}

}
