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
import java.util.Optional;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal02_statistics {
  public static void main(String[] args) {
    List<Person> persons = Person.createData();
    
    long count = persons.stream().count();
    System.out.printf("Anzahl: %d\n", count);
    
    Optional<Person> oldest = persons.stream().max(Person::compareByAge);
    System.out.printf("Max. Alter: %s\n", oldest);
    
    Optional<Person> youngest = persons.stream().min(Person::compareByAge);
    System.out.printf("Min. Alter: %s\n", youngest);
    
  }
  
}
