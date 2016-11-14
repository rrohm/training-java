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
 *  2016 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Unäre Operatoren benötigen nur einen einzigen Operanden. Der UnaryOperator
 * des Collection-Frameworks kann gut verwendet werden, um z.B. komplette
 * Collections zu verarbeiten und jedes Element zu modifizieren.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Collections03_UnaryOperator {

  public static void main(String[] args) {

    // Datenmenge: 
    final List<String> names = Arrays.asList("Anna Lyse", "Max Mustermann", "Lisa Lauter", "Karl Käfer");

    // Unärer Operator (mit Beispiellogik)
    UnaryOperator<String> shortenNameOperator = new UnaryOperator<String>() {
        
        /**
         * Hier wird die Transformationslogik implementiert ...
         * @param str Input
         * @return Output
         */
      @Override
      public String apply(String str) {
        return str.charAt(0) + "." + str.substring(str.indexOf(" "));
      }
    };

    // Oder kürzer, als Lambda (Abbildung eines Elements mit einer Abbildungsfunktion auf ein Ergebnis): 
    UnaryOperator<String> shortenName = str -> str.charAt(0) + "." + str.substring(str.indexOf(" "));
    
    // Operator-Objekte können wie jede Implementierung eines funktionalen 
    // Interfaces ganz diskret imperativ und ohne Collection eingesetzt werden.
    // (Vgl. Funktionales Paradigma, "eine Funktion wird angewendet auf ...")
    System.out.println("Einzel-Anwendung: " + shortenName.apply("Hans Worst"));

    // Verarbeitung der Collection mit .replaceAll()
    names.replaceAll(shortenName);
    names.forEach(System.out::println);
  }
}
