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

/**
 * Diese Klasse ist ein Werte-Container, der "generisch" mit Werten
 * unterschiedlichen Typs arbeiten soll.
 *
 * <p>
 * Hierzu wird mit der Typ-Deklaration ein Typ-Platzhalter dazu-deklariert, der
 * danach z.B. als Parameter-Typ oder als Rückgabetyp eingesetzt werden kann.
 * </p>
 *
 * @author R. Rohm
 */
class Box<T> {

    /**
     * Generischer Typ als Feld-Typ: 
     */
    private T val;

    /**
     * Generischer Typ als Parameter-Typ: 
     */
    void setValue(T val) {
        this.val = val;
    }

    /**
     * Generischer Typ als Rückgabe-Typ: 
     */
    T getValue() {
        return val;
    }
}
