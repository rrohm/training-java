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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java6.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * Diese Klasse zeigt den Einsatz von Collections.asLifoQueue(). Diese erzeugt
 * so etwas wie einen Stack - u.a., weil der Stack&lt;E&gt; suboptimal
 * implementiert ist.
 *
 * Vorteile:
 * <ul>
 *   <li>Vermeidet unsauberes Design und Fehlermöglichkeiten von Stack&lt;E&gt;></li>
 *   <li>ist performanter</li>
 * </ul>
 *
 * Merkmale:
 * <ul>
 *   <li>add() entspricht logisch push()</li>
 *   <li>remove entspricht logisch pop()</li>
 * </ul>
 *
 * @author R. Rohm
 */
public class CollectionsAsLifoQeue {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Queue<String>  stack = Collections.asLifoQueue(new ArrayDeque<String>());
    List<String> l = new ArrayList<>();

    stack.add("A");
    stack.add("B");
    stack.addAll(Arrays.asList("C", "D", "E"));

    // Verhalten des Stacks ein foreach:
    for (String string : stack) {
      System.out.println(string);
    }

    // stack.remove
    for (; !stack.isEmpty(); ) {
      System.out.println(stack.remove());
    }
  }
}


/*
 * Quelle:
 * http://www.amazon.de/Java-Core-Techniken-Essentielle-Java-Apps/dp/3486584111/ref=sr_1_15?ie=UTF8&qid=1330866789&sr=8-15#reader_3486584111
 */