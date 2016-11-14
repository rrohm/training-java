package org.meins.java.refactoring.methoden;

/**
 * Refactoring von Methoden-Aufrufen: "Vararg-Parameter einsetzen" 
 * 
 * @author R. Rohm
 */


public class VarargParameter {
    
    /*
     * Vorher: Dieselbe Methode zweimal implementiert, um einzelne Instanzen 
     * wie auch Collections von Instanzen desselben Typs mit derselben Logik
     * zu verarbeiten: 
     */	    
//    public void speichereDaten(Daten datum){
//        
//    }
//    
//    public void speichereDaten(Daten[] daten){
//        
//    }
    
    /**
     * Vereinfachung: die Vararg-Methode erlaubt beide 
     * Aufruf-Formen, mit einer Instanz oder mit einem Array.
     * 
     * ("Vararg-Methode": eine Methode, die mit unterschiedlich
     * vielen Parametern aufgerufen werden kann. )
     * 
     * @param daten 
     */
    public void speichereDaten(Daten... daten){
        // Auswertung des/der Parameter: wie mit einem Array, 
        // da der Compiler den Vararg-Parameter auch als Array umsetzt
        for (Daten wert : daten) {
            // ... verarbeiten ...
        }
    }
    
    
    /**
     * Klasse für Datenobjekte der Anwendung
     */
    public class Daten {
        
    }
}
