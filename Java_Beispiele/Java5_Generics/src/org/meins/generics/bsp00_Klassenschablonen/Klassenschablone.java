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
package org.meins.generics.bsp00_Klassenschablonen;

import java.awt.Point;
import java.util.Date;

/**
 * Beispiel: generische "Klassenschablonen", d.h. Klassen, die generisch
 * mit unterschiedlichen Typen arbeiten - und das jedoch Typ-sicher.
 *
 * @author R. Rohm
 */
public class Klassenschablone {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Box<String> stringBox = new Box<String>();
    Box<Integer> intBox = new Box<Integer>();
    Box<Point> pointBox = new Box<Point>();

    pointBox.setValue(new Point(1, 2));
    double x = pointBox.getValue().getX();

    // Typ-Auslöschung: Immer dieselbe Klasse!
    System.out.println("Klassen? ");
    System.out.println(stringBox.getClass());
    System.out.println(intBox.getClass());
    System.out.println(pointBox.getClass());

    Box rawBox = new Box();
    rawBox.setValue("irgend etwas ");

    rawBox = stringBox;
    rawBox.setValue(new Date());
  }
}
