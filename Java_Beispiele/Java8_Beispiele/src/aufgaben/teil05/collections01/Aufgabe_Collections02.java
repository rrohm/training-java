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
package aufgaben.teil05.collections01;

import java.util.Arrays;
import java.util.List;

/**
 * <h3>Aufgabe: "Elemente ersetzen"</h3>
 * <p>
 * Eine Stringliste von Namen enthält null-Elemente. Diese sollen gegen den
 * Hinweis "(kein Name)" ersetzt werden.
 * <p>
 *
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Aufgabe_Collections02 {

  public static void main(String[] args) {
    List<String> persons = Arrays.asList(
            "M. Mustermann", null, "L. Müller", null, null, "K. Käfer");
  }
}
