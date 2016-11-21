/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 *
 *  You are free to:
 *
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 *
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 *
 *  Under the following terms:
 *
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 *
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 *
 *
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java5.autoboxing;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Beispiel "Wörterzählung" - die Anwendung soll die Häufigkeit von Wörtern
 * zählen.
 *
 * Achtung: Autoboxing (automatische Umwandlung von primitiven Typen in die
 * entsprechenden Wrapper-Typen) ist immer "teuer" wegen der Instanzierung neuer
 * Objekte! => Mit Vorsicht verwenden! => Wo Performance wichtig ist, besser
 * primitive Typen verwenden.
 *
 * @author R. Rohm
 */
public class WordFrequency {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // Map: vgl. Dictionary oder assoziatives Array, 
    // hier: eine Map, die mit String-Schlüsseln und Integer-Werten 
    // arbeitet (siehe Generics!). Die generisch Map wird hier daher mit 
    // zwei Typ-Parametern deklariert - einen für den Key-Typ, einen für 
    // den Value-Typ. Damit kann hier typsicher gearbeitet werden, da dies
    // so für den Compiler prüfbar ist. 
    Map<String, Integer> m = new TreeMap<>(); // "Diamond Operator"/"Typ-Inferenz" aus JDK7

    for (String word : args) {
      Integer freq = m.get(word);
      
      // Ternärer Operator in Java: 
      // freq == null ? 1 : freq + 1
      // Typ ergebnis = (Bedingung)  ? (true-Fall) : (false-Fall)
      m.put(word, (freq == null ? 1 : freq + 1));
    }
    System.out.println(m);
  }
}
// Aufruf an Konsole z.B. mit diesem "Argument":
// sein oder nicht sein das ist hier die Frage die nicht sein soll
