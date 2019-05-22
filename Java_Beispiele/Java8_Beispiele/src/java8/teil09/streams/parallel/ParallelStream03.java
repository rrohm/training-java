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

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Beispiel zur parallelisierten Listen-Verarbeitung, mit Concurrent-Collector
 * für parallelisierte Gruppierung
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ParallelStream03 {

  public static void main(String[] args) {

    List<Person> persons = Person.createData();

    ConcurrentMap<Person.Gender, List<Person>> collected = persons.parallelStream().collect(
            Collectors.groupingByConcurrent(
                    // Die Klassifizierer-Funktion wird parametriesiert mit 
                    // <Element-Typ, Klassifikationsmerkmal-Typ>:
                    new Function<Person, Person.Gender>() {
              /**
               * Klassifizierer-Funktion: extrahiert aus den Datenelementen das
               * Gruppierungsmerkmal
               *
               * @param person Datenelement aus dem Stream
               * @return Gender-Wert als Klassifikation
               */
              @Override
              public Person.Gender apply(Person person) {
                return person.getGender();
              }
            }));

    // Kurzform mit Lambda
    collected = persons.parallelStream().collect(Collectors.groupingByConcurrent(person -> person.getGender()));

    // Kurzform mit Methodenreferenz
    collected = persons.parallelStream().collect(Collectors.groupingByConcurrent(Person::getGender));

    System.out.println("collected: ");
    System.out.println(collected);

  }
}
