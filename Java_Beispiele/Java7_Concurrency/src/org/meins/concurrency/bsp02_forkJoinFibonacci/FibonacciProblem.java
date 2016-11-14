/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.concurrency.bsp02_forkJoinFibonacci;

/**
 *
 * @author Administrator
 * @see http://www.javacodegeeks.com/2011/02/java-forkjoin-parallel-programming.html
 */
public class FibonacciProblem {

  public int n;

  public FibonacciProblem(int n) {
    this.n = n;
  }

  public long solve() {
    return fibonacci(n);
  }

  private long fibonacci(int n) {
    System.out.println("Thread: "
            + Thread.currentThread().getName() + " calculates " + n);
    if (n <= 1) {
      return n;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
}