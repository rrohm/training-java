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
package java8.teil08.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Instant ist einer der beiden elementaren Datentypen für die Abbildung von
 * Datums- und Zeit-Info ... allerdings eher für die maschinelle Verarbeitung
 * mit Werten nach UTC.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DateTime03_Instant {

  public static void main(String[] args) {
    
    // Erzeugung von Instant-Werten
    Instant now = Instant.now();
    Instant januaryFirst2016 = Instant.parse("2016-01-01T00:00:00Z");
    // Konvertierung aus der alten Date-API:
    Instant instantFromDate = new Date().toInstant();

    // Berechnungen mit Instant, 
    // z.B. mit ChronoUnits
    Instant plus = now.plus(5, ChronoUnit.HOURS);
    // z.B. mit Duration, z.B. 10 Tage später
    Instant jan10th = januaryFirst2016.plus(Duration.ofDays(10));
    
    // Vergleich: Vorher/nachher
    boolean after = now.isAfter(jan10th);
    
    // Abstand zwischen Zeitpunkten: 
    Duration jan10thUntilNow = Duration.between(jan10th, now);
    // Ausgabe von Duration - ebenfalls ISO8601-Standard
    // PT5791H53M1.023S
    System.out.println("jan10thUntilNow: " + jan10thUntilNow);
    
    // Achtung: nur begrenzte Units unterstützt :-(
//    long hours    = jan10thUntilNow.get(ChronoUnit.HOURS);
//    long days    = jan10thUntilNow.get(ChronoUnit.DAYS);
    long seconds = jan10thUntilNow.get(ChronoUnit.SECONDS);
    long nanos = jan10thUntilNow.get(ChronoUnit.NANOS);
    System.out.println("seconds         : " + seconds);
 
    System.out.println(ChronoUnit.HOURS.between(januaryFirst2016, now));
    
    // Für Vergleiche über längere Distanzen ist u.a. Zeitzonen-Info nötig.
  }
}
