/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.javaee.clustered.ejb.beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author robert rohm
 */
@Stateful
@LocalBean
public class MeineSessionBean implements Serializable, MeineSessionBeanRemote {
  
  private int counter  = 0;
  
  @Override
  public Integer getCount(){
    return ++this.counter;
  }
  
  
  @Override
  public String zeigeInstanzInfo() {
    final String instanzName = System.getProperty("com.sun.aas.instanceName");

    Logger.getLogger(MeineSessionBean.class.getName())
            .log(Level.INFO, "Running on: {0}", instanzName);

    return instanzName;
  }

    // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
}
