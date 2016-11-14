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
package org.meins.threads.basics05_syncMitLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Runnable mit ReentrantLock - das ReentrantLock-Objekt kann als Abstraktion
 * dienen, um nicht direkt auf einem selbst zu wählenden "einfachen" Objekt
 * synchronisieren zu müssen. Die Handhabung ähnelt jedoch ganz stark dem
 * wait()- und notify()-Mechanismus.
 *
 * @author Robert Rohm
 */
public class MeinConditionalRunnable implements Runnable {

  private int counter = 0;
  private final Lock lock;
  private final Condition c;
  private int sleepTime;

  public MeinConditionalRunnable(Lock lock, Condition c, int sleepTime) {
    this.c = c;
    this.sleepTime = sleepTime;
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " startet.");
    // Hier blockiert die Ausführung, falls das Lock nicht verfügbar ist
    // (vgl. synchronize(this.lock)!
    this.lock.lock();

    System.out.println(Thread.currentThread().getName() + " in sync.");

    try {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println(Thread.currentThread().getName() + " counter = " + counter++);

        // Hier: in regelmäßigen Abständen "abgeben" an andere Threads:
        if (counter % 10 == 0) {

          this.c.signalAll();
          this.c.await();
        }
      }
    } catch (InterruptedException ex) {
      Logger.getLogger(MeinConditionalRunnable.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      // explizites Freigeben des Locks, d.h. verlassen des synchronisierten BLocks.
      this.lock.unlock();
    }

  }
}
