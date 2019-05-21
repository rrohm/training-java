/*
 * This code is released under Creative Commons Attribution 4.0 International
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means:
 *
 * You are free to:
 *
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 *
 *     The licensor cannot revoke these freedoms as long as you follow the
 *     license terms.
 *
 * Under the following terms:
 *
 *     Attribution — You must give appropriate credit, provide a link to the
 *     license, and indicate if changes were made. You may do so in any
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license
 * permits.
 */
package org.meins.threads.basics00_ungebremst;

/**
 * Beispiel: Zwei ungebremste Threads laufen parallel. Man beachte die
 * Reihenfolge der Ausgabe: Die Ausführungszeit wird auf die Threads
 * unregelmäßig verteilt.
 *
 * @author robert rohm
 */
public class Basics00_2Threads_ungebremst {

  // Innere Klasse ist hier static, weil sie aus statischem Kontext heraus aufgerufen wird.
  static class MeinRunnable implements Runnable {

    private int counter = 0;

    /**
     * Nebenläufig auszuführender Code wird in der run()-Methode implementiert.
     */
    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println(Thread.currentThread().getName() + " counter: " + counter++);
      }
      // Hier folgt z.B. Aufräum-Arbeit vor Verlassen des Runnables.
      // Bei Verlassen der run()-Methode terminiert der Thread.
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // Das Java-Thread-Objekt repräsentiert einen System-Thread.
    // Dem Thread wird das Runnable zur nebenläufigen Ausführung übergeben,
    // danach wird der Thread gestartet.
    Thread t1 = new Thread(new MeinRunnable());
    t1.start();
    Thread t2 = new Thread(new MeinRunnable());
    t2.start();

    // Ebenso möglich: Code in einem anonymen Runnable übergeben:
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        System.out.println("Schwerarbeit leisten ...");
      }
    });
    thread.start();

    // Evtl noch besser: Code in Lambda-Ausdruck übergeben:
    Thread lambdaThread = new Thread(() -> {
      System.out.println("Schwerarbeit leisten ...");
    });

    // Ein "Hintergrund-Thread", wird von der JVM automatisch beendet, wenn 
    // der Haupt-Thread beendet wird. Ansonsten versucht jeder Thread, 
    // auch bei Beendigung der Anwendung erst einmal zum Ende 
    // durchzulaufen(!).
    lambdaThread.setDaemon(true);
    lambdaThread.start();

    //Thread.sleep(3000);
    Thread.currentThread().sleep(100);
    t1.interrupt();
    t2.interrupt();
  }
}
