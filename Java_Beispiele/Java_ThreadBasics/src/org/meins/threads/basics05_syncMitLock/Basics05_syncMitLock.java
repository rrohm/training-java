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
import java.util.concurrent.locks.ReentrantLock;

/**
 * Beispiel: Zwei ungebremste Threads, synchronisiert mit einem Lock-Objekt und
 * einem Condition-Objekt, Thread-Koordination mit await() und signalAll().
 *
 * @author robert rohm
 */
public class Basics05_syncMitLock {


  public static void main(String[] args){
    Lock lockObjekt = new ReentrantLock();
    Condition fertigCondition = lockObjekt.newCondition();

    int sleepTime = 5000;

    new Thread(new MeinConditionalRunnable(lockObjekt, fertigCondition, sleepTime)).start();
    new Thread(new MeinConditionalRunnable(lockObjekt, fertigCondition, sleepTime)).start();
  }
}
