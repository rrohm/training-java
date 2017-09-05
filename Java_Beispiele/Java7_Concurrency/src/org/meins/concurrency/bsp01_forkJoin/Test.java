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
package org.meins.concurrency.bsp01_forkJoin;

import java.util.concurrent.ForkJoinPool;
import org.meins.utils.Stopwatch;

/**
 *
 * @author R. Rohm
 */
public class Test {

  public static void main(String[] args) {
    Problem test = new Problem();
    // Check the number of available processors
    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println(nThreads);
    Stopwatch w = new Stopwatch();

    // Der Solver bekommt das Problem übergeben
    // und ist dafür zuständig, das Problem
    // a) entweder selbst sofort zu lösen
    // b) oder in Teilprobleme aufzuspalten und diese an neue
    //    Solver zu übergeben
    Solver mfj = new Solver(test.getList());

    ForkJoinPool pool = new ForkJoinPool(nThreads);
    // Lösung des Problems ...
    pool.invoke(mfj);

    // Ergebnis fertig
    long result = mfj.result;

    System.out.println("Done. Result: " + result + " (" + w.getElapsedMillis() + " ms)");
    long sum = 0;
    // Check if the result was ok

    w = new Stopwatch();
    for (int i = 0; i < test.getList().length; i++) {
      sum += test.getList()[i];
    }
    System.out.println("Done. Result: " + sum + " (" + w.getElapsedMillis() + " ms)");
  }
}