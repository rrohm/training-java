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
 * CountDownLatchExample.java - this example illustrates the use of a countdown
 * latch in order to coordinate an arbitrary number of threads: in this
 * scenario, one latch is used to have all threads start at the same time, and
 * another latch is used to have the main thread wait until all other threads
 * have finished execution.
 *
 * @author robert rohm
 */
public class CountDownLatchExample {

  public static void main(String[] args){
    // Number of threads
    final int N = 100;

    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal  = new CountDownLatch(N);

    // create and start Threads - take a look inside the runnables: at first
    // they wait at the startSignal latch, and when their run() method is done,
    // they increment the doneSignal by one.
    for (int i = 0; i < N; i++) {
      new Thread(new MyRunnable(startSignal, doneSignal)).start();
    }
    System.out.println("Threads prepared, now: START!");
    startSignal.countDown();
    startSignal.countDown();// wirkungslos, wenn Latch schon auf 0

    System.out.println("... working ...");
    try {
      doneSignal.await();
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    System.out.println("DONE.");
  }
}
