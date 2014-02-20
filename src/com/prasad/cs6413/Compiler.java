package com.prasad.cs6413;

import com.prasad.cs6413.scanner.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Compiler {

	public static void main(String[] args) {

		try {

			System.out.println("Please provide a path to file...");
			BufferedReader scanf = new BufferedReader(new InputStreamReader(
					System.in));

			FileScanner fs = new FileScanner(scanf.readLine());

			SimpleToken st[] = fs.getToken();

			for (SimpleToken s : st) {
				System.out.println(s.getLexeme() + "\t" + s.getTokName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please provide a valid path to file.");

			e.printStackTrace();
		}

	}

}
