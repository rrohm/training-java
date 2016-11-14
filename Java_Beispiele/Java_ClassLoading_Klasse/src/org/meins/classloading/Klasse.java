/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.classloading;

/**
 * Beispiel-Klasse für Nachladen externer Klassen
 *
 */
public class Klasse {

  // Statischer Code, wird bei der Initialisierung
  // der Klasse ausgeführt:
  static {
    System.out.println("Klasse geladen. ");
  }
}
