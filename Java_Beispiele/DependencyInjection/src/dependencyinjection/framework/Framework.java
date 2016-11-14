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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package dependencyinjection.framework;

import dependencyinjection.annotations.Service;
import dependencyinjection.control.DBService;
import java.lang.reflect.Field;

/**
 * Hauptklasse meines Framework - sie übernimmt vor allem die  Auswertung von
 * Annotationen per Reflection und die Instanzierung.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Framework {

  public static Object createController(Class controllerKlasse) throws InstantiationException, IllegalAccessException{
    // 1) Instanz bilden:
    Object newInstance = controllerKlasse.newInstance();

    // 2) Annotationen auswerten
    //    - FelderListe holen
    Field[] declaredFields = controllerKlasse.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      // Gibt es eine @Service-Annotation an diesem Feld?
      boolean annotationPresent = declaredField.isAnnotationPresent(Service.class);

      if (annotationPresent) {
        // Wenn JA:
        // - Feld schreibbar machen
        declaredField.setAccessible(true);

        // - Instanz DBService (erzeugen und) einfügen.
        DBService dBService = new DBService();
        declaredField.set(newInstance, dBService);

        // alternativ könnte noch flexibler der Typ des Feldes selbst abgefragt
        // und instanziert werden, falls es kein Interface ist:
        if (!declaredField.getType().isInterface()) {
          Object service = declaredField.getType().newInstance();
          declaredField.set(newInstance, service);

        } else {
          throw new InstantiationException("Interface kann nicht instanziert werden!");
        }
      }
    }
    return newInstance;
  }
}
