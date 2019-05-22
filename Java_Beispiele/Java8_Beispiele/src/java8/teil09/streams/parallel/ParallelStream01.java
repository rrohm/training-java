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
package java8.teil09.streams.parallel;

import java.util.stream.IntStream;

/**
 * Parallele Verarbeitung von Streams erzeugt nicht-deterministische Ausgabe in
 * forEach() - falls Reihenfolge wichtig ist, muss statt dessen forEachOrdered()
 * verwendet werden.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ParallelStream01 {

  public static void main(String[] args) {
    IntStream rangeStream = IntStream.range(0, 10);

    // Parallele Verarbeitung gegebener Streams:
    // ... mit Sortierung je nach Abarbeitung
    System.out.println("... mit Sortierung je nach Abarbeitung:");
    rangeStream.parallel().forEach(System.out::println);

    // ... sortiert trotz Parallelisierung
    System.out.println("... sortiert trotz Parallelisierung:");
    rangeStream = IntStream.range(0, 10);
    rangeStream.parallel().forEachOrdered(System.out::println);

  }
}
