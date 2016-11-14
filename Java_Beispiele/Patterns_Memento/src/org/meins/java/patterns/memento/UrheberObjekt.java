package org.meins.java.patterns.memento;

/**
 * Das "Urheber-Objekt" - in realen Anwendungen wäre das ein zustandsbehafteter
 * Controller oder auch ein eigenes Zustandsobjekt. Der "Zustand" ist hier nur
 * ein Beispiel für im Prinzip <strong>die Gesamtheit aller
 * Eigenschaften</strong>, deren Zustand gepeichert und wiederhergestellt werden
 * können.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class UrheberObjekt {

    private String zustand = "";

    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }

    public Memento erzeugeMemento() {
        return new Memento();
    }

    /**
     * Methode zum Wiederherstellen des Objekt-Zustandes auf den Stand eines
     * Mementos.
     *
     * @param m
     */
    public void setzeMemento(Memento m) {
        this.zustand = m.gespeicherterZustand;
    }

    /**
     * Memento als innere Klasse hat vollen Zugriff auf Urheber-Felder. 
     */
    public class Memento {

        private final String gespeicherterZustand;

        /**
         * Das Abbilden des Urheber-Zustands wird komplett hier im Konstruktor 
         * versteckt. 
         * Achtung! Bei komplexen Zuständen ist hier meist eine komplette 
         * tiefe Kopie erforderlich. 
         */
        private Memento() {
            this.gespeicherterZustand = zustand;
        }

        /**
         * Bei Gestaltung des Mementos als innere Klasse kann die Getter-Methode
         * entfallen.
         *
         * @return Der gespeicherte Zustand.
         */
        public String getGespeicherterZustand() {
            return gespeicherterZustand;
        }
    }

}
