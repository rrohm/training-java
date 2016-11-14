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
package org.meins.concurrency.bsp01_threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This example illustrates the use of a thread pool, dimensioned according to
 * the number of CPU cores that the JVM actually sees.
 *
 * @author Robert Rohm
 * @author Lars Vogel
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
public class Main {

  // Get the number of CPU cores visible to the VM:
  private static final int nProcessors = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {

    // Set number of threads to number of CPUs seen by the VM in a fixed
    // thread pool - this is only one possible strategy, see the Exeturors
    // API for other thread pool implementations. Number of Threads also
    // depends heavily on the actual use case. 
    ExecutorService executor = Executors.newFixedThreadPool(nProcessors);
    for (int i = 0; i < 500; i++) {
      Runnable worker = new MyRunnable(10000000L + i);
      executor.execute(worker);
    }

    // This will make the executor accept no new threads
    // and finish all existing threads in the queue
    executor.shutdown();

    // Wait until all threads are finish
    while (!executor.isTerminated()) {
    }
    System.out.println("Finished all threads");
  }
}