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
public class Zaehler01 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    System.out.println("Input: " + args.length + " Wörter");

    Hashtable h = new Hashtable();
    for (int i = 0; i < args.length; ++i) {
      int cnt = 1;
      if (h.containsKey(args[i])) {
        cnt = 1 + ((Integer) h.get(args[i])).intValue();
      }
      h.put(args[i], new Integer(cnt));
    }
    System.out.println(h);
  }
}

// sein oder nicht sein das ist hier die Frage die nicht sein soll