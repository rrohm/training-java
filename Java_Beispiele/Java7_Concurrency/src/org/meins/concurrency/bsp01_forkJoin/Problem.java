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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.concurrency.bsp01_forkJoin;

/**
 *
 * @author R. Rohm
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
import java.util.Random;

/**
 *
 * This class defines a long list of integers which defines the problem we will
 * later try to solve
 *
 */
public class Problem {

  private final int[] list = new int[20000000];

  public Problem() {
    Random generator = new Random(19580427);
    for (int i = 0; i < list.length; i++) {
      list[i] = generator.nextInt(500000);
    }
  }

  public int[] getList() {
    return list;
  }
}