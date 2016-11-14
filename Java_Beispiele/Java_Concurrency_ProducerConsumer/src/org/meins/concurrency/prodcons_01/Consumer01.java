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
 * Erste, etwas naive Implementierung eines Consumers: er geht nach einem
 * Verarbeitungsschritt aktiv in eine sleep()-Pause - und verliert damit
 * wertvolle Zeit. Immerhin tut er das nicht während seines synchronized-Blocks,
 * dann würde er die gesamte Anwendung ausbremsen, da während sleep() eventuelle
 * Monitore (Sperren) nicht freigegeben werden. Dies wäre ein Kardinalfehler im
 * Multithreading!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Consumer01 implements Runnable {

    private final List<Item> list;
    private final long sleeptime;

    public Consumer01(final List<Item> list, final long sleeptime) {
        this.list = list;
        this.sleeptime = sleeptime;
    }

    @Override
    public void run() {
        // Auch hier: nur ausführen bis zur Abbruchbedingungn
        while (!Thread.currentThread().isInterrupted()) {

            boolean noItems = true;

            while (noItems) {
                Item removedItem = null;
                synchronized (list) {
                    noItems = (list.size() == 0);
                    if (noItems) {
                        System.out.println("Consumer wartet ...");
                    } else {
                        // Besser nicht hier verarbeiten, sondern nur entnehmen
                        // (zumindest dann, wenn die Verarbeitung signifikant
                        // Zeit konstet)
                        removedItem = list.remove(0);
                    }
                }
                // Eigentliche Verarbeitung des Items wurde hier ausgelagert, 
                // um den synchronized-Block so schnell wie möglich 
                // verlassen zu können.
                if (removedItem != null) {
                    System.out.println("Consumer verarbeitet " + removedItem);
                    removedItem = null;
                }

                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException e) {
                    // Vgl. Producer
                    Thread.currentThread().interrupt();
                }
            }

      // Wenn doch Items:
            // ACHTUNG - das ist ein erstes Beispiel:
            // Zwei separate sync.-Blöcke - nicht geeignet für
            // mehrere Consumer!
            // synchronized (list) {
            // System.out.println("Consumer entnimmt " + list.remove(0));
            // }
        }
    }
}
