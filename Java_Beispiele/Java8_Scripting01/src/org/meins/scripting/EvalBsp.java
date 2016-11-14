package org.meins.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvalBsp {
	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		try {
			jsEngine.eval("print('Hello, world!')");
		} catch (ScriptException ex) {
			ex.printStackTrace();
		}
	}
}
