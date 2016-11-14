/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.javaee.clustered.web.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.meins.javaee.clustered.ejb.beans.MeineSessionBeanRemote;

/**
 * Managed Bean für JSF-Frontend, hier als Backing-Bean für Index-Seite.
 * In geclusterten Anwendungen muss die Managed Bean mit Session-Scope 
 * serialisierbar sein. 
 * 
 * @author robert rohm
 */
@ManagedBean
@SessionScoped
public class MeineManagedBean implements Serializable {

  @EJB
  private MeineSessionBeanRemote meineSessionBean;
  
  /**
   * Creates a new instance of MeineManagedBean
   */
  public MeineManagedBean() {
  }
  
  public int getCounter(){
    return this.meineSessionBean.getCount();
  }
  
  public String zeigeInstanzInfo(){
    return this.meineSessionBean.zeigeInstanzInfo();
  }
}
