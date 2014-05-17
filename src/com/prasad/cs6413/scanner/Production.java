package com.prasad.cs6413.scanner;

public class Production {

	final String tokName;// Name of active token
	final int productionNumber; // Points to index of
								// ParserHelper.LL1Productions

	public Production(String tokName, int productionNumber) {
		super();
		this.tokName = tokName;
		this.productionNumber = productionNumber;
	}

	public String getTokName() {
		return tokName;
	}

	public int getProductionNumber() {
		return productionNumber;
	}

}
