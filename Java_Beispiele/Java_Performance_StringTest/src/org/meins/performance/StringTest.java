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
package org.meins.performance;

/**
 * Performance-Vergleich verschiedener Methoden zur String-Verkettung - einfach
 * einmal starten und die Laufzeiten vergleichen!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class StringTest {

  /**
   * @param args the command line arguments
   * @throws java.lang.InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {

    /**
     * Hier kann die Anzahl der Verkettuns-Durchgänge justiert werden. Je höher,
     * umso repräsentativer sind die Ergebnisse, wenn es um die reine
     * Ausführungsgeschwindigkeit bei der Verkettung geht.
     */
    int tests = 100_000;

    String a = "abc";
    String ergebnis = "";

    System.out.println("Gleich geht's los");
    Thread.sleep(3000);

    System.out.println("1. Konkatenation mit += ");
    long startZeit = System.currentTimeMillis();
    for (int i = 0; i < tests; i++) {
      ergebnis += a;
    }
    System.out.println("Zeit:         " + (System.currentTimeMillis() - startZeit) + " ms");
    System.out.println("String-Länge: " + ergebnis.length());

    System.out.println("2. Konkatenation mit + ");
    startZeit = System.currentTimeMillis();
    ergebnis = "";
    for (int i = 0; i < tests; i++) {
      ergebnis = ergebnis + a;
    }
    System.out.println("Zeit:         " + (System.currentTimeMillis() - startZeit) + " ms");
    System.out.println("String-Länge: " + ergebnis.length());


    System.out.println("3. Konkatenation mit .concat() ");
    startZeit = System.currentTimeMillis();
    ergebnis = "";
    for (int i = 0; i < tests; i++) {
      ergebnis = ergebnis.concat(a);
    }
    System.out.println("Zeit:         " + (System.currentTimeMillis() - startZeit) + " ms");
    System.out.println("String-Länge: " + ergebnis.length());


    System.out.println("4. Konkatenation mit StringBuffer ");
    ergebnis = "";
    StringBuffer sbf = new StringBuffer(ergebnis);
    startZeit = System.currentTimeMillis();
    for (int i = 0; i < tests; i++) {
      sbf.append(a);
    }
    ergebnis = sbf.toString();
    System.out.println("Zeit:         " + (System.currentTimeMillis() - startZeit) + " ms");
    System.out.println("String-Länge: " + ergebnis.length());


    System.out.println("5. Konkatenation mit StringBuilder ");
    ergebnis = "";
    StringBuilder sb = new StringBuilder(ergebnis);
    startZeit = System.currentTimeMillis();
    for (int i = 0; i < tests; i++) {
      sb.append(a);
    }
    ergebnis = sb.toString();
    System.out.println("Zeit:         " + (System.currentTimeMillis() - startZeit) + " ms");
    System.out.println("String-Länge: " + ergebnis.length());

  }
}
