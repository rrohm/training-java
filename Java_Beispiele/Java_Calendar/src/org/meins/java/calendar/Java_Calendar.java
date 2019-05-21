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
package org.meins.java.calendar;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_Calendar {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    System.out.println("DEFAULT LOCALE ");
    System.out.println("CalendarType   : " + calendar.getCalendarType());
    System.out.println("Time           : " + calendar.getTime());
    System.out.println("WEEK_OF_YEAR   : " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("FirstDayOfWeek : " + calendar.getFirstDayOfWeek());
    System.out.println("SUNDAY         : " + Calendar.SUNDAY);
    System.out.println("MONDAY         : " + Calendar.MONDAY);
    System.out.println("TUESDAY        : " + Calendar.TUESDAY);
    
    calendar = Calendar.getInstance(Locale.GERMAN);
    System.out.println("Locale.GERMAN");
    System.out.println("DEFAULT LOCALE ");
    System.out.println("CalendarType   : " + calendar.getCalendarType());
    System.out.println("Time           : " + calendar.getTime());
    System.out.println("WEEK_OF_YEAR   : " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("FirstDayOfWeek : " + calendar.getFirstDayOfWeek());
    System.out.println("SUNDAY         : " + Calendar.SUNDAY);
    System.out.println("MONDAY         : " + Calendar.MONDAY);
    System.out.println("TUESDAY        : " + Calendar.TUESDAY);
    
    calendar = Calendar.getInstance(Locale.GERMANY);
    System.out.println("Locale.GERMANY");
    System.out.println("DEFAULT LOCALE ");
    System.out.println("CalendarType   : " + calendar.getCalendarType());
    System.out.println("Time           : " + calendar.getTime());
    System.out.println("WEEK_OF_YEAR   : " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("FirstDayOfWeek : " + calendar.getFirstDayOfWeek());
    System.out.println("SUNDAY         : " + Calendar.SUNDAY);
    System.out.println("MONDAY         : " + Calendar.MONDAY);
    System.out.println("TUESDAY        : " + Calendar.TUESDAY);
    
    calendar = Calendar.getInstance(Locale.GERMANY);
    calendar.setFirstDayOfWeek(Calendar.SUNDAY);
    System.out.println("Locale.GERMANY, setFirstDayOfWeek(Calendar.SUNDAY)");
    System.out.println("DEFAULT LOCALE ");
    System.out.println("CalendarType   : " + calendar.getCalendarType());
    System.out.println("Time           : " + calendar.getTime());
    System.out.println("WEEK_OF_YEAR   : " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("FirstDayOfWeek : " + calendar.getFirstDayOfWeek());
    System.out.println("SUNDAY         : " + Calendar.SUNDAY);
    System.out.println("MONDAY         : " + Calendar.MONDAY);
    System.out.println("TUESDAY        : " + Calendar.TUESDAY);
  }
  
}
