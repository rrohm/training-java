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
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * Managed Bean für das ValueChangeListerner-Beispiel
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@SessionScoped
public class ChangeBean implements Serializable {

  private List<String> werteListe = new ArrayList<>();

  private String auswahl1;
  private String auswahl2;

  /**
   * Creates a new instance of PersonenlisteBean
   */
  public ChangeBean() {
    this.werteListe.add("Erster");
    this.werteListe.add("Zweiter");
    this.werteListe.add("Dritter");
    this.werteListe.add("Vierter");

  }

  public void valueChanged(ValueChangeEvent event) {
    System.out.println(" ValueChangeEvent! ");
    FacesContext.getCurrentInstance().renderResponse();
    
    System.out.println("old: " + event.getOldValue());
    System.out.println("new: " + event.getNewValue());
  }
  public List<String> getWerteListe() {
    return werteListe;
  }

  public void setWerteListe(List<String> liste) {
    this.werteListe = liste;
  }

  public String getAuswahl1() {
    return auswahl1;
  }

  public void setAuswahl1(String auswahl1) {
    this.auswahl1 = auswahl1;
  }

  public String getAuswahl2() {
    return auswahl2;
  }

  public void setAuswahl2(String auswahl2) {
    this.auswahl2 = auswahl2;
  }
}
