package org.meins.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaClassesInScript {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScriptEngineManager engineMgr = new ScriptEngineManager();
		ScriptEngine jsEngine = engineMgr.getEngineByName("ECMAScript");
		
	  try {
	    jsEngine.eval("importPackage(javax.swing);" +
	        "var optionPane = " +
	        "  JOptionPane.showMessageDialog(null, 'Hello, world!');");
	  } catch (ScriptException ex) {
	    ex.printStackTrace();
	  }
	}

}
