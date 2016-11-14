package org.meins.java7.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DateiLesenBsp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("D:\\test.txt");
			br = new BufferedReader(fr);
			
			String zeile = null;
			while ((zeile = br.readLine()) != null) {
				System.out.println("Gelesen: " + zeile);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Aufräumen  - idealerweise refaktoriert in eine einzige Methode
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// usw ...
			}
		}
		
		// weiteren code ...
		
	}

}
