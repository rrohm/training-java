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
 *  2016 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java8.methodenreferenz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.meins.java8.lambdas.Person;

/**
 * Diese Beispiel illustriert weitere Einsatzmöglichkeiten von Lambdas und
 * Methodenreferenzen am Beispiel der Komparators.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_Methodenreferenz02 {

  public static void main(String[] args) {

    List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Karl Käfer", 48, Person.Gender.MALE),
            new Person("Max Mustermann", 17, Person.Gender.MALE),
            new Person("Anna Lyse", 33, Person.Gender.FEMALE),
            new Person("Lisa Lauter", 18, Person.Gender.FEMALE)
    ));

    // Sortierung mittels Komparator - old fashioned:
    Collections.sort(persons, new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
      }
    });

    // Komparator als Lambda: 
    Collections.sort(persons, (Person o1, Person o2) -> Integer.compare(o1.getAge(), o2.getAge()));

    // Methodenreferenz: 
    Collections.sort(persons, Java8_Methodenreferenz02::compareByAge);

    // Mal schauen ...
    for (Person person : persons) {
      System.out.println(person);
    }
  }

  private static int compareByAge(Person o1, Person o2) {
    return Integer.compare(o1.getAge(), o2.getAge());
  }
}
