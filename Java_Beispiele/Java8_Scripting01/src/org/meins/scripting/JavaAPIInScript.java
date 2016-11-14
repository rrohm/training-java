package org.meins.scripting;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaAPIInScript {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ScriptEngineManager engineMgr = new ScriptEngineManager();
    ScriptEngine jsEngine = engineMgr.getEngineByName("ECMAScript");

    MyAPI api = new MyAPI();

    jsEngine.put("api", api);
    System.out.println("Executing in script environment...");
    try {
      jsEngine.eval("api.myShutDownFunc()");
    } catch (ScriptException ex) {
      ex.printStackTrace();
    }
  }
}
