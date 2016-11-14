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
package org.meins.threads.basics04_syncVsAsync;


/**
 * Runnable, das auf ein gemeinsam genutztes Objekt mit Synchronisierung
 * schreibend und lesend zugreift.
 *
 * @author Robert Rohm
 */
public class MeinSyncRunnable implements Runnable {
  private int counter = 0;

  private final MeinObjekt lock;

  public MeinSyncRunnable(MeinObjekt lock) {
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " startet.");
    synchronized(this.lock){
      System.out.println(Thread.currentThread().getName() + " in sync.");

      while (!Thread.currentThread().isInterrupted()) {
        this.lock.setWert(Thread.currentThread().getName() + " counter: " + counter++);
        System.out.println(Thread.currentThread().getName() + "| " + this.lock.getWert());

        if (!this.lock.getWert().startsWith(Thread.currentThread().getName())) {
          System.out.println("SYNC !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + this.lock.getWert() + " vs " + Thread.currentThread().getName());
        }
      }

    }
  }
}
