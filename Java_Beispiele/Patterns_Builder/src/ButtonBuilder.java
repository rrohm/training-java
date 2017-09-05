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
 * Der Builder besitzt eine statische Fabrikethode zum erzeugen der
 * Builder-Instanz, sowie eine Reihe von "Konfigurationsmethoden", mit denen die
 * Werkstück-Erzeugung parametrisiert wird, und eine build()-Methode, die den
 * eigentlichen Werkstück-Erzeugungsvorgang entsprechend der Paramertrisierung
 * kapselt. Jede Konfgrationsmethode muss die Refeferenz auf den Builder selbst
 * zurückgeben, um verkettete Methodenaufrufe im Sinne einer "Fluent API" zu
 * erlauben.
 *
 * Um die Parameter nicht bis zur eigentlichen Erzeugung des Werkstücks
 * zwichenspeichern zu müssen, wurde dieser Builder etwas vereinfacht: er
 * erzeugt das Werkstück (ohne Parametrisierung) gleich im eigenen Konstruktor.
 *
 * <p>Interessante Fragestellungen: 
 * <ul>
 *   <li>Was ist, wenn es Pflicht-Parameter gibt?
 *       <ul>    
 *           <li>Erst bauen lassen, wenn angegeben. (Exception)</li>
 *           <li>Default-Werte aus Konfiguration</li>
 *           <li>Nur eine create()-Methode mit Pflicht-Parametern</li>
 *       </ul>    
 *   </li>
 *   <li>Was ist, wenn Verwendung des Builders erzwungen werden soll?
 *       <ul>    
 *           <li>Konstruktor private setzen, Builder als innere Klasse. </li>
 *       </ul>    
 *   </li>
 *   <li>Was ist bei Produkten mit komplexer Vererbungshierarchie?
 *       <ul>    
 *           <li>Ensprechende Builder-Hierarchie?</li>
 *           <li>Wiederverwertung geerbter Produkte (... Methoden)?!</li>
 *           <li>:-(</li>
 *       </ul>    
 *   </li>
 * </ul>
 * 
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class ButtonBuilder {

    private JButton button;

    /**
     * In ideser Variante wird das Werkstück gleich im Builder-Konstruktor
     * erzeugt.
     */
    public ButtonBuilder() {
        this.button = new JButton();
    }

    /**
     * Einstiegspunkt: Statische Erzeugungsmethode für den Builder - in der
     * Praxis wird für jedes Werkstück ein Builder erzeugt.
     *
     * @return Der Builder
     */
    public static ButtonBuilder create() {
        return new ButtonBuilder();
    }

    /**
     * Eine von mehreren Parametrisierungsmethoden - alle diese Methoden müssen
     * die Referenz auf den Builder (this) zurückgeben, damit mit
     * Aufrufverkettung auf dem Builder weitergearbeitet werden kann.
     *
     * @param t
     * @return
     */
    public ButtonBuilder text(String t) {
        this.button.setText(t);

        return this;
    }

    /**
     * Diese Methode liefert am Ende das fertige Werkstück.
     *
     * @return Fertiges Werkstück.
     */
    public JButton build() {
        return this.button;
    }

    public ButtonBuilder backgroundColor(Color blue) {
        // TODO Auto-generated method stub
        return this;
    }

    public ButtonBuilder foregroundColor(Color blue) {
        // TODO Auto-generated method stub
        return this;
    }
}
