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
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Beispiel "Reporting": Abbildung von Personen-Objekten in lesbare Form:
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Beispiel02_Personen_GroupByGender {

  public static void main(String[] args) {

    List<Person> persons = Arrays.asList(
            new Person("Anna", "Lyse", 24, Gender.FEMALE),
            new Person("Max", "Mustermann", 34, Gender.MALE),
            new Person("Klara", "Grube", 34, Gender.FEMALE)
    );

    persons.stream()
            .collect(Collectors.groupingBy(new Function<Person, Gender>() {
              @Override
              public Gender apply(Person t) {
                return t.getGender();
              }
            }));

    persons.stream()
            .collect(Collectors.groupingBy(person -> person.getGender()));

    // Gruppierung in einer Map: 
    Map<Gender, List<Person>> collectedMap = persons.stream()
            // im einfachsten Fall mit groupingBy()
            .collect(Collectors.groupingBy(Person::getGender));

    System.out.println("collectedMap" + collectedMap);

    // Gruppierung mit Aggregation der Werte pro Key: 
    // "Anzahl m/w" 
    System.out.println(persons
            .stream()
            .peek(person -> {
              // z.B. Protokollierung etc.
              System.out.println("Person: " + person.getLastname());
            })
            .collect(Collectors.groupingBy(
                    Person::getGender,
                    // "Downstream-Collector" für die Aggregation der Listen
                    // in der Map
                    Collectors.counting()
            )));

    // Gruppierung mit Aggregation der Werte pro Key
    // "Je Geschlecht: min/max/avg age"
    System.out.println("> Je Geschlecht: min/max/avg age");
    
    final Map<Gender, IntSummaryStatistics> statsData = persons
            .stream()
            .collect(Collectors.groupingBy(
                    Person::getGender,
                    // "Downstream-Collector summarizingInt()"
                    // vereint Standard-Analyse mit count/min/max/avg:
                    Collectors.summarizingInt(Person::getAge)
            ));

    System.out.println(statsData);
    
    // "Kommaseparierte Ausgabe aller Vorname, natürlich sortiert, unique?"
    // Tipps: 
    // - zuerst Vornamen als String-Stream extrahieren,
    // - dann sortieren und filtern
    // - für Unique-Filterung/Doubletten-Entfernung existiert eine Methode
    String lineWithNames = persons.stream()
            .map(Person::getFirstname)
            .distinct()
            .sorted()
            .collect(Collectors.joining(", "));
    
    System.out.println("lineWithNames: " + lineWithNames);
    
    // Optionals als Rückgabe-Typ: 
    // "Mindestalter der Personen?"
    System.out.println("> Mindestalter der Personen?");
    
    Optional<Person> minAge = persons.stream().
            collect(Collectors.minBy((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())));
    
    // Collectors.minBy gibt einen Optional-Container zurück:
    //System.out.println("minAge: " + minAge.get().getAge());
    // ACHTUNG: Es ist nicht gesagt, dass der Container etwas enthält!
    // Deshalb IMMER erst fragen - und dann zugreifen!!!
    if (minAge.isPresent()) {
      System.out.println("minAge: " + minAge.get().getAge());
    }
  }
}
