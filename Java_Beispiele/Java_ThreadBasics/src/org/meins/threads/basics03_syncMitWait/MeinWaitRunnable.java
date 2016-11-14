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
package org.meins.threads.basics03_syncMitWait;

/**
 * Runnable, mit wait/notify koordiniert. Der Thread gibt den Monitor beim
 * Aufruf von wait() ab, so dass andere Threads mit demselben Lock-Objekct
 * weiterarbeiten können. Diese werden unmittelbar vor dem Abgeben des Monitors
 * mit notify() oder notifyAll() "darüber informiert", d.h. sobald das
 * Lock-Objekt frei wird, wird entweder eine anderer Thread vom Thread Sceduler
 * ausgewählt, oder alle benachrichtigten Threads konkurrieren um den Monitor.
 *
 * @author Robert Rohm
 */
public class MeinWaitRunnable implements Runnable {

  private int counter = 0;

  private final Object lock;
  private int sleepTime;

  public MeinWaitRunnable(Object lock, int sleepTime) {
    this.sleepTime = sleepTime;
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " startet.");
    
    synchronized (this.lock) {
      System.out.println(Thread.currentThread().getName() + " in sync.");

      while (!Thread.currentThread().isInterrupted()) {
        System.out.println(Thread.currentThread().getName() + " counter = " + counter++);

        if (counter % 100 == 0) {
          try {
            // Nachricht an alle wartenden Threads: "ich bin fertig und gebe ab!"
            // Die so "aufgeweckten" Threads müssen jedoch warten, bis der
            // Monitor auf das Lock-Objekt abgegeben wird.
            this.lock.notifyAll();

            // ... und geht in den Zustand 'waiting', d.h. er gibt den "Monitor"
            // auf eventuelle Lock-Objekte ab, und wartet, bis er ihn zurück
            // bekommt.
            this.lock.wait();
            
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
}
