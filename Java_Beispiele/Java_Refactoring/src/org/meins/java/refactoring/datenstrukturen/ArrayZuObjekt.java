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
package org.meins.java.refactoring.datenstrukturen;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ArrayZuObjekt {


  public static void main(String[] args) {
    // ungünstig
    double[] kennwerte = new double[3];
    kennwerte[0] = 10.0;
    kennwerte[1] = 3.33;

    // Besser
    StatistikKennwerte kennwerte1 = new StatistikKennwerte(10.0, 3.33);

  }


  static class StatistikKennwerte {

    public StatistikKennwerte(double summe, double mittelwert) {
      this.summe = summe;
      this.mittelwert = mittelwert;
    }

    private double summe;
    private double mittelwert;

    public double getSumme() {
      return summe;
    }

    public void setSumme(double summe) {
      this.summe = summe;
    }

    public double getMittelwert() {
      return mittelwert;
    }

    public void setMittelwert(double mittelwert) {
      this.mittelwert = mittelwert;
    }
  }
}
