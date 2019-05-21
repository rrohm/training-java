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
package org.meins.java5.enumeration;

/**
 * Durch die Werte eines Enum-Typs kann z.B. mit foreach-Semantik iteriert
 * werden wie in einem Array.
 *
 * @author R. Rohm
 */
public class Enum02_EnumsAufzaehlen {


  public static enum Option {

    ERSTER_WERT, ZWEITER_WERT, DRITTER_WERT, VIERTER_WERT
  };

  /**
   * Startmethode, illustriert das Iterieren durch die Werte eines Enum-Typs.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Enum-Werte: ");

    for (Option o: Option.values()){
      int ordinal = Option.valueOf(o.name()).ordinal();

      System.out.println("o: " + ordinal + " = " + o.name());
    }
  }
}
