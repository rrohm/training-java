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
package org.meins.java8.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java8_Time00_LocalDate {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // 0. Create an object representing the current time:
    LocalDate now = LocalDate.now();
    LocalDate nowZoned = LocalDate.now(ZoneId.of("UTC"));
    LocalDate nextChristmas = LocalDate.of(2016, Month.DECEMBER, 24);
    
    // 1. Create a derived date, e.g., start of next month:
    LocalDate beginOfNextMonth = now.with(TemporalAdjusters.firstDayOfMonth()).plusMonths(1);
    LocalDate beginOfNextMonth2 = now.with(TemporalAdjusters.firstDayOfMonth()).plus(1, ChronoUnit.MONTHS);
    
    // 2. Printing date and time information
    System.out.println(beginOfNextMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH));
    System.out.println(beginOfNextMonth2.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMANY));
    System.out.println(beginOfNextMonth.getMonth().getDisplayName(TextStyle.NARROW, Locale.GERMANY));
    System.out.println(beginOfNextMonth2.getMonth().getDisplayName(TextStyle.NARROW_STANDALONE, Locale.GERMANY));
    System.out.println(beginOfNextMonth.getMonth().getDisplayName(TextStyle.SHORT, Locale.GERMANY));
    System.out.println(beginOfNextMonth2.getMonth().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.GERMANY));
    
    
  }
  
}
