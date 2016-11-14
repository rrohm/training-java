/*
 * This code is released under Creative Commons Attribution 4.0 International 
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means: 
 * 
 * You are free to:
 * 
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 * 
 *     The licensor cannot revoke these freedoms as long as you follow the 
 *     license terms.
 * 
 * Under the following terms:
 * 
 *     Attribution — You must give appropriate credit, provide a link to the 
 *     license, and indicate if changes were made. You may do so in any 
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 * 
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license 
 * permits.
 */

package org.meins.concurrency.bsp04_volatile;

import java.util.List;

/**
 * Die Verwendung von als volatile deklarierten Feldern hat folgende Bedeutung: 
 * - Lese- und Schreib-Zugriffe auf das Feld werden synchronisiert
 * - Jeder Thread sieht den aktuellen Wert, keine Thread-lokale Kopie
 * - Jeder Thread sieht auch ggf. jeden Seiteneffekt einer Wert-Änderung
 * 
 * ACHTUNG! Die Verwendung von volatile ersetzt NICHT den Einsatz von 
 *          Synchronisierung!
 * 
 * @author Robert Rohm
 */
public class VolatileData {
  
  /**
   * Feld als volatile deklariert!
   */
  private volatile String text;
  
  /**
   * ACHTUNG! Zugriff auf die *Elemente* ist NICHT ATOMAR 
   */
  private volatile String[] texte;
  /**
   * ACHTUNG! Zugriff auf die *Elemente* ist NICHT ATOMAR
   */
  private volatile List<String> textListe;
  
  /**
   * Atomarer Integer? NEIN - nur der Lese- und Schreibzugriff
   * auf das Feld, nicht etwa automatisch alle Operationen 
   * auf dieser Variablen
   */
  private volatile int i;
  
  /**
   * Ist NICHT atomar!
   */
  public void inkrementiereI(){
    this.i++;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
