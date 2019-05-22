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
package java8.teil05.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * In diesem Beispiel sollen null-Werte vor der Filterung ersetzt werden, 
 * mittels List.replaceAll() und UnaryOperator.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Beispiel02_PredicatesUndUnaryOperator {

  public static void main(String[] args) {
    List<String> names = new ArrayList<>(Arrays.asList(
            "Anna Lyse",
            "",
            "Max Mustermann",
            "",
            null,
            "Lisa Lauter",
            "Karl Käfer"));
    
    
    UnaryOperator<String> replaceNullsOperator = name -> {
      if (name == null) {
        return "John Doe (has been null!)";
      } else {
        return name;
      }
    };
    // Noch kompakter: 
    replaceNullsOperator = name -> (name == null) ? "John Doe (has been null!)" : name;
    
    // Anwendung in replaceAll()
    names.replaceAll(replaceNullsOperator);
    
    // Filtern mittels Prädikaten und removeIf(): 
    // a) Nur Namen ohne Y, aber als Methodenreferenz
    Predicate<String> containsY = Beispiel02_PredicatesUndUnaryOperator::testContainsY;
    // b) Leerstring?
    Predicate<String> isEmpty = (name) -> name.isEmpty();
    
    // Entfernen: Leere und mit Y
    names.removeIf(containsY.or(isEmpty)); // OK
    
    // Ausgabe:
    names.forEach(System.out::println);
  }
  
  /**
   * Methode für Methodenreferenz als Prädikat, 
   * benötigt dieselbe Signatur wie die Predicate-Methode:
   */
  public static boolean testContainsY(String name){
    return name.toLowerCase().contains("y");
  }
}
