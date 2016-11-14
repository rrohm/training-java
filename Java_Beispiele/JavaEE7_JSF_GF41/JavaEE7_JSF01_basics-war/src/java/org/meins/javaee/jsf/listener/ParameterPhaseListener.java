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
package org.meins.javaee.jsf.listener;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Weiterer Test-Listener - muss über faces-config.xml registriert werden: 
 * 
 * <pre><code><faces-config xmlns="http://xmlns.jcp.org/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
      http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd"
    version="2.2">
  <lifecycle>
    <phase-listener>
      org.meins.javaee.jsf.listener.DebugPhaseListener
    </phase-listener>
    <phase-listener>
      org.meins.javaee.jsf.listener.ParameterPhaseListener
    </phase-listener>
  </lifecycle>
</faces-config>
 *  </code>
 * </pre>
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt; - siehe http://tutorials.irian.at/book_de/introduction.html#!idx:/jsf.html:2.8.5
 */
public class ParameterPhaseListener implements PhaseListener {

  public void beforePhase(PhaseEvent event) {
    FacesContext fc = FacesContext.getCurrentInstance();
    Map<String, String> map = fc.getExternalContext().getRequestParameterMap();
    for (String key : map.keySet()) {
      StringBuilder param = new StringBuilder();
      param.append("Parameter: ");
      param.append(key);
      param.append(" = ");
      param.append(map.get(key));
      System.out.println(param.toString());
    }
  }

  public void afterPhase(PhaseEvent event) {
  }

  public PhaseId getPhaseId() {
    return PhaseId.APPLY_REQUEST_VALUES;
  }
}
