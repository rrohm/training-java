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
package org.meins.java8.methodenreferenz;

import java.util.Arrays;
import java.util.List;

/**
 * Dieses Beispiel illustriert die Austauschbarkeit von Lambda und
 * Methodenreferenz – unter der Bedingung, dass die referenzierte Methode die
 * einzige Anweisung innerhalb des Lambda-Ausdrucks ist, die zudem direkt auf
 * den Input-Wert angewendet wird.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_Methodenreferenz01 {

  public static void main(String[] args) {

    final List<String> names = Arrays.asList("Anna Lyse", "Max Mustermann", "Lisa Lauter", "Karl Käfer");

    // Lambda-Semantik
    names.forEach(name -> System.out.println(name));

    // Statt dessen: Methodenreferenz, wenn Methode einzige Anweisung des Lambdas ist: 
    names.forEach(System.out::println);

  }

}
