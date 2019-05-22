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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Die Typen LocalDateTime, LocalDate, LocalTime repräsentieren Datum mit ggf.
 * (zusätzlicher!) Lokalisierung und Zeitzone - eher gedacht aus der Sicht
 * menschlichen User.
 * <p>
 * Wichtig: Diese Typen enthalten selbst keine Zeitzonen-Information, sie sind
 * vielmehr vom Konzept her gedacht als "Zeitangabe bezogen auf eine Uhr
 * irgendwo an der Wand" (wall clock time). Die Info, "wo diese Uhr hängt" muss
 * über eine Zeitzonenangabe hinzugefügt werden.
 * <p>
 * LocalDateTime, LocalDate, LocalTime repräsentieren damit auch
 * <strong>keinen</strong>
 * Zeitpunkt auf der UTC-Zeitleiste!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DateTime04_LocalDateTime {

  public static void main(String[] args) {

    // Aktueller Zeitpunkt:
    LocalDateTime now = LocalDateTime.now();
    System.out.println("now:            " + now);

    // Datumsangaben
    LocalDate birthday = LocalDate.of(1971, Month.JULY, 8);

    // Zeitangaben 
    LocalTime morgen = LocalTime.of(9, 0);
    LocalTime minusHours = morgen.minusHours(10);
    System.out.println("minusHours: " + minusHours);

  }
}
