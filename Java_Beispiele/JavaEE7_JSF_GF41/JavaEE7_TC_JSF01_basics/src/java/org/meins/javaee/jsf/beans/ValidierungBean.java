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
package org.meins.javaee.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@SessionScoped  
public class ValidierungBean {
  
  private String stringWert;
  private int intWert;
  private double doubleWert;

  public String getStringWert() {
    return stringWert;
  }

  public void setStringWert(String stringWert) {
    this.stringWert = stringWert;
  }

  public int getIntWert() {
    return intWert;
  }

  public void setIntWert(int intWert) {
    this.intWert = intWert;
  }

  public double getDoubleWert() {
    return doubleWert;
  }

  public void setDoubleWert(double doubleWert) {
    this.doubleWert = doubleWert;
  }
}
