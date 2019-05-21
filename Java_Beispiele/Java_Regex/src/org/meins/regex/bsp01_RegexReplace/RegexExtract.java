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
package org.meins.regex.bsp01_RegexReplace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class RegexExtract {

    public static void main(String[] args) {

        // Hier: Der numerische Teil dieser String-Vorlage soll herausgefilter, 
        // geändert und anschließend wieder eingesetzt werden.
        String inputString = "<html><head><title>DER TITEL</title></head><body>...</body></html>";
        int nr = 321;

        // 1) Regex wird in Java durch ein Regex-Pattern-Objekt repäresentiert:
        Pattern p = Pattern.compile("<title>(.*)</title>");

        // 2) Der Regex wird verwendet, um einen Matcher für den zu untersuchenden 
        // String zu erzeugen: 
        Matcher matcher = p.matcher(inputString);

        // 3) Zugriff auf die Vorkommen der gesuchten Zeichenfolge
        if (matcher.find()) {
          final String group = matcher.group();
            
            // Gefundene Zeichen werden als Zeichengruppe zurückgegeben:
            String numberString = group;
            System.out.println("found: " + numberString);
            System.out.println("start: " + matcher.start());
            System.out.println("end  : " + matcher.end());
            System.out.println("group: " + group);
            System.out.println("subst: " + inputString.substring(matcher.start(), matcher.end()));

            System.out.println(group.substring(7, group.length() - 8));

        }
    }
}
