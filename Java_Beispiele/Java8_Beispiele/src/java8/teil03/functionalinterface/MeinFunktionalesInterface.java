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
package java8.teil03.functionalinterface;

/**
 * Beispiel eines Funktionalen Interfaces, d.h., eines interface-Typs, der für
 * Lambda-Ausdrücke verwendet werden kann. Funktionale Interfaces dürfen nur
 * eine einzige abstrakte Methode <i>einführen</i>. Default-Methoden sind nicht
 * abstrakt, d.h., sie zählen nicht dazu. Auch Methoden aus
 * {@link java.lang.Object} zählen nicht dazu.
 * <p>
 * Die Markierung mit @FunctionalInterface ist optional. Allerdings wird durch
 * diese Annotation der Compiler aufgefordert, das Interface zu prüfen und ggf.
 * mit einem entsprechenden Fehler abzubrechen.
 * </p>
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@FunctionalInterface
public interface MeinFunktionalesInterface {

  /**
   * Methoden in Interfaces sind qua Spezifikation <code>public</code> und
   * <code>abstract</code>, müssen also nicht explizit so deklariert weren.
   *
   * @param t Exemplarisch für beliebige Parameter ...
   * @return Rückgabetyp kann auch void sein.
   */
  String verarbeiteDaten(String t);
  
  /**
   * Auch Default-Methoden sind zulässig in Functional Interfaces.
   * @param t
   * @return 
   */
  default String doSomethingElse(String t) {
    return t.toUpperCase();
  }

  /**
   * ACHTUNG - das ist erlaubt! Alle Methoden aus java.lang.Object dürfen in
   * funktionalen Interfaces (re-)deklariert werden.
   *
   * @return Siehe {@link java.lang.Object#toString() }
   */
  @Override
  String toString();
  
  
}
