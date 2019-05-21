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
package org.meins.java8.collections;

import org.meins.java8.collectionsStreams.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.meins.java8.collections.Person;

/**
 * Komparatoren als Lambda-Ausdrücke, z.B. für die prägnantere Sortierung von 
 * Collections. 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Collections04_Comparator {

  public static void main(String[] args) {
    
    // Rohdaten: 
    List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Karl Käfer", 48, Person.Gender.MALE),
            new Person("Max Mustermann", 17, Person.Gender.MALE),
            new Person("Anna Lyse", 33, Person.Gender.FEMALE),
            new Person("Lisa Lauter", 18, Person.Gender.FEMALE)
    ));
    
    // Anwendungsfall: Person-Collection soll aufsteigend nach Alter sortiert werden.
    persons.sort(new Comparator<Person>() {
        /**
         * compare() soll qua Konvention nur 3 Werte liefern: 
         * -1 für "kleiner", 0 für "gleich, im Sinne von equals()", 1 für "größer".
         * 
         * @param person1
         * @param person2
         * @return -1/0/1 für "kleiner"/"gleich"/"größer"
         */
        @Override
        public int compare(Person person1, Person person2) {
            // für Primitive Typen: siehe Wrapper-Klasse
            return Integer.compare(person1.getAge(), person2.getAge());
        }
    });
    // Als Lambda? Lesbarkeit ...? Wiederverwertbarkeit ...?
    persons.sort((Person person1, Person person2) -> Integer.compare(person1.getAge(), person2.getAge()));
    
    // Als Methodenreferenz: Nötig ist eine Methode mit derselben Signatur.
    // Im allgemeinen ist hier nur eine statische Methode nötig. 
    persons.sort(Collections04_Comparator::compareByAge);
    
    
    persons.forEach(System.out::println);
  }
  
  /**
   * Hier genügt eine statische Methode, die per Methodenreferenz statt eines 
   * Lambda-Ausdrucks eingesetz werden soll. 
   * Nebenbei: Der Methodennamen aus dem Comparator-Interface muss hier 
   * nicht mehr beibehalten werden (s. Typ-Inferenz und Target-Typing).
   * 
   * @param person1
   * @param person2
   * @return 
   */
  public static int compareByAge(Person person1, Person person2){
      return Integer.compare(person1.getAge(), person2.getAge());
  }
}
