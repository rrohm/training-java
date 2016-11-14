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
package org.meins.logging.simple;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Beispiel einer Anwendungsklasse mit Logging - Standardvorgehen ist hier in 
 * Java-Anwendungen, dass jede Klasse ihr (statisches) Logger-Objekt definiert. 
 * 
 * @author Admin
 */
public class Trivial {

  /**
   * @param args
   */
  public static void main(String[] args) throws InterruptedException {

    // Standard-Vorgehen: Logger wird mit Klasennamen als Loggernamen definiert  
    Logger log = Logger.getLogger(Trivial.class.getName());

    while (true) {
      log.log(Level.ALL,    Integer.toString(Level.ALL.intValue()) +    "\tAlle Level, Integer.MIN_VALUE");
      log.log(Level.CONFIG, Integer.toString(Level.CONFIG.intValue()) + "\tKonfigurations-Meldung ... ");
      log.log(Level.FINE,   Integer.toString(Level.FINE.intValue()) +   "\tFINE-Meldung ... ");
      log.log(Level.FINER,  Integer.toString(Level.FINER.intValue()) +  "\tFINER-Meldung ... ");
      log.log(Level.FINEST, Integer.toString(Level.FINEST.intValue()) + "\tFINEST-Meldung ... ");
      log.log(Level.INFO,   Integer.toString(Level.INFO.intValue()) +   "\tInfo-Meldung!");
      log.log(Level.OFF,    Integer.toString(Level.OFF.intValue()) +    "\tLevel für 'KEINE' Meldung, ist Integer.MAX_VALUE!");
      log.log(Level.WARNING, Integer.toString(Level.WARNING.intValue()) +   "\tWarnung!");
      log.log(Level.SEVERE, Integer.toString(Level.SEVERE.intValue()) +    "\tSchwerer Fehler!");

      Thread.sleep(1000);
    }

  }

}
