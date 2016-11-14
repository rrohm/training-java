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
package org.meins.java5.enumeration;

/**
 * In einem erweiterten Enum-Typ stellt jeder Wert des Enums keinen primitiven
 * Typ, sondern einen komplexen Typen dar. Die Felder werden wie in einer
 * Klassendefinition im Enum-Typ deklariert. Der Enum-Typ kann ebenso über
 * Getter und Setter sowie über Konstruktoren verfügen.
 *
 * <p>
 * Vorteile: Mit dem erweiterten Enum kann auch für komplexe Typen
 * sichergestellt werden, dass zu Laufzeit nur eine bestimmte Anzahl von
 * Instanze existiert. Der erweiterte Enum wird daher z.B. auch für Singletons 
 * verwendet(!).
 * </p>
 *
 * @author R. Rohm
 */
public enum Enum03_ErweiterteEnum {

    // Achtung! Ohne eine deklarierte Instanz werden Fehler angezeigt!
    ICH("Rohm", "R.", 43),
    M_MUSTERMANN("Mustermann", "Max", 45),
    L_MUELLER("Müller", "Lisa", 41);

    private int Alter;
    private String Name;
    private String Vorname;

    /**
     * Konstruktor von Enumerationen nicht public definieren - es sollen zur
     * Laufzeit keine neuen Instanzen gebildet werden können! (Hierfür sollte
     * besser eine reguläre Klasse verwendet werden).
     *
     * @param name
     * @param vorname
     * @param alter
     */
    private Enum03_ErweiterteEnum(String name, String vorname, int alter) {
        this.Alter = alter;
        this.Name = name;
        this.Vorname = vorname;
    }

    /**
     * @return the Alter
     */
    public int getAlter() {
        return Alter;
    }

    /**
     * @param Alter the Alter to set
     */
    public void setAlter(int Alter) {
        this.Alter = Alter;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Vorname
     */
    public String getVorname() {
        return Vorname;
    }

    /**
     * @param Vorname the Vorname to set
     */
    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }
}

/*
 * Quellen:
 * http://www.java-blog-buch.de/0605-enumerations/
 */
