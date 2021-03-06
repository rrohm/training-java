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
package interfacedFactory;

/**
 * Dieses Interface definiert Verhalten, das von allen Link factories
 * unterstützt werden soll.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public interface LinkFactory {

  /**
   * Erste Methode, erstellt Links abhängig von einer long-ID.
   * @param id
   * @return
   */
  String createLink(long id);

  String createLink(int id);

}
