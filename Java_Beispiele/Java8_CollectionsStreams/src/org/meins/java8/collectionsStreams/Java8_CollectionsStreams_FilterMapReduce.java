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
package org.meins.java8.collectionsStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.meins.java8.collections.Person;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_CollectionsStreams_FilterMapReduce {

  public static void main(String[] args) {

    // Rohdaten: 
    List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Karl Käfer", 48, Person.Gender.MALE),
            new Person("Max Mustermann", 17, Person.Gender.MALE),
            new Person("Anna Lyse", 33, Person.Gender.FEMALE),
            new Person("Lisa Lauter", 18, Person.Gender.FEMALE)
    ));

    // Stream-Erzeugung:
    String names = persons.stream().filter(new Predicate<Person>() {
      @Override
      public boolean test(Person person) {
        return person.getAge() >= 18;
      }
    }).map(new Function<Person, String>() {
      @Override
      public String apply(Person t) {
        return t.getName().substring(t.getName().indexOf(" ") +1);
      }
    }).collect(Collectors.joining(", "));
    
    
    names = persons.stream()
            .filter((Person person) -> person.getAge() >= 18)
            .map((Person t) -> t.getName().substring(t.getName().indexOf(" ") +1))
            .collect(Collectors.joining(", "));
    
    
    System.out.println("Namen: " + names);
    
    
    
  }
}
