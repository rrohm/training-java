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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_CollectionsStreams_Beispiele {

  public static void main(String[] args) {
    // Diese Anwendung skizziert die Verarbeitung von Collections mit der
    // Stream-API unter Java 8 an: 

    List<Kunde> kundenliste = new ArrayList<>();
    Collections.addAll(kundenliste,
            new Kunde("0100012", "ATU München"),
            new Kunde("0305362", "KFZ Pflaum"),
            new Kunde("0103016", "Euromaster"),
            new Kunde("0100013", "ATU Frankfurt/Main"),
            new Kunde("0100014", "ATU Frankfurt/Oder")
    );

    // Iterieren - mit der Stream API
    kundenliste.forEach(new Consumer<Kunde>() {

      @Override
      public void accept(Kunde kunde) {
        System.out.println("Verarbeitung von Kunde: " + kunde);
      }
    });
    // Alternative Codierung als Lambda-Ausdruck, bestehend: 
    // 1. Parameterliste
    // 2. "->" Pfeil-Operator (vgl. "Abbildung")
    // 3. Codeblock, der die Abbildungslogik definiert.
    kundenliste.forEach((Kunde kunde) -> {
      System.out.println("Verarbeitung von Kunde: " + kunde);
    });
    // ... überall verwendbar, wo Interfaces mit nur einer einzigen Methode
    // zu implementieren sind ("Funktionale Interfaces").
    // Verarbeitung der Collection als Stream: 
    // z.B. 1.) Filterung anhand eines Nummernkreises 010xxxx
    List<Kunde> ergebnisListe = kundenliste.stream().filter(new Predicate<Kunde>() {

      @Override
      public boolean test(Kunde kunde) {
        return kunde.getNr().startsWith("010");
      }
      // 2) Sortierung    
    }).sorted(new Comparator<Kunde>() {

      @Override
      public int compare(Kunde o1, Kunde o2) {
        if (o1.getNr().equals(o2.getNr())) {
          return 0;
        } else if (Integer.valueOf(o1.getNr()) < Integer.valueOf(o2.getNr())) {
          return -1;
        } else {
          return 1;
        }
      }
      // 3) Ergebnis-Ausgabe, z.B. mit einem Collector
    }).collect(Collectors.toList());

    ergebnisListe.forEach((Kunde kunde) -> {
      System.out.println("Ergebnis 1 - Kunde: " + kunde);
    });

    // Mit derselben API Collection parallel verarbeiten lassen: 
//        kundenliste.parallelStream()....
    // Auch in der parallelen Verarbeitung ist nur ein Stream-Objekt sichtbar,
    // die Parallelisierung geschieht vollständig transparent hinter den 
    // Kulissen.
  }
}
