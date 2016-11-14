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
package dependencyinjection;

import dependencyinjection.control.PersonController;
import dependencyinjection.framework.Framework;
import dependencyinjection.model.Person;
import java.util.List;

/**
 * Dieses Beispiel illustriert die Dependency Injection mit Hilfe von
 * Annotationen und Reflection.
 * Eine Anwendung soll (fiktiv) Personendatensätze aus einer DB auslesen.
 * Der Zugriff auf die DB soll in einer eigenen Klasse gekapselt werden
 * ("Service").
 * Ein "Controller" soll alle fachlichen Methoden implementieren.
 * Zur Speicherung / Änderung / Löschung benötigt der Controller den Service.
 * Instanzen von Controller und Service sollen von einem "Framework"
 * bereitgestellt werden, das z.B. auch dem Controller eine Instanz von
 * Service bereitstellen soll.
 * Die Stellen, wo der Service eingefügt werden sollen, werden per Annotation
 * markiert.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DependencyInjection {

  /**
   * Startmethode: hier werden notwendige Klassen erzeugt (Controller),
   * allerdings nicht per direkter Instanzierung, sondern mit einer
   * Fabrik-Methode des Frameworks. In dieser Fabrikmethode wird zudem die
   * "Verdrahtung" gekapselt, d.h. das Untersuchen der Controller-Klasse
   * auf Annotationen für die DI und ggf. das Erzeugen und Einfügen von
   * Referenzen auf abhängige Objekte. 
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {

    // Controller erzeugen *lassen* - die "Verdrahtung" macht das Framework
    // im Hintergrund!

    PersonController personController = (PersonController) Framework.createController(PersonController.class);
    System.out.println("personController " + personController);

    // z.B. Abruf der Personenliste
    List<Person> allPersons = personController.getAllPersons();
  }

}
