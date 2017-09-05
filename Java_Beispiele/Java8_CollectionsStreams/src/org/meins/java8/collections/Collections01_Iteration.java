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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java8.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Dieses Beispiel illustriert die im JDK 8 verfügbaren Varianten der internen
 * und externen Iteration über Collections
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Collections01_Iteration {

  public static void main(String[] args) {

    final List<String> names = Arrays.asList("Anna Lyse", "Max Mustermann", "Lisa Lauter", "Karl Käfer");

    // A) Externe Iteration 
    
    // A.1) Klassisch, mit Iterator
    Iterator<String> iterator = names.iterator();
    while (iterator.hasNext()) {

      System.out.println(iterator.next());
    }
    
    // A.2) Mit indiziertem Zugriff: 
    for (int i = 0; i < names.size(); i++) {
      
      System.out.println(names.get(i));
    }
    
    
    // A.3) Ab JDK5: "for-each"-Semantik
    for (String name : names) {
      
      System.out.println(name);
    }
    
    
    // B) Interne Iteration mit Erweiterungen des JDK8: 
    
    // B.0) ... das Konzept dahinter: 
    names.forEach(new Consumer<String>() {
        /**
         * Das Interface Consumer schreibt nur eine Methode vor,
         * die Input (d.h.: jedes Element der Collection) entgegen 
         * nimmt und für jedes Element Verarbeitungslogik implementiert. 
         * @param name 
         */
        @Override
        public void accept(String name) {
            System.out.println(name);
        }
    });
    
    // B.1) Interne Iteration mit Lambda-Syntax
    names.forEach( (String name) -> {System.out.println(name); });
    
    // B.2) Interne Iteration mit Lambda-Syntax mit Typ-Inferenz
    names.forEach(  name -> System.out.println(name) );
    
    // B.3) Interne Iteration mit Methodenreferenz - ist dann möglich,
    //      wenn der Lambda-Asudruck *nur* eine Anweisung enthält, 
    //      die letztendlich die Abbildungslogik enthält. Diese Methode
    //      kann dann direkt referenziert werden.
    //
    //      Der Doppel-Doppelpunkt ist der neue Operator für die 
    //      Referenzierung der Methode.
    //      
    names.forEach( System.out::println);
  }
}
