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
package java8.teil11.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Ausführung von JavaScript in der JVM mit der Scripting Engine.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class JavaScript01_Engines {

  public static void main(String[] args) throws ScriptException {

    // Factory für den verfügbaren Interpreter
    ScriptEngineManager factory = new ScriptEngineManager();

    // Engine-Namen, z.B.: javascript, JavaScript, 
    // auch verfügbar, aber nicht protabel: nashorn, rhino :-(
    ScriptEngine engine = factory.getEngineByName("javascript");

    engine.eval("print ('Hallo Welt?')");
    // Java 7: engine.eval("println ('Hallo Welt?')"); 

    // TODO: 1. Daten in JS-Kontext einfügen und verarbeiten
    // TODO: 2. In JS auf Java-Logik zugreifen
    // TODO: 3. In Java auf JS-Logik zugreifen
    
    // Siehe separates Beispiel-Projekt hierzu.
  }
}
