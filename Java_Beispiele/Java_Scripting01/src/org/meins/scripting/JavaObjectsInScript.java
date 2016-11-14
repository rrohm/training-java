package org.meins.scripting;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaObjectsInScript {

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
	  
	  jsEngine.put("namesListKey", namesList);
	  System.out.println("Executing in script environment...");
	  try {
	    jsEngine.eval("var x;" +
	                  "var names = namesListKey.toArray();" +
	                  "for(x in names) {" +
	                  "  println(names[x]);" + // JDK7: println, JDK8: print
	                  "}" +
	                  "namesListKey.add(\"Dana\");");
	  } catch (ScriptException ex) {
	      ex.printStackTrace();
	  }
	  System.out.println("Executing in Java environment...");
	  for (String name: namesList) {
	    System.out.println(name);
	  }  
	}

}
