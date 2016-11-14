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
package org.meins.concurrency.prodcons_02;

import java.util.List;

/**
 * Verbesserte Version: diese Consumer werden mit notify/notifyAll
 * benachrichtigt, sobald es wieder neue Werkstücke zu verarbeiten gibt.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Consumer02 implements Runnable {

  private final List<Item> list;
  private final long sleeptime;
  private final String name;

  public Consumer02(final List<Item> list, final long sleeptime,
          final String name) {
    this.list = list;
    this.sleeptime = sleeptime;
    this.name = name;
  }

  @Override
  public void run() {
    // Auch hier: nur ausführen bis zur Abbruchbedingungn
    while (!Thread.currentThread().isInterrupted()) {

      boolean noItems = true;

      while (noItems) {
        synchronized (list) {
          noItems = (list.size() == 0);
          if (noItems) {
            System.out.println(this.name + " wartet ...");
          } else {
            System.out.println(this.name + " entnimmt "
                    + list.remove(0));
          }

          try {
            list.wait(sleeptime);
          } catch (InterruptedException e) {
            // Vgl. Producer
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
}
