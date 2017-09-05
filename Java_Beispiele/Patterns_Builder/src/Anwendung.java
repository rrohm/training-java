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

import java.awt.Color;

import javax.swing.JButton;

/**
 * Hier wird der Einsatz eines Builders kurz illustriert: Das Builder-Pattern
 * bietet drei Vorteile:
 * <br>
 * 1. Die Objekt-Erzeugung wird en eine Builder-Klasse eingekapselt. Vor allem,
 *    wenn bei der Initialisierung etwas mehr zu erledigen ist, kann dies gut
 *    in den Builder ausgelagert werden.
 * <br>
 * 2. Auch die Definition von Standard-Merkmalen oder Grundeinstellungen für
 *    den zu instanierenden Typ kann in den Builder ausgelagert werden.
 * <br>
 * 3. Durch die "Fluent API" können lange Serien von Setter-Aufrufen vermieden
 *    werden.
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  /**
   * @param args
   */
  public static void main(String[] args) {


    JButton meinButton = ButtonBuilder.create()
            .text("Hier klicken")
            .backgroundColor(Color.BLUE)
            .foregroundColor(Color.BLACK)
            .build();

    // Danach würde der Button in der GUI platziert werden etc.
  }

}
