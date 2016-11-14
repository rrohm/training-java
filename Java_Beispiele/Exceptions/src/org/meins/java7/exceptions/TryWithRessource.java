package org.meins.java7.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryWithRessource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// "Try with ressource": Try wird um einen Ressourcen-Block erweitert,
		// hier werden Ressourcen deklariert UND instanziert.
		// Voraussetzung: Die Ressource implementiert das Closeable-Interface.

		//try (BufferedReader br = new BufferedReader(new FileReader("D:\\test.txt"))){
		// eleganter: 
	    try (BufferedReader br = erzeugeReader("D:\\test.txt")){
			
			String zeile;
			while ((zeile = br.readLine()) != null){
				System.out.println("Zeile: " + zeile);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("FEHLER");
			e.printStackTrace();
		}
	}
	
	/**
	 * Erzeugung von Closeable-Ressourcen kann auch ausgelagert werden:  
	 * @param dateiname
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BufferedReader erzeugeReader(String dateiname) throws FileNotFoundException{
		FileReader fr = new FileReader(dateiname);
		return new BufferedReader(fr);
	}
}
