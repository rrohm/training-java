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

package org.meins.java7.sprache.bsp02_StringSwitch;

/**
 * Switch-Statements sind ab JDK 7 auch mit String-Argument möglich.
 *
 * @author R. Rohm
 */
public class StringSwitch {

  public static String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
    String typeOfDay;
    
    switch (dayOfWeekArg) {
      case "Monday":
        typeOfDay = "Start of work week";
        break;
      case "Tuesday":
      case "Wednesday":
      case "Thursday":
        typeOfDay = "Midweek";
        break;
      case "Friday":
        typeOfDay = "End of work week";
        break;
      case "Saturday":
      case "Sunday":
        typeOfDay = "Weekend";
        break;
      default:
        throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
    }
    return typeOfDay;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

      System.out.println(getTypeOfDayWithSwitchStatement("Monday"));

  }
}
