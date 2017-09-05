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
package org.meins.java.refactoring.bedingungen;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class BedingungDurchPolymorphieErsetzen {

  public double berechneGehalt_vorher(Mitarbeiter mitarbeiter) {

    if (mitarbeiter instanceof Angestellter) {
      Angestellter angestellter = (Angestellter) mitarbeiter;
      return angestellter.getGehalt();

    } else if (mitarbeiter instanceof Freelancer) {
      Freelancer freelancer = (Freelancer) mitarbeiter;
      int stunden = 120; //
      return freelancer.getStundensatz() * stunden;

    } else {
      throw new RuntimeException("Fehler, unbekannter Mitarbeiter-Type");
    }
  }



  public double berechneGehalt(Freelancer freelancer) {
    int stunden = 120; //
    return freelancer.getStundensatz() * stunden;
  }


  public double berechneGehalt(Angestellter angestellter) {
    return angestellter.getGehalt();
  }




  public static void main(String[] args) {
    BedingungDurchPolymorphieErsetzen rechner = new BedingungDurchPolymorphieErsetzen();

    System.out.println("Vorher ...");
    System.out.println("Angestellter: " + rechner.berechneGehalt_vorher(new Angestellter(3500.0, 123, "Mustermann", "Max")));
    System.out.println("Freelancer: " + rechner.berechneGehalt_vorher(new Freelancer(60.0, 125, "Lyse", "Anna")));

    System.out.println("");
    System.out.println("Nachher ...");
    System.out.println("Angestellter: " + rechner.berechneGehalt(new Angestellter(3500.0, 123, "Mustermann", "Max")));
    System.out.println("Freelancer: " + rechner.berechneGehalt(new Freelancer(60.0, 125, "Lyse", "Anna")));
  }

}

class Mitarbeiter {

  private int nr;
  private String name;
  private String vorname;

  public Mitarbeiter(int nr, String name, String vorname) {
    this.nr = nr;
    this.name = name;
    this.vorname = vorname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public int getNr() {
    return nr;
  }

  public void setNr(int nr) {
    this.nr = nr;
  }
}

class Angestellter extends Mitarbeiter {

  private double gehalt;

  public Angestellter(int nr, String name, String vorname) {
    super(nr, name, vorname);
  }

  public Angestellter(double gehalt, int nr, String name, String vorname) {
    super(nr, name, vorname);
    this.gehalt = gehalt;
  }

  public double getGehalt() {
    return gehalt;
  }

  public void setGehalt(double gehalt) {
    this.gehalt = gehalt;
  }
}

class Freelancer extends Mitarbeiter {

  private double stundensatz;

  public Freelancer(int nr, String name, String vorname) {
    super(nr, name, vorname);
  }

  public Freelancer(double stundensatz, int nr, String name, String vorname) {
    super(nr, name, vorname);
    this.stundensatz = stundensatz;
  }

  public double getStundensatz() {
    return stundensatz;
  }

  public void setStundensatz(double stundensatz) {
    this.stundensatz = stundensatz;
  }
}
