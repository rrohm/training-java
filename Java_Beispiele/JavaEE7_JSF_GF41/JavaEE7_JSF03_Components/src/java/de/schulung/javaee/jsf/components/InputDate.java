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
package de.schulung.javaee.jsf.components;

import java.util.Date;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;

/**
 * Einfache eigene Input-Komponente: HTML5-Datumsfeld.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@FacesComponent(value = "de.schulung.javaee.jsf.components.InputDate",
        createTag = true,
        tagName = "inputDate",
        namespace = "http://schulung.de/jsf/component"
)
public class InputDate extends UIInput {

  public static final String COMPONENT_TYPE
          = "de.schulung.javaee.jsf.components.InputDate";

  enum PropertyKeys {

    date, format
  }

  public InputDate() {
    super();
    setRendererType("de.schulung.javaee.jsf.components.InputDate");
  }
  
  public Date getDate() {
    return (Date) getStateHelper().eval(PropertyKeys.date, new Date());
  }

  public void setDate(Date date) {
    getStateHelper().put(PropertyKeys.date, date);
  }
  
  public String getFormat() {
    return (String) getStateHelper().eval (PropertyKeys.format, "dd.MM.yyyy");
  }

  public void setFormat(String format) {
    getStateHelper().put(PropertyKeys.format, format);
  }
}
