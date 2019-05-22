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
 * Beispiel zur Gruppierung nach einem Merkmal:
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal06_Grouping {

  public static void main(String[] args) {
    List<Person> persons = Person.createData();

    persons.stream().collect(
            // Die Classifer-Fuunction wird parametrisiert mit 
            // <ELEMENT-TYPE, KLASSIFIZIERER-TYP>
            Collectors.groupingBy(new Function<Person, Person.Gender>() {
              @Override
              public Person.Gender apply(Person person) {
                // Dies ist die Logik für den Lambda-Block:
                // nur ein Methodenaufruf, kann auch durch Referen
                // ersetzt werden!
                return person.getGender();
              }
            }));
    
    // Gruppierung nach Gender: 
    Map<Person.Gender, List<Person>> collected = persons.stream().collect(Collectors.groupingBy(Person::getGender));
    
    System.out.println("collected: " + collected);
    
    
    // Gruppierung nach Gender, mit "Downstream"-Collector für anschließende
    // weiter Auswertung, hier Zählung der Element pro Gruppe:
    Map<Person.Gender, Long> genderCounted = persons.stream().collect(Collectors.groupingBy(
            Person::getGender,
            // Downstream-Collector: 
            Collectors.counting()
    ));
    
    System.out.println("genderCounted: " + genderCounted);
    
    // Parallelisierte Variante, erzeugt einen parallelen Stream und (WICHTIG)
    // fürht die Gruppierung mit groupingByConcurrent() aus:
    Map<Person.Gender, Long> genderCountedParallel = persons.stream().parallel().collect(Collectors.groupingByConcurrent(
            Person::getGender,
            // Downstream-Collector: 
            Collectors.counting()
    ));
  }
}
