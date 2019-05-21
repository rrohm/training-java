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
package prinzip_01_klassisch;

/**
 * Weitere Optimierung: Da Synchronisierung vergleichsweise teuer ist, wird
 * zunächst geprüft ob dies auch tatsächlich notwendig ist - und dann versucht,
 * den Codeblock mittels Synchronisierung für den aktuellen Thread zu sperren
 * ("double checked locking")
 *
 */
public class SynchronizedSingletonDoubleChecked {

  /**
   * Durch Verwendung von volatile wird hier sichergestellt, dass bei
   * nebenläufigem Zugriff alle Threads denselben aktuellen Wert sehen, und
   * nicht etwa einen Wert im threadeigenen Cache. Zudem wird seit Java 5
   * daduch eine "Happens-Before"-Beziehung zwischen konkurrierenden Zugriffen
   * hergestellt - ähnlich wie bei einem Mutex.
   */
  private static volatile SynchronizedSingletonDoubleChecked instance;

  /**
   * Einzige Methode zur Instanz-Erzeugung, mit "double checked locking".
   * Wichtig ist hier die lokale Variable, da durch sie der Zugriff auf das
   * volatile-Feld erfolgt.
   *
   * @return
   */
  public static SynchronizedSingletonDoubleChecked getInstance() {
    SynchronizedSingletonDoubleChecked i = instance;
    if (i == null) {
      synchronized(SynchronizedSingletonDoubleChecked.class){
        i = instance;
        if (i == null) {
          instance = i = new SynchronizedSingletonDoubleChecked();
        }
      }
    }
    return i;
  }

  /**
   * Konstruktor private!
   */
  private SynchronizedSingletonDoubleChecked() {

  }
}
