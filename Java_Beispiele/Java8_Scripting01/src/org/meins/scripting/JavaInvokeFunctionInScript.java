package org.meins.scripting;

import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaInvokeFunctionInScript {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ScriptEngineManager engineMgr = new ScriptEngineManager();
    ScriptEngine jsEngine = engineMgr.getEngineByName("ECMAScript");

    List<String> namesList = new ArrayList<String>();
    namesList.add("Jill");
    namesList.add("Bob");
    namesList.add("Laureen");
    namesList.add("Ed");

    Invocable invocableEngine = (Invocable) jsEngine;
    try {
      jsEngine.eval("function printNames1(namesList) {"
              + "  var x;"
              + "  var names = namesList.toArray();"
              + "  for(x in names) {"
              + "    print(names[x]);"
              + "  }"
              + "}"
              + "function addName(namesList, name) {"
              + "  namesList.add(name);"
              + "}");
      invocableEngine.invokeFunction("printNames1", namesList);
      invocableEngine.invokeFunction("addName", namesList, "Dana");

      //invocableEngine.invokeFunction("printNames1", namesList);
    } catch (ScriptException ex) {
      ex.printStackTrace();
    } catch (NoSuchMethodException ex) {
      ex.printStackTrace();
    }
  }

}
