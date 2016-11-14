/**
 */
package org.meins.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author robert rohm
 */
public class Bsp02_ScriptingAppVariables {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    Person p1 = new Person("Mustermann", "Max");
    engine.put("person1", p1);

    Person p2 = new Person("Mustermann", "Lisa");
    engine.put("person2", p2);

    String script = "println ('Erste Person:'); "
            + "println (person1.toString());  "
            + "println ('Zweite Person:');"
            + "println (person2.toString()) ";

    engine.eval(script);
  }
}

/**
 * Eine einfache Beispiel-Klasse
 *
 */
class Person {

  private final String name;
  private final String vorname;

  public Person(String aName, String aVorname) {
    this.name = aName;
    this.vorname = aVorname;
  }

  @Override
  public String toString() {
    return "Person: " + this.vorname + " " + this.name;
  }
}