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
package helfer;

import interfacedFactory.AdvancedLinkFactory;
import interfacedFactory.BaseLinkFactory;
import interfacedFactory.LinkFactory;

/**
 * Diese Helfer-Klasse wird verwendet, um die Factory-Erzeugung zu verbergen
 * und einfache, bequeme Methoden hierfür bereitzustellen.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class FactoriesService {

  private static LinkFactory defaultFactory = null;
  /**
   * Hier wird Erstellung der konkreten Factory verborgen.
   * Die Auswahl des konkreten Typs könnte z.B. per Konfiguraitonsdatei,
   * kommandozeilenparameter etc. gesteuert werde.
   *
   * Diese Beispiel gibtein "Quasi-Singleton" zurück, dies macht Sinnn, *wenn*
   * Lazy Instantiation von Vorteil ist.
   *
   * @return Link-Factory, nur bekannt als Interface.
   */
  public static LinkFactory getDefaultFactory(){
    if (defaultFactory == null) {
      defaultFactory = new AdvancedLinkFactory(new BaseLinkFactory());
    }
    return defaultFactory;
  }
}
