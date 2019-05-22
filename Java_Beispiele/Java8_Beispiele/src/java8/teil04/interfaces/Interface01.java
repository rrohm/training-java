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
package java8.teil04.interfaces;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public interface Interface01 {
  
    /**
     * Statische Methoden in Interfaces - haben die gleiche Funktion wie 
     * statische Methoden einer Klasse. 
     * <p>
     * Achtung! Wenn hier nicht-triviale Logik implementiert werden soll, 
     * entstehen schnell Abhängigkeiten -&gt; schlechte Architektur!
     */
    public static void statischerHelfer(){
      System.out.println("macht auch etwas ...");
      
    }

    public void methodeAusIntf01();

    /**
     * default-Methode - liefert die "Default"-Implementierung gleich mit, muss
     * daher bei implementierenden Klassen nicht nochmal implementiert werden
     * (was in der Praxis die Einführung von Mehrfachvererbung in Java
     * bedeutet!!!).
     */
    default void defaultMethode01() {
        System.out.println("Hallo, ich komme aus Interface01");
    }
}
