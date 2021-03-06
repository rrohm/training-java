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
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/**
 * Parallelisiertes Kumulieren von Array-Elementen mit Arrays.parallelPrefix().
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Arrays02_parallelPrefix {

  public static void main(String[] args) {

    // Endloser Stream
    IntStream dataStream = IntStream.iterate(0, x -> ++x);

    IntStream limitedDataStream = dataStream.limit(10);
    int[] data = limitedDataStream.toArray();

    System.out.println("data: " + Arrays.toString(data));

    // Langform mit anonymem BinaryOperator: 
    Arrays.parallelPrefix(data, new IntBinaryOperator() {
      /**
       * Operator-Methode für Zusammenfassung des bisherigen Zwischenergebnisses
       * mit dem nächsten diskreten Wert.
       *
       * @param left
       * @param right
       * @return
       */
      @Override
      public int applyAsInt(int left, int right) {
        System.out.printf("left: %d \tright: %d\n", left, right);
        return left + right;
      }
    });

    System.out.println("data: " + Arrays.toString(data));
  }
}
