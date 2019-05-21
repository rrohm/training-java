package org.meins.java7.sprache;

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
/**
 * Methoden mit vararg-Parameter - im Prinzip bequemer Erstatz für
 * Array-Parameter. Sie erlauben den Aufruf mit beliebig langer Parameterliste.
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Bsp02_Vararg {

    /**
     * Methode übernimmt beliebig viele int-Werte. Intern wird der vararg-Typ
     * auf ein Array abgebildet.
     * 
     * <p>
     * <strong>Achtung!</strong> In jeder Methode kann es nur einen
     * vararg-Parameter geben, und dieser muss immer der letzte sein.</p>
     *
     * @param werte Wertereihe, aus der das Maximum ermittelt werden soll.
     * @return Maximum aus der übergebenen Wertereihe.
     * @throws IllegalArgumentException Wirft IllegalArgumentException, wenn
     *         null übergeben wird oder ein leeres Array.
     */
    public static int holeMax(int... werte) {

//      // geht nicht! "werte" ist ein int-Array!
//      if (werte == 5) {
//
//      }
        if (werte == null || werte.length == 0) {
            throw new IllegalArgumentException("Illegal array!");
        }
        int currentMax = Integer.MIN_VALUE;
        for (int e : werte) {
            if (e > currentMax) {
                currentMax = e;
            }
        }
        return currentMax;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Maximum ist: " + holeMax(0, 1, 23, 3, 54, 23));
        System.out.println("Maximum ist: " + holeMax(5));
    }
}
