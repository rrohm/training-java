/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.concurrency.bsp02_forkJoinFibonacci;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Administrator
 */
public class FibonacciTask extends RecursiveTask<Long> {

  private static final long serialVersionUID = 6136927121059165206L;
  private static final int THRESHOLD = 5;
  private FibonacciProblem problem;
  public long result;

  public FibonacciTask(FibonacciProblem problem) {
    this.problem = problem;
  }

  @Override
  public Long compute() {
    if (problem.n < THRESHOLD) { // easy problem, don't bother with parallelism
      result = problem.solve();
    } else {
      FibonacciTask worker1 = new FibonacciTask(new FibonacciProblem(problem.n - 1));
      FibonacciTask worker2 = new FibonacciTask(new FibonacciProblem(problem.n - 2));
      worker1.fork();
      result = worker2.compute() + worker1.join();

    }
    return result;
  }
}