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
package org.meins.java.performance;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_Performance_FinalParams {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    long rounds = 10_000_000_000L;
    runMethod(rounds);
    runMethod(rounds);
    runMethod(rounds);
    runMethod(rounds);
    runMethod(rounds);

    runFinalMethod(rounds);
    runFinalMethod(rounds);
    runFinalMethod(rounds);
    runFinalMethod(rounds);
    runFinalMethod(rounds);
  }

  public static void runMethod(long rounds){
    System.out.println("\nrunMethod " + rounds);
    final long start = System.currentTimeMillis();
    long sum = 0;
    for (long i = 0; i < rounds; i++) {
       sum += methodWithLongParam(i);
    }
    final long end = System.currentTimeMillis();
    System.out.println("Ergebnis: " + sum);
    System.out.println("Dauer   : " + (end - start) + " ms");
  }
  public static void runFinalMethod(long rounds){
    System.out.println("\nrunFinalMethod " + rounds);
    final long start = System.currentTimeMillis();
    long sum = 0;
    for (long i = 0; i < rounds; i++) {
       sum += methodWithFinalLongParam(i);
    }
    final long end = System.currentTimeMillis();
    System.out.println("Ergebnis: " + sum);
    System.out.println("Dauer   : " + (end - start) + " ms");
  }

  public static long methodWithLongParam(long l){
    return l + 1;
  }

  public static long methodWithFinalLongParam(final long l){
    return l + 1;
  }


}
