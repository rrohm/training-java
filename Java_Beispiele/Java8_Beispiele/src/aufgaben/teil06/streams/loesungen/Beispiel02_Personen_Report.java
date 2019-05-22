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
package aufgaben.teil06.streams.loesungen;

import aufgaben.teil06.streams.Gender;
import aufgaben.teil06.streams.Person;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Beispiel "Reporting": Abbildung von Personen-Objekten in lesbare Form:
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Beispiel02_Personen_Report {

  public static void main(String[] args) {

    List<Person> persons = Arrays.asList(
            new Person("Anna", "Lyse", 24, Gender.FEMALE),
            new Person("Max", "Mustermann", 34, Gender.MALE),
            new Person("Klara", "Grube", 34, Gender.MALE)
    );
    
    // Direkte Ausgabe: 
    persons.stream().map(person -> {
      return String.format("%s %s., %s Jahre",
              person.getLastname(), 
              person.getFirstname().charAt(0), 
              person.getAge());
    }).forEach(System.out::println);
    
    // Ausgabe der Stringliste
    List<String> resultList = persons.stream().map(person -> {
      return String.format("%s %s., %s Jahre",
              person.getLastname(),
              person.getFirstname().charAt(0), 
              person.getAge());
    }).collect(Collectors.toList());
    
    resultList.forEach(System.out::println);
    
    // Reporting mit Sortierung
    System.out.println("Reporting mit Sortierung: ");
    resultList = persons.stream()
            .sorted((p1, p2) -> p1.getLastname().compareToIgnoreCase(p2.getLastname()))
            .map(person -> {
      return String.format("%s %s., %s Jahre",
              person.getLastname(),
              person.getFirstname().charAt(0), 
              person.getAge());
    }).collect(Collectors.toList());
    
    resultList.forEach(System.out::println);
  }
}
