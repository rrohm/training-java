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
package java8.teil10.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Parallelisierte Manipulation aller Elemente in einem Array mit
 * Arrays.parallelSetAll().
 * <p>
 * <strong>Achtung!</strong>
 * <ul>
 *   <li>Für die Operatoren bzw. Funktionen, mit denen die Manipulation 
 *       durchgeführt wird, gelten dieselben Regeln wie in der paralleln
 *       Stream-Verarbeitung.
 *   </li>
 *   <li>Im Fall von Exceptions bricht die Verarbeitung ab, der Zustand der 
 *       Elemente des Arrays ist dann nicht klar definiert, teilweise verarbeitet
 *       und teilweise unverarbeitet.
 *   </li>
 * </ul>
 * 
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Arrays02_parallelSetAll {

  public static void main(String[] args) {

    // Endloser Stream
    IntStream dataStream = IntStream.iterate(0, x -> ++x);

    IntStream limitedDataStream = dataStream.limit(10);
    int[] data = limitedDataStream.toArray();
    
    System.out.println("data: " + Arrays.toString(data));

    // Beispiel: Parallele Manipulation aller Array-Elemente, 
    // hier mit einem IntUnaryOperator.
    Arrays.parallelSetAll(data, x -> x + 1000);
    
    System.out.println("data: " + Arrays.toString(data));
  }
}
