package org.meins.java.patterns.memento;

/**
 * "Memento-Pattern"
 * <p>
 * Zweck:</p>
 * <ul>
 * <li>Speichern und Wiederherstellen des Zustands eines Objekts </li>
 * <li>Keine direkte Schnittstelle zum Zustand bieten</li>
 * <li></li>
 * </ul>
 * <p>
 * Lösung:</p>
 * <ul>
 * <li>Nur das Urheber-Objekt kann seinen Zustand als „Momentaufnahme“ in einem
 * Memento-Objekt speichern</li>
 * <li>… und daraus wiederherstellen </li>
 * <li>Das Memento-Objekt kapselt den Zustand gegen Manipulation</li>
 * <li>Memento-Objekte werden separat verwaltet</li>
 * </ul>
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MementoAufbewahrer aufbewahrer = new MementoAufbewahrer();

        UrheberObjekt objekt = new UrheberObjekt();

        objekt.setZustand("Zustand 1");
        aufbewahrer.speichereMemento(objekt.erzeugeMemento());
        System.out.println(objekt.getZustand());

        objekt.setZustand("Zustand 2");
        aufbewahrer.speichereMemento(objekt.erzeugeMemento());
        System.out.println(objekt.getZustand());

        objekt.setZustand("Zustand 3");
        aufbewahrer.speichereMemento(objekt.erzeugeMemento());
        System.out.println(objekt.getZustand());

        objekt.setzeMemento(aufbewahrer.holeLetztesMemento());
        System.out.println(objekt.getZustand());

        objekt.setzeMemento(aufbewahrer.holeLetztesMemento());
        System.out.println(objekt.getZustand());

        objekt.setzeMemento(aufbewahrer.holeLetztesMemento());
        System.out.println(objekt.getZustand());
    }
}
