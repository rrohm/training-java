/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.concurrency.bsp02_forkJoinFibonacci;

/**
 *
 * @author R. Rohm
 */
import java.util.concurrent.ForkJoinPool;
import org.meins.utils.Stopwatch;

public class ForkJoinWorker {

 public static void main(String[] args) {

  // Check the number of available processors
  int processors = Runtime.getRuntime().availableProcessors();
  System.out.println("No. of processors: " + processors);

  int n = 15;

  Stopwatch stopWatch = new Stopwatch();
  FibonacciProblem bigProblem = new FibonacciProblem(n);

  FibonacciTask task = new FibonacciTask(bigProblem);
  ForkJoinPool pool = new ForkJoinPool(processors);
  pool.invoke(task);

  long result = task.result;
  System.out.println("Computed Result: " + result);

  System.out.println("Elapsed Time (ms): " + stopWatch.getElapsedMillis());

 }

}