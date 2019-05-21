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
package org.meins.jni.Bsp01_Basics;

import org.meins.jni.StrLen;

/**
 * Einfaches Beispiel zum Java Native Interface (JNI) - hier wird illustriert,
 * wie z.B. das Ermitteln der String-Länge an nativen Code delegiert werden kann
 * - evtl. aus Performance-Gründen.
 *
 * @author robert rohm
 */
public class Java_JNI {

  /**
   * Beispiel einer Methoden-Deklaration für eine in nativem Code imlpementierte
   * Routine - bezeichnend ist die Deklaration als <code>static native</code>.
   *
   * @return Ergebnis aus der nativen Routine.
   */
  public static native int getNumber();

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Beispiel: Ermitteln des Library-Suchpfads der JVM:
    System.out.println(System.getProperty("java.library.path"));

    // Aufruf einer Methode aus der nativen Bibliothek:
    System.out.println("StrLen: " + StrLen.strlen("Hallo Welt?!"));

  }
}
