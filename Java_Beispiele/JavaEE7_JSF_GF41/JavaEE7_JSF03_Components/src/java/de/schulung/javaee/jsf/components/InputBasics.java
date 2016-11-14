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

import javax.faces.component.UIInput;

/**
 * S.
 * http://tutorials.irian.at/book_de/introduction.html#!idx:/custom_component.html:6.1.2.1
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class InputBasics extends UIInput {

  public static final String COMPONENT_TYPE = "de.aeonium.schulung.jsf.InputBasics";

  enum PropertyKeys {

    inc
  }
  
  

  public InputBasics() {
    setRendererType("de.aeonium.schulung.jsf.InputBasics");
  }

  public int getInc() {
    return (Integer) getStateHelper().eval(
            PropertyKeys.inc, 1);
  }

  public void setInc(int inc) {
    getStateHelper().put(PropertyKeys.inc, inc);
  }

}
