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

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * JSF-Renderer zur InputDate-Komponente.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@FacesRenderer(componentFamily = "javax.faces.Input", 
        rendererType = "de.schulung.javaee.jsf.components.InputDate")
public class InputDateRenderer extends Renderer {

  @Override
  public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
    InputDate inputDate = (InputDate) component;
    String clientId = inputDate.getClientId();
    ResponseWriter writer = context.getResponseWriter();
    writer.startElement("input", inputDate);
    writer.writeAttribute("id", clientId, null);
//    writer.writeAttribute("name", clientId, null);
    writer.writeAttribute("type", "date", null);
    
    final Date date = inputDate.getDate();
    DateFormat dateFormat = new SimpleDateFormat(inputDate.getFormat());
    
    writer.writeAttribute("value", dateFormat.format(date), null);
    writer.writeAttribute("class", "input-date", null);
    writer.endElement("input");
  }

  @Override
  public void decode(FacesContext context, UIComponent component) {
    Map<String, String> requestParameters = context.getExternalContext().getRequestParameterMap();
    String clientId = component.getClientId();
    String value = requestParameters.get(clientId);
    ((UIInput)component).setSubmittedValue(value);
  }

  @Override
  public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
    InputDate inputDate = (InputDate) component;
    final Date date = inputDate.getDate();
    DateFormat dateFormat = new SimpleDateFormat(inputDate.getFormat());
    try {
      return dateFormat.parse(submittedValue.toString()); 
    } catch (ParseException ex) {
      return null;
    }
  }
  
  
  
}
