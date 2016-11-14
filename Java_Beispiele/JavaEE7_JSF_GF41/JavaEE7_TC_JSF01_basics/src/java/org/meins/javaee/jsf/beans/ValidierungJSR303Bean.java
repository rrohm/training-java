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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@SessionScoped  
public class ValidierungJSR303Bean {
  
  @Size(min = 3, max = 10)
  @NotNull
  private String stringWert;
  @Min(5)
  @Max(800)
  @NotNull
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
