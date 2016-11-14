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
package org.meins.concurrency.prodcons_01;

import java.util.List;

/**
 * Erste, etwas naive Producer-Implementierung - hier geht der Producer einfach
 * per sleep() in eine Pause, nachdem er ein neues Objekt produziert und in die
 * Warteschlange eingefügt hat. Sinnvoller wäre, er würde die Consumer
 * benachrichtigen, sobald es wieder Arbeit gäbe - siehe Package prodcons_02
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Producer01 implements Runnable {

  private final List<Item> list;
  private final long sleeptime;

  public Producer01(final List<Item> list, final long sleeptime) {
    this.list = list;
    this.sleeptime = sleeptime;
  }

  /**
   * Die Run-Methode wird niemals von uns selbst aufgerufe!!! Sie wird immer von
   * einem Thread ausgeführt.
   */
  @Override
  public void run() {
    int counter = 0;

    // Die Arbeit im Thread darf nur ausgeführt werden,
    // solange eine Abbruch-Bedingung nicht erfüllt ist
    //
    while (!Thread.currentThread().isInterrupted()) {
      final Item newItem = new Item("Item " + counter);
      System.out.println("Producer erzeugt " + newItem);

      // neues Objekt in Liste legen:
      // synchronisieren!
      synchronized (list) {
        list.add(newItem);
        System.out.println("Producer fertig mit " + newItem);
      }

      // Nach der Arbeit: Pause machen
      try {
        Thread.sleep(sleeptime);
      } catch (InterruptedException e) {
        // ACHTUNG: die Exception wurde möglicherweise
        // nicht ohne Grund geworfen, sondern weil der
        // Thread unterbrochen werden sollte. Für diesen
        // Fall: Selbst interrupt() aufrufen.
        Thread.currentThread().interrupt();
      }

      counter++;
    }
  }
}
