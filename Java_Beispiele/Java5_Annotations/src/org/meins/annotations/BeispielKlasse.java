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
package org.meins.annotations;

/**
 * Hier wird die Verwendung selbst deklarierter Annotationen gezeigt: in diesem
 * Beispeil sollen Annotationen verwendet werden, um *im Java-Sourcecode*
 * Hinweise auf "Request for Enhancement (RFE)"-Tickets zu hinterlegen, so dass
 * diese auch maschinell ausgewertet werden können.
 *
 * @author R. Rohm
 *
 */
public class BeispielKlasse {

  /**
   * Die eigene Annotation im Einsatz: mit default-Wert deklarierte Attribute
   * müssen nicht angegeben werden
   */
  @RFEAnnotation(
          id = 123456,
          synopsis = "Soll unter Verwendung von YYSD reimplementiert werden.")
  public void fuehreGeschaeftsfallAaus() {
  }

  /**
   * Vollständige Form:
   */
  @RFEAnnotation(
          id = 123457,
          synopsis = "Performt schlecht. Nochmal neu!",
          assignedTo = "M. Mustermann")
  public void fuehreGeschaeftsfallBaus() {
  }
}
