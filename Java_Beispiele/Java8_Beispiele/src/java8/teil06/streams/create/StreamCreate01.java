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
package java8.teil06.streams.create;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Zur Erzeugung von Streams stehen mehrere Möglichkeiten bereit - auch
 * Sonderfälle wie endlose Streams oder leere Streams sind in der API
 * berücksichtigt.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class StreamCreate01 {

  public static void main(String[] args) {

    // Stream aus Array oder Collection
    String[] namesArray = {"Anna", "Max", "Klaus", "Barbara", "Christian"};
    List<String> namesList = Arrays.asList(namesArray);

    Stream<String> streamFromArray = Arrays.stream(namesArray);
    Stream<String> streamFromList = namesList.stream();

    // Streams für Wertebereiche
    Stream<String> namesStream2 = Stream.of("Anna", "Max", "Klaus", "Barbara", "Christian");
    IntStream rangeStream = IntStream.range(0, 10);

    // Endlose Streams
    // a)
    IntStream iteratedStream = IntStream.iterate(0, x -> x + 1);
    // b)
    AtomicInteger ai = new AtomicInteger(0);
    Stream<Integer> generatedStream = Stream.generate(ai::getAndIncrement);
    // Leerer Stream
    Stream<String> emptyStream = Stream.empty();
    
    // Was ist wenn ...
    System.out.println("Endlosen Stream ausgeben?!");
    IntStream peekedIntStream = iteratedStream.peek( i -> {
      System.out.println("a) " + i);
    });
    IntStream sorted = peekedIntStream.sorted();
//    peekedIntStream.forEach(System.out::println);
    sorted.forEach(j -> {
      System.out.println("b) " + j);
    });
  }
}
