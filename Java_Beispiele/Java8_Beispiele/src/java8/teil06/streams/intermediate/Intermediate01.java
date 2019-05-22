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
package java8.teil06.streams.intermediate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Erstes Beispiel zu Intermediate-Operationen auf Streams.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Intermediate01 {
  
  public static void main(String[] args) {
    
    List<Person> persons = Person.createData();
    
    // 1. Filterung
    Stream<Person> filtered = persons.stream().filter( person -> person.getAge() >= 18);
    // 2. Sortierung
    Stream<Person> peeked1 = filtered.peek(System.out::println);
//    Stream<Person> sorted = filtered.sorted( (person1, person2) -> 
    Stream<Person> sorted = peeked1.sorted( (person1, person2) -> 
      person1.getName().compareTo(person2.getName())
    );
    // 3. Mapping bzw. Abbildung, evtl. hier als String
//    sorted.map(new Function<Person, String>() {
//      @Override
//      public String apply(Person t) {
////        return t.getName() + " " +  ... Oh NO! -> Person#toString()
//      }
//    }
//    )
    // ACHTUNG: Es gibt *eine* Methode, die das Ergebnis zurückgibt -> Referenz!
    Stream<String> mappedStream = sorted.map(Person::toString);
    
    // 4. Optional: bei Bedarf Elemente inspizieren: 
    //    Achtung: so lange es keine terminal operation gibt, wird die Stream-
    //    Verarbeitung nicht angestoßen!
    Stream<String> peekedStream = mappedStream.peek(System.out::println);
    
    // 5. Zum Schluss: Ergebnis-Menge mit Collector abholen
    System.out.println("peekedStream "  + peekedStream);
    // ... hier Iteration mit forEach
    peekedStream.forEach(System.out::println);
    
    
  }
}
