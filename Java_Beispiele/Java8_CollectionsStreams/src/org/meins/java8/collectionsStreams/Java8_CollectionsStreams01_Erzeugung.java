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
package org.meins.java8.collectionsStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.meins.java8.collections.Person;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_CollectionsStreams01_Erzeugung {

  public static void main(String[] args) {
    
    // Rohdaten: 
    List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Karl Käfer", 48, Person.Gender.MALE),
            new Person("Max Mustermann", 17, Person.Gender.MALE),
            new Person("Anna Lyse", 33, Person.Gender.FEMALE),
            new Person("Lisa Lauter", 18, Person.Gender.FEMALE)
    ));
    
    // Stream-Erzeugung: mit z.B. Erweiterungen der Collections-API
    Stream<Person> stream = persons.stream();
    // ... oder: parallelen Stream mit Multithreaded-Verarbeitung hinter den Kulissen:
    // (vgl.: alte ForkJoinPool-API)
    Stream<Person> parallelStream = persons.parallelStream();

    // Auch möglich: im Nachhinein eine parallele Stream-Variante erzeugen lassen:
    Stream<Person> alsoParallelStream = persons.stream().parallel();
    
    
  }
}
