/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schulung.framework;

import java.lang.reflect.Field;
import schulung.framework.annotations.Autowire;

/**
 * Hauptklasse des "Frameworks", übernimmt die Erzeugung von Instanzen,
 * Untersuchung auf Annotationen und ggf. Injektion von Abhängigkeiten.
 *
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Framework {

  public static Object assemble(Class objekttyp) throws InstantiationException, IllegalAccessException{

    // 1) Instanz erzeugen
    Object instanz = objekttyp.newInstance();

    // 2) auf Annotationen untersuchen
    Field[] declaredFields = objekttyp.getDeclaredFields();
    for (Field declaredField : declaredFields) {

      // 3) Prüfen, ob Annotation für Injektion vorhanden ist ...
      if (declaredField.isAnnotationPresent(Autowire.class)) {

        // 4) Instanz für Feld erzeugen und einfügen
        // - Feld beschreibbar machen!
        declaredField.setAccessible(true);

        // Wert-Instanz erzeugen und zuweisen
        Object feldWert = declaredField.getType().newInstance();
        declaredField.set(instanz, feldWert);
      }
    }

    return instanz;
  }
}
