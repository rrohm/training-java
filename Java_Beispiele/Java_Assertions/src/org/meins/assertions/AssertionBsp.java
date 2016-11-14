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
package org.meins.assertions;

/**
 * Assertions sind ein Sprachmittel, um die Richtigkeit logischer Annahmen im
 * Code zur Laufzeit zu prüfen.
 *
 * @author robert rohm
 */
public class AssertionBsp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // Assertions, als Annahme, dass bestimmte
    // bedingungen erfüllt sein müssen
    int x = 1;
    int y = 2;

    meineMethode(x, y);

    // Dieser Aufruf muss fehlschlagen, wenn Assertions aktiviert sind.
    x = 2;
    y = 2;

    meineMethode(x, y);

    // Die folgende Zeile darf eigentlich nicht mehr ausgeführt werden, weil
    // die Ausführung der Methode mit einem AssertionError beendet werden müsste.
    System.err.println("FEHLER!!! Prüfung von Assertions ist nicht aktiv. \nDies Anwendung muss mit VM-Option -ea (enable assertions) gestartet werden!");
  }

  public static void meineMethode(int a, int b) {
    // in dieser Methode wird geprüft, ob
    // z. B. Parameter bestimmte bediungen erfüllen
    assert a != b;
    // ACHTUNG: Assertions sind standardmäßig DEAKTIVIERT!
    // -> daher ungeeignet als Exception-Ersatz!!!
    System.out.println("meineMethode ausgeführt.");
  }
}
