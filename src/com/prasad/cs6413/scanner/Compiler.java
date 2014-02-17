package com.prasad.cs6413.scanner;

import java.io.IOException;

public class Compiler {

	public static void main(String[] args) {
		FileScanner fs = new FileScanner("D:\\test.txt");
		
		try {
			SimpleToken st[] = fs.getToken();
			
			for(SimpleToken s:st){
				System.out.println(s.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
