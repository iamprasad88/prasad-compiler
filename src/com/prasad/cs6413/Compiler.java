package com.prasad.cs6413;

import com.prasad.cs6413.scanner.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

	public static void main(String[] args) {

		try {

			System.out.println("Please provide a path to Input file...");
			BufferedReader scanf = new BufferedReader(new InputStreamReader(
					System.in));

			FileScanner fs = new FileScanner(scanf.readLine());
			System.out.println("Please provide a path to Output file...");
			SimpleToken st[] = fs.getToken();
			FileWriter ofs = new FileWriter(scanf.readLine());
			for (SimpleToken s : st) {

				String text = s.getLexeme() + "\t" + s.getTokName();

				ofs.write(text + "\r\n");
				System.out.println(text);
				// System.out.println(s.toString());
			}
			ofs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please provide a valid path to file.");

			e.printStackTrace();
		}

	}

}
