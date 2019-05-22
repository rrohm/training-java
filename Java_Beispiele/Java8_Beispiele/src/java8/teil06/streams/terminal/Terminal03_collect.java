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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Terminal03_collect {
 
  public static void main(String[] args) {
    List<Person> persons = Person.createData();
    
    // Collector: Durchschnitt aus Ints: 
    // Collectors.averagingInt() ist eine von mehreren "convenience methods",
    // die vorgefertigte Collektoren zurückgeben. 
    // Hier wird eine Mapper-Funktion mitgegeben, die jedes Element des Streams
    // auf einen int-Wert abbildet, zu denen der Mittelwert ermittlet werden muss.
    Double averageOfInts = persons.stream().collect(Collectors.averagingInt(new ToIntFunction<Person>() {
      @Override
      public int applyAsInt(Person person) {
        return person.getAge();
      }
    }));
    // Kürzer: Lambda: 
    averageOfInts = persons.stream().collect(Collectors.averagingInt((Person person) -> {return person.getAge();}));
    // Noch kürzer, mit Methodenreferenz
    averageOfInts = persons.stream().collect(Collectors.averagingInt(Person::getAge));
    
    System.out.printf("Durchschnittsalter: %f\n", averageOfInts);
    
    // Anzahl mit Collectors.counting(): 
    Long count = persons.stream().collect(Collectors.counting());
    System.out.printf("Anzahl: %d\n", count);
    
    // Minima und Maxima mit Collectors.minBy(comparator) etc.:
    Optional<Person> oldest = persons.stream().collect(Collectors.maxBy(Person::compareByAge));
    System.out.printf("Max. Alter: %s\n", oldest);
    
    // Aus einem Stream eine Liste von gemappten Werten ziehen:
    List<String> names = persons.stream().collect(Collectors.mapping(new Function<Person, String>() {
      @Override
      public String apply(Person p) {
        return p.getName();
      }
    }, Collectors.toList()));
    System.out.printf("Namen: %s\n", names);
    
    // "Nur" Liste aus Stream herausgeben:
    List<Person> listFromStream = persons.stream().collect(Collectors.toList());
    

    // Diskreter Collect-Vorgang: 
    // 1): "supply"- erstellt Ergebnis-Container, hier new ArrayList<>(): 
    List<Person> list = persons.stream().collect(new Supplier<List<Person>>() {
      @Override
      public List<Person> get() {
        return new ArrayList<>();
      }
    // 2): "accumulator" - Zu jedem element des Streams ein Teilergebnis in die
    //     Liste legen ...  
    }, new BiConsumer<List<Person>, Person>() {
      @Override
      public void accept(List<Person> resultPart, Person p) {
        resultPart.add(p);
      }
    // 3): "combiner" - Zusammenfassen der Teilergebnisse: 
    }, new BiConsumer<List<Person>, List<Person>>() {
      @Override
      public void accept(List<Person> resultAll, List<Person> resultPart) {
        resultAll.addAll(resultPart);
      }
    });
    
    System.out.printf("Persons: %s\n", list);
    
  }
}
