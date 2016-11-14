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

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Convenience {

  /**
   * @param args
   */
  public static void main(String[] args) throws InterruptedException, IOException {

    LogManager.getLogManager().readConfiguration(Convenience.class.getResourceAsStream("logging.properties"));
    Logger log = Logger.getLogger(Convenience.class.getName());

    while (true) {
      log.entering(Convenience.class.getName(), "main");
      log.config("\tconfig");
      log.fine("\tfine");
      log.finer("\tfiner");
      log.finest("\tfinest");
      log.info("\t");
      log.throwing(Convenience.class.getName(), "main", new Exception("Test-Exception"));
      log.warning("\twarning");
      log.severe("\tsevere");
      log.exiting(Convenience.class.getName(), "main");

      Thread.sleep(1000);
    }

  }

}
