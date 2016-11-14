/*
 * This code is released under Creative Commons Attribution 4.0 International
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means:
 *
 * You are free to:
 *
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 *
 *     The licensor cannot revoke these freedoms as long as you follow the
 *     license terms.
 *
 * Under the following terms:
 *
 *     Attribution — You must give appropriate credit, provide a link to the
 *     license, and indicate if changes were made. You may do so in any
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license
 * permits.
 */
package org.meins.concurrency.bsp02_callables;

import java.util.concurrent.Callable;

/**
 * Das Callable arbeitet im Prinzip wie ein Runnable,
 * das einen Ergebnis-Wert zurückgibt. Dazu muss die
 * Klasse mit dem Rückgabetyp parametrisiert werden.
 *
 * @author R. Rohm
 * @author Lars Vogel
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
public class MyCallable implements Callable<Long> {

  @Override
  public Long call() throws Exception {
    long sum = 0;
    for (long i = 0; i <= 100; i++) {
      sum += i;
    }
    return sum;
  }
}
