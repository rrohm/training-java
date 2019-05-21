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
package org.meins.logging.handler;

import org.meins.logging.simple.Trivial;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

/**
 * Hier wird programmatisch ein Filehandler für das Logging definiert.
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Handler01_File {
  
  /**
   * Standard: ein privater statischer Logger für die Klasse - mit Klassennamen
   * als Logger-Namen und nur pro Klasse, nicht pro Instanz.
   */
  private static Logger log = Logger.getLogger(Trivial.class.getName());

  public static void main(String[] args) throws IOException {


    String filename = "LogMitFilename";
    int limit = 32 * 1024 * 1024;
    int count = 10;
    boolean append = true;

    log.setUseParentHandlers(false);
    log.addHandler(new FileHandler(filename, limit, count, append));

    log.log(Level.SEVERE, "Meldung!");

    while (true) {
      log.log(Level.INFO, "Meldung um " + new Date());

    }
  }
}
