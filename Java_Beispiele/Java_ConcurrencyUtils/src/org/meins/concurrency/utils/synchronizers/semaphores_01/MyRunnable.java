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
package org.meins.concurrency.utils.synchronizers.semaphores_01;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreExample01.java
 * Runnable, tries to acquire a permit from  the semaphore.
 * @author robert rohm
 */
public class MyRunnable implements Runnable {

  private final Semaphore semaphore;

  public MyRunnable(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    try {
      // first: acquire a permit:
      this.semaphore.acquire();
      // then: start working ...
      System.out.println(Thread.currentThread().getName() + " started ...");
      Thread.currentThread().sleep(5000);


    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();

    } finally {
      // Done or failure?
      // IMPORTANT: Release permit in any case!
      this.semaphore.release();
    }
    System.out.println(Thread.currentThread().getName() + " finished");
  }
}
