/*
 */
package org.meins.regex.bsp00_RegexTester;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Quelle: http://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
 * @author r.rohm
 */
public class RegexTestHarness {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Console console = System.console();
    if (console == null) {
      System.err.println("No console.");
      System.exit(1);
    }
    while (true) {

      Pattern pattern =
              Pattern.compile(console.readLine("%nEnter your regex: "));

      Matcher matcher =
              pattern.matcher(console.readLine("Enter input string to search: "));

      boolean found = false;
      while (matcher.find()) {
        console.format("I found the text"
                + " \"%s\" starting at "
                + "index %d and ending at index %d.%n",
                matcher.group(),
                matcher.start(),
                matcher.end());
        found = true;
      }
      if (!found) {
        console.format("No match found.%n");
      }
    }
  }
}

/*
 */
