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
package org.meins.generics.bsp03_Wortzaehler;

import java.util.Hashtable;

/**
 *
 * @author R. Rohm
 */
public class Zaehler02 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Input: " + args.length + " Wörter");

    Hashtable<String, Integer> h = new Hashtable<String, Integer>();
    for (String key : args) {
      if (h.containsKey(key)) {
        h.put(key, 1 + h.get(key));
      } else {
        h.put(key, 1);
      }
    }
    System.out.println(h);
  }
}

// sein oder nicht sein das ist hier die Frage die nicht sein soll