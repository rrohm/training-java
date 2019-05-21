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

import java.util.Arrays;

/**
 * Dieses Beispiel illustriert grundlegende Syntax und Verwendung von Arrays in
 * Java.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java03_Arrays {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Arrays sind in Java immer statisch getypt und in ihrer Länge unveränderlich. 
    int[] einIntArray = {0, 1, 1, 2, 3};

    System.out.println("Länge des Arrays: " + einIntArray.length);
    System.out.println("Array in Stringform: " + Arrays.toString(einIntArray));

    // Das "Verändern" der Array-Länge ist daher vergleichsweise aufwändig: 
    // letztendlich muss immer ein neues Array mit der gewünschten Länge 
    // erstellt werden, und der Inhalt des alten Arrays muss ggf. umkopiert werden:
    int[] einLaengeresArray = Arrays.copyOf(einIntArray, einIntArray.length + 1);
    einLaengeresArray[einLaengeresArray.length - 1] = 4;

    System.out.println("Längeres Array: " + Arrays.toString(einLaengeresArray));
  }
}
