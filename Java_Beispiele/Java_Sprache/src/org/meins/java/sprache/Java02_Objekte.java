/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 * 
 *  You are free to:
 * 
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 * 
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 * 
 *  Under the following terms:
 * 
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 * 
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 * 
 *
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.sprache;

/**
 * Dieses Beispiel illustriert grundlegende Syntax und Verwendung von Objekten
 * in Java.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java02_Objekte {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // Objekte werden mit dem new-Operator als Instanzen einer Klasse instanziert.
    // Die Klasse Object ist die Basisklasse eines jeden Klassen-Typs. 
    Object o1 = new Object();
    Object o2 = new Object();

    // Die KLasse Object stellt grundlegende Funktionalität für Objekt-Typen 
    // bereit, wie z.B. Prüfen auf Gleichheit und String-Repräsentation
    System.out.println("o1: " + o1);
    System.out.println("o2: " + o2);
    System.out.println("o1 identisch mit o2? " + (o1.equals(o2)));
    
  }
}
