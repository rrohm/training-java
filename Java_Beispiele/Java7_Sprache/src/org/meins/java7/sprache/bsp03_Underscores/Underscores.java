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
package org.meins.java7.sprache.bsp03_Underscores;

/**
 * Beispiel zur Verwendung von Unterstrichen zur besseren optischen Gliederung.
 * @author R. Rohm
 */
public class Underscores {

  long creditCardNumber = 1234_5678_9012_3456L;
  long socialSecurityNumber = 999_99_9999L;
  float pi = 3.14_15F;
  long hexBytes = 0xFF_EC_DE_5E;
  long hexWords = 0xCAFE_BABE;
  long maxLong = 0x7fff_ffff_ffff_ffffL;
  byte nybbles = 0b0010_0101;
  long bytes = 0b11010010_01101001_10010100_10010010;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      // nicht nötig
  }
}
