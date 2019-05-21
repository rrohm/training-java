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
package org.meins.java8.unsigned;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class UnsignedAPIs {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    int maxSigned = Integer.MAX_VALUE;
    int unsigned = Integer.parseUnsignedInt("2147483648");
    System.out.println("maxSigned: " + maxSigned);
    System.out.println("unsigned:  " + unsigned);

    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE + 1;
    System.out.printf("%d %d%n", x, y);
    System.out.printf("x compared to y: %d%n", Integer.compare(x, y));
    System.out.printf("x compared to y: %d%n", Integer.compareUnsigned(x, y));
    System.out.printf("y divided by x: %d%n", y / x);
    System.out.printf("y divided by x: %d%n", Integer.divideUnsigned(y, x));
    System.out.printf("x+y: %s%n", Integer.toString(x + y));
    System.out.printf("x+y: %s%n", Integer.toUnsignedString(x + y));
    System.out.printf("parse(\"2147483647\"): %d%n", Integer.parseUnsignedInt("2147483647"));
    System.out.printf("parse(\"2147483648\"): %d%n", Integer.parseUnsignedInt("2147483648"));
    System.out.printf("parse(\"-2147483648\"): %d%n", Integer.parseUnsignedInt("-2147483648"));
  }
}
