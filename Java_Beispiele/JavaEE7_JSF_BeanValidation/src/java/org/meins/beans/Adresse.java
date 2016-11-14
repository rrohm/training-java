/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@RequestScoped
public class Adresse {

  private String strasse;

  private String hausnr;

  private String ort;

  private String plz;

  public Adresse(String strasse, String hausnr, String ort, String plz) {
    this.strasse = strasse;
    this.hausnr = hausnr;
    this.ort = ort;
    this.plz = plz;
  }

  /**
   * Get the value of plz
   *
   * @return the value of plz
   */
  public String getPlz() {
    return plz;
  }

  /**
   * Set the value of plz
   *
   * @param plz new value of plz
   */
  public void setPlz(String plz) {
    this.plz = plz;
  }

  /**
   * Get the value of ort
   *
   * @return the value of ort
   */
  public String getOrt() {
    return ort;
  }

  /**
   * Set the value of ort
   *
   * @param ort new value of ort
   */
  public void setOrt(String ort) {
    this.ort = ort;
  }

  /**
   * Get the value of hausnr
   *
   * @return the value of hausnr
   */
  public String getHausnr() {
    return hausnr;
  }

  /**
   * Set the value of hausnr
   *
   * @param hausnr new value of hausnr
   */
  public void setHausnr(String hausnr) {
    this.hausnr = hausnr;
  }

  /**
   * Get the value of strasse
   *
   * @return the value of strasse
   */
  public String getStrasse() {
    return strasse;
  }

  /**
   * Set the value of strasse
   *
   * @param strasse new value of strasse
   */
  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  /**
   * Creates a new instance of Adresse
   */
  public Adresse() {
  }

  
}
