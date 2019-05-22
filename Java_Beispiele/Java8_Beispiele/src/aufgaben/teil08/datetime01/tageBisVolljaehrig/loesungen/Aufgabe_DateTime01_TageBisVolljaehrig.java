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
package aufgaben.teil08.datetime01.tageBisVolljaehrig.loesungen;

import aufgaben.teil08.datetime01.tageBisVolljaehrig.Person;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Aufgabe_DateTime01_TageBisVolljaehrig {

  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
            new Person("Karl", "Käfer", LocalDate.of(2005, Month.DECEMBER, 24)),
            new Person("Max", "Mustermann", LocalDate.of(1980, Month.JANUARY, 21)),
            new Person("Anna", "Lyse", LocalDate.of(1999, Month.MARCH, 2))
    );
    
    
    final List<String> result = persons.stream()
            .peek(person -> {
              LocalDate plus18YDate = person.getBirthday().plus(18, ChronoUnit.YEARS);
              System.out.println("18 at " + plus18YDate);
            })
            .filter( person -> {
              return person.getBirthday().plus(18, ChronoUnit.YEARS).isAfter(LocalDate.now());
            })
            .map(person -> {
              LocalDate plus18YDate = person.getBirthday().plus(18, ChronoUnit.YEARS);
              int years = LocalDate.now().until(plus18YDate).getYears();
              int days = LocalDate.now().until(plus18YDate).getDays();
              int month = LocalDate.now().until(plus18YDate).getDays();
              
              System.out.println(person.toString() + String.format(
                      " wird volljährig in %s Tagen, %s Monaten und %s Jahren",
                      days, month, years));
              
              long until = LocalDate.now().until(plus18YDate, ChronoUnit.DAYS);
              
              return person.toString() + ", " + until;
            })
            .collect(Collectors.toList());
    
    System.out.println(result);
  }
}
