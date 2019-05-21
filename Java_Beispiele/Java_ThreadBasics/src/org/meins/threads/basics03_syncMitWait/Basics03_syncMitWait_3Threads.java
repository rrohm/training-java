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
 * Beispiel: Zwei ungebremste Threads, synchronisiert auf demselben Lock-Objekt,
 * Thread-Koordination mit wait() und notifyAll().
 * Fazit: Der erste Thread, der in den synchronen Block läuft, gibt zum
 * definierten Punkt die Ausführung an einen anderen Thread weiter, indem er
 * zuerst notifyAll() und dann wait() auf dem Lock-Objekt aufruft. Er verliert
 * damit den Monitor! Damit kann ein anderer Thread auf dem Lock-Objekt arbeiten.
 *
 * Achtung! Hier sieht es so aus, als ob zwei Threads sich gleichzeitig
 * innerhalb ihres synchronized-Blocks (auf demselben Objekt!!!) befänden.
 * Dies ist nur scheinbar so, da mit Aufruf von wait() der Monitor abgegeben
 * wird.
 *
 * @author robert rohm
 */
public class Basics03_syncMitWait_3Threads {


  public static void main(String[] args){
    Object beliebigesLockObjekt = new Object();
    int sleepTime = 50;

    new Thread(new MeinWaitRunnable(beliebigesLockObjekt, sleepTime)).start();
    new Thread(new MeinWaitRunnable(beliebigesLockObjekt, sleepTime)).start();
    new Thread(new MeinWaitRunnable(beliebigesLockObjekt, sleepTime)).start();
  }
}
