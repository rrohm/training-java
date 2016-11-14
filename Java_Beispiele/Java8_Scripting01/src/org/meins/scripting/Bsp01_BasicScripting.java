/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.scripting;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author robert rohm
 */
public class Bsp01_BasicScripting {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // create a script engine manager
    ScriptEngineManager factory = new ScriptEngineManager();
    // create a JavaScript engine
    ScriptEngine engine = factory.getEngineByName("JavaScript");

    try {
      // evaluate JavaScript code from String
      engine.eval("print('Hello, World')");
    } catch (ScriptException ex) {
      System.out.println("Scripting-Fehler!");
      ex.printStackTrace();
    }
  }
}
