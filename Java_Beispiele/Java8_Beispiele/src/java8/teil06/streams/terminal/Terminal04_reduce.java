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
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/**
 * Beispiel zu Reduce-Operationen: Endergebnis des reduce-Vorgangs ist immer ein
 * Optional, parametrisiert mit dem Ergebnistyp. Die Reduzierung erfolgt immer
 * mit einem BinaryOperator
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal04_reduce {

  public static void main(String[] args) {

    IntStream intStream = IntStream.of(1, 6, 4, 56, 68, 95, 266, 757, 668, 8865, 5);

    OptionalInt intMax = intStream.reduce(new IntBinaryOperator() {
      /**
       * Reduzierung zum Maximum:
       *
       * @param left Erster bzw. vorheriger Wert,
       * @param right nächster Wert
       * @return Maximum der beiden Werte
       */
      @Override
      public int applyAsInt(int left, int right) {
        return Math.max(left, right);
      }
    });
    System.out.println("intMax: " + intMax.getAsInt());

    
    // Reduce mit komplexen Datenobjekten
    List<Person> personen = Person.createData();

    Optional<Person> reduced = personen.stream().reduce(new BinaryOperator<Person>() {
      /**
       *
       * @param t Erstes Element - oder Return-Wert des vorherigen Durchlaufs
       * @param u Nächstes Element
       * @return Zwischenergebnis
       */
      @Override
      public Person apply(Person t, Person u) {
        System.out.println("t: " + t);
        System.out.println("u: " + u);
        System.out.println("------------------");
        return t;
      }
    });

    System.out.println("result: " + reduced.get());
  }
}
