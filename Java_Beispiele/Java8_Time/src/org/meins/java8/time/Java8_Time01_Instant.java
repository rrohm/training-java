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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java8.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Im Gegensatz zur LocalDate-Klasse, die für Datumsverarbeitung nach
 * "menschlichen Maßstäben", d.h., in Monat, Tag, Jahr, gedacht ist, wird
 * Instant nur zur Abbildung von Zeitpunkten und zur Arbeit mit
 * Nano-/Milli-Sekunden verwendet.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_Time01_Instant {

  public static void main(String[] args) {

    Instant now = Instant.now();
    Instant silvester2016 = Instant.parse("2016-12-31T00:00:00.00Z");
    
    System.out.println(now);
    System.out.println(silvester2016);

    // Geänderter Wert: erzeugt auch hier eine neue Instanz.
    Instant plusSeconds = now.plusSeconds(20);

    // Wenn aus einem Instant ein LocalDate(Time)-Wert gewonnen werden
    // soll, ist zusätzliche Zeitzonen-Information nötig:
    ZonedDateTime timeAtGMT = plusSeconds.atZone(ZoneId.of("GMT"));

  }
}
