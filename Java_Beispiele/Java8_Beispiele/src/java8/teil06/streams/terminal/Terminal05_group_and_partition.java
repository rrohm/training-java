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
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal05_group_and_partition {

  public static void main(String[] args) {
    List<Person> persons = Person.createData();

    // Partitionierung, d.h. Aufteilung anhand eines Merkmals:
    Map<Boolean, List<Person>> partitionedByIsFemale = persons.stream()
            .collect(Collectors.partitioningBy(p -> p.getGender() == Person.Gender.FEMALE));

    System.out.println("partitionedByIsFemale: " + partitionedByIsFemale);

    // Partitionierung mit anschließender "Downstream"-Verarbeitung:
    // Zuerst partitionieren, dann Mapping auf Namen, dann Joining zu einem 
    // kommaseparierten String.
    Map<Boolean, String> namesPartitionedByIsFemale = persons.stream()
            .collect(Collectors.partitioningBy(
                    p -> p.getGender() == Person.Gender.FEMALE,
                    Collectors.mapping(Person::getName, Collectors.joining(", "))
            ));

    System.out.println("namesPartitionedByIsFemale: " + namesPartitionedByIsFemale);

    Map<Person.Gender, List<Person>> personsGroupedMyGender = persons.stream().collect(Collectors.groupingBy(
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
    
    System.out.println("personsGroupedMyGender: "+ personsGroupedMyGender);
  }
}
