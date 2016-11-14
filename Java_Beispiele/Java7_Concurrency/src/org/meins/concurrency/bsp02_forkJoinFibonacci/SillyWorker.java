/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.concurrency.bsp02_forkJoinFibonacci;

import org.meins.utils.Stopwatch;

/**
 *
 * @author Administrator
 */
public class SillyWorker {

  public static void main(String[] args) throws Exception {

    int n = 15;

    Stopwatch stopWatch = new Stopwatch();
    FibonacciProblem bigProblem = new FibonacciProblem(n);

    long result = bigProblem.solve();
//    stopWatch.stop();

    System.out.println("Computing Fib number: " + n);
    System.out.println("Computed Result: " + result);

    System.out.println("Elapsed Time (ms): " + stopWatch.getElapsedMillis());

  }
}
