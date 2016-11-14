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
package org.meins.concurrency.bsp03_atomicInt;

/**
 * Demo für Multithreading mit Callable-Objekten und atomarer
 * Increment-Operation.
 *
 * @author Robert Rohm
 * @author Lars Vogel
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

  private static final int NTHREDS = 10;

  public static void main(String[] args) {
    final Counter counter = new Counter();
    List<Future<Integer>> list = new ArrayList<Future<Integer>>();

    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    for (int i = 0; i < 500; i++) {
      Callable<Integer> worker = new Callable<Integer>() {

        @Override
        public Integer call() throws Exception {
          int number = counter.increment();
          System.out.println(number);
          return number;
        }
      };
      Future<Integer> submit = executor.submit(worker);
      list.add(submit);

    }


    // This will make the executor accept no new threads
    // and finish all existing threads in the queue
    executor.shutdown();
    // Wait until all threads are finish
    while (!executor.isTerminated()) {
    }

    Set<Integer> set = new HashSet<Integer>();
    for (Future<Integer> future : list) {
      try {
        set.add(future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    if (list.size() != set.size()) {
      throw new RuntimeException("Double-entries!!!");
    }
  }
}