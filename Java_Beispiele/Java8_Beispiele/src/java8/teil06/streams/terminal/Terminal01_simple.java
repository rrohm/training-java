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
package java8.teil06.streams.terminal;

import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal01_simple {

  public static void main(String[] args) {

    List<Person> persons = Person.createData();

    System.out.println("forEach(): Iterate through stream ");
    persons.stream().forEach(System.out::println);
    
    System.out.println("forEachOrdered(): Iterate through stream, with guaranteed order");
    persons.stream().forEachOrdered(System.out::println);
    
    // Ausgabe der Elemente in einem allgemeinen Array:
    Object[] objectArray = persons.stream().toArray();
    
    // Ausgabe der Elemente in ein spezifisches Array: Mit Generator-Funktion
//    Person[] personsArray = persons.stream().toArray(Person[]::new);
    Person[] personsArray = persons.stream().toArray(new IntFunction<Person[]>() {
      @Override
      public Person[] apply(int value) {
        Person[] resultArray = new Person[value];
        return resultArray;
      }
    });
    
    // Ein einzelnes Element aus dem Stream: erstes oder irgend eines: 
    Optional<Person> firstELement = persons.stream().findFirst();
    Optional<Person> anyELement = persons.stream().findAny();
    
    // ... mit den Optional-Werten arbeiten: 
    if (firstELement.isPresent()) {
      System.out.println("firstElement: " + firstELement.get());
    }
    
    Optional<Object> findFirstOfEmtpy = Stream.empty().findFirst();
    System.out.println("findFirstOfEmtpy: " + findFirstOfEmtpy);
    System.out.println("findFirstOfEmtpy contains: " + findFirstOfEmtpy.get());
    
    
  }
}
