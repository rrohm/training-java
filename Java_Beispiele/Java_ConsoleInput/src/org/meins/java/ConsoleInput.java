/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java;

import java.io.Console;

/**
 *
 * @author robert
 */
public class ConsoleInput {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Console console = System.console();

    if (console == null) {
      System.err.println("No console available! ");
      return;
    }

    String input = console.readLine();

    System.out.println("Input: " + input);

    
    char[] pwd = console.readPassword();


  }
}
