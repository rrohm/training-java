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
 * Start class, creates 5 threads that try to acquire 4 permits of the semaphore
 * @author robert rohm
 */
public class SemaphoreExample01 {

  public static void main(String[] args){

    // Dieses Semaphore-Objekt verwaltet 4 "Genehmigungen"
    Semaphore semaphore = new Semaphore(4, true);
    // ... oder praktischer: 
    // semaphore = new Semaphore(Runtime.getRuntime().availableProcessors(), true);

    new Thread(new MyRunnable(semaphore)).start();
    new Thread(new MyRunnable(semaphore)).start();
    new Thread(new MyRunnable(semaphore)).start();
    new Thread(new MyRunnable(semaphore)).start();
    
    new Thread(new MyRunnable(semaphore)).start();
  }
}
