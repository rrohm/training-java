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
package org.meins.concurrency.utils.synchronizers.countdownlatch_01;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchExample.java Runnable for the countdown latch example.
 *
 * @author robert rohm
 */
public class MyRunnable implements Runnable {

  private final CountDownLatch startSignal;
  private final CountDownLatch doneSignal;

  public MyRunnable(CountDownLatch startSignal, CountDownLatch doneSignal) {
    this.startSignal = startSignal;
    this.doneSignal = doneSignal;
  }

  @Override
  public void run() {
    try {
      // first: await start signal:
      this.startSignal.await();

      // start working ...
      System.out.println(Thread.currentThread().getName() + " started ...");
      Thread.currentThread().sleep(2000);

      // done? count down donw latch ... but not in the try-clause!!!
      System.out.println(Thread.currentThread().getName() + " finished");

    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();

    } finally {
      // WICHTIG: Es muss sichergestellt werden, dass das doneSignal
      // *in jedem Fall* am Ende des Thread-Codes dekrementiert wird!
      this.doneSignal.countDown();
    }
  }

}
