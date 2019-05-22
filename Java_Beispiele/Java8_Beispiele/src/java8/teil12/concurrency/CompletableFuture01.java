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
package java8.teil12.concurrency;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Completable Futures erlauben die schrittweise Definition und Ausführung von
 * Logik - wahlweise nebnläufig.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class CompletableFuture01 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    // Die Arbeit mit CompletableFutures erfolg immer in drei Schritten
    // 1. CompletableFuture erzeugen mit supplyAsync()
    // 2. Aktion mit thenApplyAsync()
    // 3. Abschluss mit thenAccept()
    CompletableFuture<List<Person>> step1 = CompletableFuture.supplyAsync(() -> {
      // Generierung der Ausgangsdaten
      return Arrays.asList(
              new Person("Karl", "Käfer", LocalDate.of(2005, Month.DECEMBER, 24)),
              new Person("Max", "Mustermann", LocalDate.of(1980, Month.JANUARY, 21)),
              new Person("Anna", "Lyse", LocalDate.of(1999, Month.MARCH, 2))
      );
    });

    // Definition der nächsten Verarbeitungsschritte - beliebig wiederholbar:
//    step1.thenApply(new Function<List<Person>, List<Integer>>() {
//      @Override
//      public List<Integer> apply(List<Person> t) {
//        return null;
//      }
//    });
    CompletableFuture<List<LocalDate>> step2 = step1.thenApply((List<Person> persons) -> {
      final List<LocalDate> result = persons.stream().map(Person::getBirthday).collect(Collectors.toList());

      if (result.isEmpty()) {
        // nicht sinnvoll möglich: 
//        throw new Exception("No result");
        // statt dessen: Delegation an einen zentralen ErrorHandler
//        ErrorHandlerService.handle(new Exception("No result"));
      }
//      throw new IllegalStateException("Testhalber ..."); // geht: 
//      throw new Exception("Testhalber ..."); // geht nicht
//      throw new ExecutionException("Testhalber ...", new Exception()); // geht nicht

      // Fazit: hier können nur RuntimeExceptions geworfen werden :-(
      return result;
    });

//    CompletableFuture<List<LocalDate>> step2 = step1.thenApply(new MyFuncInterface() {
//      @Override
//      public List<LocalDate> test(List<Person> persons) throws Exception {
//        throw new Exception("Test."); //To change body of generated methods, choose Tools | Templates.
//      }
//    });
    List<LocalDate> dates = step2.get();
    System.out.println(dates);

    // Optioner "terminaler" Schritt:
    CompletableFuture<Void> step3 = step2.thenAccept(new Consumer<List<LocalDate>>() {
      @Override
      public void accept(List<LocalDate> t) {
        //
      }
    });

    System.out.println(step3.get());
  }

  interface MyFuncInterface {

    public List<LocalDate> test(List<Person> persons) throws Exception;
  }
}
