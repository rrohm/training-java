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

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@ViewScoped
public class AuswahllistenBean  implements Serializable {
  
  private PersonBean selectedPerson1;
  private PersonBean selectedPerson2;
  private PersonBean selectedPerson3;

  public PersonBean getSelectedPerson1() {
    return selectedPerson1;
  }

  public void setSelectedPerson1(PersonBean selectedPerson1) {
    this.selectedPerson1 = selectedPerson1;
  }

  /**
   * Creates a new instance of AuswahllistenBean
   */
  public AuswahllistenBean() {
  }

  public PersonBean getSelectedPerson2() {
    return selectedPerson2;
  }

  public void setSelectedPerson2(PersonBean selectedPerson2) {
    this.selectedPerson2 = selectedPerson2;
  }

  public PersonBean getSelectedPerson3() {
    return selectedPerson3;
  }

  public void setSelectedPerson3(PersonBean selectedPerson3) {
    this.selectedPerson3 = selectedPerson3;
  }
  
}
