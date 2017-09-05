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
package org.aeonium.testdatagenerator;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String userDir = System.getProperties().getProperty("user.dir");

    String outFile = "testdata";
    String mode = "list";
    int fromInt = 0;
    int toInt   = 100000;


    for (String arg : args) {

      String[] split = arg.split("=");
      String key = split[0];

      if (key.equals("out")) {
        outFile = split[1];
      }
      if (key.equals("min")) {
        fromInt = Integer.parseInt(split[1]);
      }
      if (key.equals("max")) {
        toInt = Integer.parseInt(split[1]);
      }
    }

    switch (mode) {
      case "list":
        boolean first = true;
        for (int i = fromInt; i <= toInt; i++) {
          if (!first) {
            System.out.print(",");
          }
          first = false;
          System.out.print(i);
        }
        break;
      default:
        throw new AssertionError();
    }
  }

}
