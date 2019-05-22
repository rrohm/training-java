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
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Arrays01_parallelSort {

  public static void main(String[] args) {
    
    // Endloser Stream
    IntStream dataStream = IntStream.iterate(0, x -> {
      return (int) (100_000 * Math.random());
    });
    
    IntStream limitedDataStream = dataStream.limit(10_000_000);
    int[] data1 = limitedDataStream.toArray();
    int[] data2 = Arrays.copyOf(data1, data1.length);
    
    // Seq. Sort.
    long start = System.nanoTime();
    Arrays.sort(data1);
    System.out.println("Seq: " + (System.nanoTime() - start));
    
    // Parallel. Sort.
    start = System.nanoTime();
    Arrays.parallelSort(data2);
    System.out.println("Par: " + (System.nanoTime() - start));
    
//    System.out.println("Array: " + Arrays.toString(data2));


    // Beispiel: Parallele Manipulation aller Array-Elemente
    // mit einem IntUnaryOperator.
    Arrays.parallelSetAll(data2, x -> x+1);
  }
}
