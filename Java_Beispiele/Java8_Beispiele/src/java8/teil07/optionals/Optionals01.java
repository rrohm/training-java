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
package java8.teil07.optionals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Beispiel zu weiteren Features der Optional-Klasse.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Optionals01 {

  public static void main(String[] args) throws MeinProblemException {
    
    // Keine Ausgangsdaten vorhanden ...
    final Integer[] emptyArray = {};
    
    // Achtung: Komparator muss ggf. nullsafe sein!
    Optional<Integer> min = Arrays.stream(emptyArray).min(Comparator.naturalOrder());
    
    // Test: Ergibt Optional.empty
    System.out.println("min: " + min);
    
    // Anwendungsfall 1: Diskreter Ersatzwert
    System.out.println("min: " + min.orElse(-1));
    
    // Anwendungsfall 2: Ersatzwert mit Supplier-Funktion generieren
    System.out.println("min: " + min.orElseGet(new Supplier<Integer>() {
      @Override
      public Integer get() {
        // TODO Logik für Ersatzwert
         return 123; // illustrativ
      }
    }));
    
    // Anwendungsfall 3: Explizit definierte Exeption auslösen
    System.out.println("min: " + min.orElseThrow(new Supplier<MeinProblemException>() {
      @Override
      public MeinProblemException get() {
        return  new MeinProblemException(); 
      }
    }));
  }
}
