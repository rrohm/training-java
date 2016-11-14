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
package org.meins.threads.basics02_syncMitSleep;


/**
 * Runnable mit Sleep-Zeit, suboptimal implementiert, weil es innerhalb eines
 * synchronized-Blocks schläft. Bei Sleep bleibt die Sperre erhalten, der aktive
 * Thread behält den Monitor auf dem Lock-Objekt.
 *
 * @author Robert Rohm
 */
public class MeinSleepRunnable implements Runnable {
  private int counter = 0;

  private final Object lock;
  private int sleepTime;

  public MeinSleepRunnable(Object lock, int sleepTime) {
    this.sleepTime = sleepTime;
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " startet.");

    synchronized(this.lock){
      System.out.println(Thread.currentThread().getName() + " in sync.");

      while (!Thread.currentThread().isInterrupted()) {
        System.out.println(Thread.currentThread().getName() + " counter = " + counter++);

        if (counter % 10000 == 0) {
          try {
            // Schlecht! Bei Sleep bleibt die Sperre erhalten,
            // dieser Thread behält den Monitor (!!!).
            Thread.sleep(sleepTime);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        }
      }

    }
  }
}
