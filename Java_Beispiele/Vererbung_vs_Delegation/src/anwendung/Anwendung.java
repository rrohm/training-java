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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package anwendung;

import helfer.FactoriesService;
import interfacedFactory.LinkFactory;

/**
 * In diesem Beispiel werden zum einen verschiedene Entwurfsmuster illustriert
 * (abstrakte Fabrik, Fabrik-Methode, Delegat), zum anderen wird hier der
 * Einsatz von Delegation und die Verwendung von Vererbung zum Zugriff auf
 * wieder zu verwendende Funktionalität gegenübergestellt.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  public static void main(String[] args) {
    // Arbeit mit einer Factory: Für den weiteren Verlauf der
    // Anwendung soll es nicht mehr relevant sein, wie es zu dem
    // konkreten Typen kommt.

    // Einfache Variante mit direkter Erzeugung
    //LinkFactory linkFactory = new AdvancedLinkFactory(new BaseLinkFactory());
    // "Noch mehr Abstraktion": Die Auswahl der Implementierung in einer
    // Farbikmethode
    LinkFactory linkFactory = FactoriesService.getDefaultFactory();

    // In der Anwendung wird weiterhin nur mit dem Interface-Typ gearbeitet.
    String createLink = linkFactory.createLink(123);

  }
}
