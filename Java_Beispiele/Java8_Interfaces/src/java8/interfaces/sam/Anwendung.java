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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package java8.interfaces.sam;

/**
 * Illustratives Beispiel zu den "Single Abstract Method"-Interfaces (SAM) und
 * ihrer Verwendung.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  public static void main(String[] args) {

    /**
     * Traditioneller Einsatz von (funktionalen) Interfaces.
     */
    MeinFunktionalesInterface iKlassisch = new MeinFunktionalesInterface() {
      @Override
      public String verarbeiteDaten(String input) {
        return input.toLowerCase();
      }
    };

    /**
     * Instanz eines Funktionalen Interfaces als Lambda-Ausdruck:
     */
    MeinFunktionalesInterface iLambda = (String input) -> {
      return input.toLowerCase();
    };

    // Kürzer - ohne Code-Block und return, geht bei nur einer Anweisung
    iLambda = (String input) -> input.toLowerCase();

    // Noch kürzer: mit "Target Typing" und Typ-Inferenz
    iLambda = input -> input.toLowerCase();

    String inputString = "ABCDE";
    String outputString = iLambda.verarbeiteDaten(inputString);

    System.out.println("outputString: " + outputString);

    
    // Anwendungsfall: Runnable
    new Thread(() -> {
      System.out.println("Nebenläufige Logik, kurz und knapp");
    }).start();
  }
}
