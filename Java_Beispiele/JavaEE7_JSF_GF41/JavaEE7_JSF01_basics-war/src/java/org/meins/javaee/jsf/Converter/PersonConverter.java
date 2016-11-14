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
package org.meins.javaee.jsf.Converter;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.meins.javaee.jsf.beans.PersonBean;

/**
 * Biespiel für einen etwas spezielleren Faces-Converter: dieser Konverter soll
 * Zwischen Elementen einer Personenliste und deren String-Repräsentationen
 * konvertieren.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@FacesConverter(value = "myPersonConverter")
public class PersonConverter implements Converter {

  private final List<PersonBean> personenListe;

  public PersonConverter(List<PersonBean> personenListe) {
    this.personenListe = personenListe;
  }

  /**
   * Konvertierung von String zu Objekt - hier wird vom Framework die
   * toString()-Repräsentation des Wert-Objekt übergeben, und die Konvertierung
   * kann in diesem Fall nur durch zurück-schließen auf das Original-Objekt
   * anhand String-Vergleich erfolgen. Sofern die Wert-Objekte über eine ID
   * verfügen, ist dies meist vorzuziehen.
   *
   * @param context
   * @param component
   * @param value toString()-Repräsentation des Wert-Objekts(!).
   * @return
   */
  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    for (PersonBean person : personenListe) {
      if (person.getFirstName().concat(" ").concat(person.getLastName()).equals(value)) {
        return person;
      }
    }

    return null;
  }

  /**
   * Konvertierung zu String - in der Regel unproblematisch. Sinnvoll ist es
   * jedoch, auch hier auf eine vernünftige toString()-Implementierung zu
   * achten.
   *
   * @param context
   * @param component
   * @param value
   * @return
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value == null) {
      return "";
    } else {
      return value.toString();
    }
  }

}
