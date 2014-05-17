package com.prasad.cs6413.scanner;

public class Term {
	public static final int NON_TERMINAL = 0;
	public static final int TERMINAL = 1;

	String name;
	SimpleToken simpleToken;
	int type;

	public Term(String name) {
		this.name = name;
		this.type = NON_TERMINAL;
	}

	public Term(SimpleToken simpleToken) {
		this.simpleToken = simpleToken;
		this.type = TERMINAL;
	}

	public boolean isTerminal() {
		if (type == TERMINAL)
			return true;
		else
			return false;
	}

	public boolean isNonTerminal() {
		if (type == NON_TERMINAL)
			return true;
		else
			return false;
	}

	public boolean equals(Term term) {
		if (type != term.type)
			return false;
		else if (type == NON_TERMINAL) {
			return name.equals(term.name);
		} else {
			return simpleToken.equals(term.simpleToken);
		}
	}
}
