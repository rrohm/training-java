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
package aufgaben.teil08.datetime01.tageBisVolljaehrig;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Aufgabe_DateTime01 {

  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
            new Person("Svante", "Kumlien", LocalDate.of(1972, Month.NOVEMBER, 18)),
            new Person("Karl", "Käfer", LocalDate.of(1999, Month.MARCH, 28)),
            new Person("Klara", "Grube", LocalDate.of(2001, Month.JANUARY, 28)),
            new Person("Max", "Mustermann", LocalDate.of(2003, Month.DECEMBER, 2)),
            new Person("Robert", "Rohm", LocalDate.of(1971, Month.JULY, 8))
    );

    persons.stream()
            .filter(person -> {
              return getBirthday18th(person).isAfter(LocalDate.now());
            })
            .peek(System.out::println) // String-Repräsentation prüfen: 
            .map(person -> {
              StringBuilder sb = new StringBuilder();
              sb.append(person.toString());
              sb.append(" (18. Geburtstag in ");
              
              // Wieviel Tage von now() bis 18. Geburtstag
              LocalDate birthday18 = getBirthday18th(person);
              long days = LocalDate.now().until(birthday18, ChronoUnit.DAYS);
              
              sb.append(days);
              sb.append(" Tagen)");
              return sb.toString();
            })
            .peek(System.out::println) // String-Repräsentation prüfen: 
            .collect(Collectors.toList())
            ;

  }

  private static LocalDate getBirthday18th(Person person) {
    return person.getBirthday().plus(18, ChronoUnit.YEARS);
  }
}
