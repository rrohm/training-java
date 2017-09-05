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

/**
 *
 * @author Robert Rohm
 */
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class Solver extends RecursiveTask<Long> {

  private int[] list;
  public long result;

  public Solver(int[] array) {
    this.list = array;
  }

  /**
   *
   * @return Lösung des (Teil-)Problems
   */
  @Override
  protected Long compute() {
    if (list.length == 1) {
      result = list[0];
    } else {
      int midpoint = list.length / 2;
      int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
      int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
      Solver s1 = new Solver(l1);
      Solver s2 = new Solver(l2);

      s2.fork();
      result = s1.compute() + s2.join();
    }
    return result;
  }
}