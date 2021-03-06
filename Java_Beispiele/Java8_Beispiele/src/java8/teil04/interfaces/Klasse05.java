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
 * Diese Klasse03 hat versucht, zwei Interfaces mit identischen Default-Methoden
 * zu implementieren. Dies wird normalerweise vom Compiler mit einem Fehler
 * abgeblockt (" error: class Klasse03 inherits unrelated defaults for ...").
 * <p>
 * Eine Lösung ist, die kritische Methode hier selbst zu implementieren und die
 * strittigen defaults zu überschreiben.
 * <p>
 * Eine weitere Lösung könnte das gezielte Aufrufen einer der beiden defaults
 * sein.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Klasse05 implements Interface01, Interface02 {

  /**
   * Hier werden zwei(!) default-Methoden überschrieben. 
   */
  @Override
  public void defaultMethode01() {
    // Hier: gezieltes Aufrufen einer der beiden Default-Methoden.
    // Der Zugriff muss über "super" erfolgen, ansonsten wäre es 
    // der Aufruf einer statischen Methode des Interfaces.
    Interface01.super.defaultMethode01();
  }

  @Override
  public void methodeAusIntf01() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void methodeAusIntf02() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
