package org.meins.scripting;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		List<ScriptEngineFactory> scriptFactories = mgr.getEngineFactories();
		ScriptEngine engine = null;
		
		for (ScriptEngineFactory factory : scriptFactories) {
			String langName = factory.getLanguageName();
			String langVersion = factory.getLanguageVersion();
      System.out.printf("\tLanguage: %s (%s)\n", langName, langVersion);
			if (langName.equals("ECMAScript") && langVersion.equals("ECMA - 262 Edition 5.1")) {
				engine = factory.getScriptEngine();
				break;
			}
		}
		System.out.println("Engine gefunden: " + engine);
	}

}
