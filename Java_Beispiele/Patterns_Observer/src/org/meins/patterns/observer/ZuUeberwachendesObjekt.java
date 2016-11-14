package org.meins.patterns.observer;

import java.util.Observable;

/**
 * Observable-Klasse, verwendet die JRE-Standardimplemtierung des
 * Observer-Patterns.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ZuUeberwachendesObjekt extends Observable {

    private String eigenschaft;

    public String getEigenschaft() {
        return eigenschaft;
    }

    /**
     * Wichtig: Bei Wertänderung muss das zu überwachende Objekt die
     * Benachrichtigung der Überwacher von sich aus anstoßen. 
     *
     * @param eigenschaft
     */
    public void setEigenschaft(String eigenschaft) {
        this.eigenschaft = eigenschaft;

        // ACHTUNG: das Observable muss explizit als "geändert" markiert werden!
        this.setChanged();

        // Benachrichtigung - mit Zurücksetzen des changed-Flags
        this.notifyObservers(this.eigenschaft);

// ist redundant -
//    this.clearChanged();
    }
}
