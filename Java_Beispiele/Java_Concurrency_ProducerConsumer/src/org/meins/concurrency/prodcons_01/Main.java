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

import java.util.ArrayList;
import java.util.List;

/**
 * Hauptklasse zum Producer-Consumer-Problem (Version 1).
 * Die erste Version illustriert einen einfachen, suboptimalen Ansatz, da hier
 * Verzögerungen mit der sleep()-Methode verwendet werden. Dadurch geht viel
 * Zeit verloren, die bei erhöhten Produkt-Stückzahlen sinnvoll genützt werden
 * könnte.
 *
 * @author R. Rohm
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // Zwei Threads teilen sich eine Liste
    // von Werkstücken:
    List<Item> list = new ArrayList<Item>();

    new Thread(new Producer01(list, 800)).start();
    new Thread(new Consumer01(list, 500)).start();
  }
}
