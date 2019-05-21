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
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package java8.interfaces.defaults;

/**
 * Diese Anwendung illustriert die in Java 8 neu hinzugekommene Möglichkeit, in
 * Interfaces für eine vorgeschriebene Methode eine Default-Implementierung mit
 * zu liefern. Dadurch wird de facto ein Erben von Methoden-Implementierungen
 * aus mehreren Vorfahren-Typen möglich (Mehrfach-Vererbung!)! Interessant zu
 * prüfen: was passiert, wenn eine Klasse mehrere in der Faces implementiert,
 * die für die selben Methoden mehrmals eine Default-Implementierung liefern?!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  public static void main(String[] args) {

    Interface01 objekt = new Klasse01();

    objekt.methodeAusIntf01();

    objekt.defaultMethode01();

    Klasse02 instanzVon02 = new Klasse02();
    instanzVon02.methodeAusIntf01();
    instanzVon02.methodeAusIntf03();
    instanzVon02.defaultMethode01();
    instanzVon02.defaultMethode03();

  }
}
