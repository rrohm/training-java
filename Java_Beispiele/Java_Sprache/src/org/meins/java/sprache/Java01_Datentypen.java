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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.sprache;

/**
 * Dieses Beispiel illustriert grundlegende Syntax und Verwendung der primitiven
 * Datentypen in Java.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java01_Datentypen {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Java hat ein relativ einfaches Typ-System: 
    // a) Primmitive Ganzzahl-Typen - generell vorzeichenbehaftet 
    byte einByte = Byte.MAX_VALUE;
    short ein16BitShort = Short.MAX_VALUE;
    int ein32BitInteger = Integer.MAX_VALUE;
    long ein64BitLong = Long.MAX_VALUE;
    
    // Autoboxing
    ein32BitInteger = new Integer(123);  // ACHTUNG: Objekt-Instanzierung, HEAP!
    Integer objektInt = ein32BitInteger; // ACHTUNG: Objekt-Instanzierung, HEAP!

    // b) Primitive Gleitkomma-Typen - ebenfalls generell vorzeichenbehaftet
    float ein32BitFloat = Float.MAX_VALUE;
    double ein64BitFloat = Double.MAX_VALUE;

    // c) Boolesche Werte
    boolean einBoolean = true;

    // d) Objekt-Typen
    Object o = new Object();
    
    // e) Strings
    String t = "Ich bin ein String";
  }

}
