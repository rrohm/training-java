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
package org.meins.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Mit dem Predicate-Interface kann Prüflogik typsicher implementiert werden, 
 * um funktional angewendet zu werden. 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Collections02_Predicate {

  public static void main(String[] args) {
 
    // Beispiel-Daten
    // Achtung: Arrays.asList() liefert eine unvollständige AbstractList!
    List<String> names = new ArrayList<>(Arrays.asList("Anna Lyse", "", "Max Mustermann", "", "Lisa Lauter", "Karl Käfer"));

    // 1. Grundprinzip: Eine Collection-Methode erwartet ein Prädikat zur Prüfung 
    //    der Element und arbeitet nur auf Elementen, für die das Prädikat
    //    logisch wahr zurück liefert (hier z.B. Entfernen von Element aus der Collection)
    names.removeIf(new Predicate<String>() {
        /**
         * Exemplarische Prüfung auf Leerstring: 
         * @param input
         * @return Logisch wahr, wenn input den Prüfkriterien entspricht.
         */
      @Override
      public boolean test(String input) {
        return input.isEmpty();
      }
    });
    names.forEach(System.out::println);
    
    
    // 2. Als Lambda
    names = new ArrayList<>(Arrays.asList("Anna Lyse", "", "Max Mustermann", "", "Lisa Lauter", "Karl Käfer"));
    
    names.removeIf( t -> t.isEmpty());
    
    names.forEach(System.out::println);
    
    
    
    // 3. Als Methodenreferenz auf eine Instanz-Methode
    names = new ArrayList<>(Arrays.asList("Anna Lyse", "", "Max Mustermann", "", "Lisa Lauter", "Karl Käfer"));
    
    names.removeIf( String::isEmpty);
    
    names.forEach(System.out::println);
    
    
    // 4. Prädikate formulieren: 
    Predicate<String> isEmpty = String::isEmpty;
    Predicate<String> isNull = t -> t == null;
    Predicate<String> isTooLong = t -> t.length() > 20;
    
    names = new ArrayList<>(Arrays.asList(null, "Anna Lyse", "", "Max Mustermann", "", "Lisa Lauter", "Karl Käfer"));
    
    // Definition von komplexeren Prädikaten, z.B.:
    names.removeIf(isNull.or(isEmpty));
  }
  
}
