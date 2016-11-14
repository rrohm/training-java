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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Robert Rohm
 * @author Lars Vogel
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
public class CallableFutures {

  // Get the number of CPUs that the JVM sees:
  private static final int nProcessors = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {

    // The executors class provides methods to create thread pools - in the
    // application we simple use them as executor services interface.
    ExecutorService executor = Executors.newFixedThreadPool(nProcessors);

    // Das Future-Objekt ist "ein Platzhalter für einen Wert,
    // der erst in der Zukunft verfügbar sein wird".
    List<Future<Long>> list = new ArrayList<Future<Long>>();

    for (int i = 0; i < 900000; i++) {
      Callable<Long> worker = new MyCallable();
      // Der worker wird übergeben und - nach Möglichkeit - sofort gestartet.
      Future<Long> futureResult = executor.submit(worker);
      list.add(futureResult);
    }
    
    long sum = 0;
    System.out.println("List size: " + list.size());

    // Now retrieve the result
    for (Future<Long> futureResult : list) {
      try {
        // Versuch, das Callable-Ergebnis zu lesen - blockiert,
        // wenn die call()-Methode noch nicht abgearbeitet ist.
        sum += futureResult.get();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    System.out.println(sum);
    // Zum Schluss: Executor beenden, damit dieser keine neuen
    // Callables mehr annimmt und ggf. bei Verwendung von
    // executor.shutdownNow() versucht, jeden Thread zu beenden.
    executor.shutdown();
  }
}