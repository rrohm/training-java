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
package org.meins.threads.basics01_sync;

/**
 * Beispiel: Zwei ungebremste Threads, synchronisiert auf demselben Lock-Objekt,
 * zusammen mit einem dritten Thread, synchronisiert auf einem anderen Objekt.
 * Fazit: Der erste Thread, der in den synchronen Block läuft, bleib in der
 * darin laufenden Schleife. Der zweite wartet, und kann nicht in seinen
 * synchronen Block eintreten, weil der erste Thread auf demselben Objekt
 * synchronisiert hat. Der dritte Thread läuft davon unbeeindruckt.
 *
 * @author robert rohm
 */
public class Basics01_sync1 {


  public static void main(String[] args){
    Object beliebigesLockObjekt = new Object();
    Object anderesLockObjekt = new Object();

    new Thread(new MeinRunnable(beliebigesLockObjekt)).start();
    new Thread(new MeinRunnable(beliebigesLockObjekt)).start();
    new Thread(new MeinRunnable(anderesLockObjekt)).start();
  }
}
