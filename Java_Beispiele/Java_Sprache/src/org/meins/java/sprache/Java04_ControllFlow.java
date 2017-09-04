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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.sprache;

import java.util.Arrays;
import java.util.List;

/**
 * Diese Beispiel illustriert die grundlegen Kontrollstrukturen in Java.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java04_ControllFlow {

  public static void main(String[] args) {
    bedingteAnweisungenIf();

    bedingetAnweisungIfElse();

    bedingteAnweisungSwitch();

    bedingteAnweisungTernaererOperator();

    schleifeStandard();

    schleifeForEach();

    schleifeWhile();

    schleifeDo();

  }

  private static void schleifeDo() {
    do {
      //
    } while (true);
  }

  private static void schleifeWhile() {
    // 2) Schleifen
    while (true) {
      //
    }
  }

  private static void schleifeForEach() {
    List<String> namen = Arrays.asList("Anna Lyse", "Max Mustermann", "Lisa Lauter", "Karl Käfer");
    for (String string : namen) {

    }
  }

  private static void schleifeStandard() {
    for (int i = 0; i < 10; i++) {

    }
  }

  private static void bedingteAnweisungSwitch() throws AssertionError {
    int value = 1;

    switch (value) {
      case 1:

        break;
      default:
        throw new AssertionError();
    }
  }

  private static void bedingetAnweisungIfElse() {
    if (true) {
      //
    } else {
      //
    }
  }

  private static void bedingteAnweisungenIf() {
    // 1) Bedingte Anweisungen
    if (true) {
      //
    }
  }

  private static void bedingteAnweisungTernaererOperator() {

    boolean kriterium = true;

    String ergebnis = (kriterium) ? "Wert falls true" : "Wert falls false";

    System.out.println("Ergebnis mit ternärem Operator: " + ergebnis);
  }
}
