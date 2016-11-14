package org.meins.scripting;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LoadScript {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ScriptEngineManager engineMgr = new ScriptEngineManager();
    ScriptEngine engine = engineMgr.getEngineByName("ECMAScript");
    // InputStream is = LoadScript.class.getResourceAsStream("/org/meins/scripting/scripts/F1.js");
    // For execution also in the IDE: better fetch the system classloader: 
    InputStream is = LoadScript.class.getClass().getResourceAsStream("/org/meins/scripting/scripts/F1.js");
    try {
      Reader reader = new InputStreamReader(is);
      engine.eval(reader);
    } catch (ScriptException ex) {
      ex.printStackTrace();
    }
  }

}
