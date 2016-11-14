package org.meins.patterns.observer;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        ZuUeberwachendesObjekt objekt = new ZuUeberwachendesObjekt();

        Ueberwacher ueberwacher = new Ueberwacher();

        objekt.addObserver(ueberwacher);

        objekt.setEigenschaft("Neue Daten!");
    }

}
