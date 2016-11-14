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
package dependencyinjection.control;

import dependencyinjection.annotations.Service;
import dependencyinjection.model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Controller kümmert sich um alle fachlichen Methoden rund
 * um die Person-Klasse. Er benötigt hierzu auch z.B. einen Service für die
 * CRUD-Operationen rund um die Fachobjekte. Diesen wollen wir aber nicht
 * explizit erzeugen und zuweisen - das soll uns das Framework per DI
 * abnehmen.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonController {

  /**
   * Hier wird die selbst definierte Annotation verwendet, um dem Framework
   * anzuzeigen, dass in dieses Feld eine Referenz auf das entsprechende
   * Objekt einzufügen ist.
   */
  @Service
  private DBService service;

  /**
   * Anskizziertes Beispiel für eine Fachmethode - hier wird der injizierte
   * Service verwendet.
   * 
   * @return
   */
  public List<Person> getAllPersons(){
    // hier wird der Service benötigt...
    System.out.println("Arbeite mit Service: " + this.service);

    // Hier folgt (eigentlich der Zugriff z.B. mit JDBC auf die DB)
    List<Person> personsList = new ArrayList<>();
    personsList.add(new Person());

    return personsList;
  }

}
