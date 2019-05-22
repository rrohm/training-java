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
package aufgaben.teil01.lambdas;

import java.io.File;
import java.io.FileFilter;

/**
 * <h3>Aufgabe Lambdas 02: "FileFilter"</h3>
 * <p>
 * Die unten gezeigten File-Filter lassen sich mit Java 8 kürzer coden - wie
 * können alternative Umsetzungen aussehen?
 * <p>
 * Hinweise: 
 * <ul>
 *   <li>Für den ersten Filter kann eine Methodenreferenz eingesetzt werden.</li>
 *   <li>Der zweite Filter sollte als Lambda implementiert werden.</li>
 * </ul>
 * 
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Aufgabe_Lambdas02 {

  public static void main(String[] args) {
    
    final FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    };

    final FileFilter pdfFileFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf"));
      }
    };
  }
}
