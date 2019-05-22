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
package aufgaben.teil05.collections01;

import java.util.Arrays;
import java.util.List;

/**
 * <h3>Aufgabe: "Filterung"</h3>
 * <p>
 * Eine gegebene Personenliste soll gefiltert werden, so dass nur volljährige
 * Personen übrig bleiben. Alle anderen sollen aus der Liste entfernt werden.
 * <p>
 * Hinweise: 
 * <ul>
 *   <li>Die Filterung kann mit Lamda oder Methodenreferenz erfolgen.</li>
 *   <li>Welche Vorteile bzw. Nachteile haben beide Varianten?</li>
 * </ul>
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Aufgabe_Collections01 {

  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(
            new Person("Anna", "Lyse", 24, Gender.FEMALE),
            new Person("Karl", "Läfer", 14, Gender.MALE),
            new Person("Max", "Mustermann", 34, Gender.MALE),
            new Person("Klara", "Grube", 34, Gender.FEMALE)
    );
  }
}
