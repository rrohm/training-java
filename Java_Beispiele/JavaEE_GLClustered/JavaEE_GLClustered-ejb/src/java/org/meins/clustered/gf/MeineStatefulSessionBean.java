/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.clustered.gf;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author robert rohm
 */
@Stateful
public class MeineStatefulSessionBean implements MeineStatefulSessionBeanRemote {

  private int counter = 0;

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public String zeigeInstanzInfo() {
    final String instanzName = System.getProperty("com.sun.aas.instanceName");

    Logger.getLogger(MeineStatefulSessionBean.class.getName())
            .log(Level.INFO, "Running on: {0}", instanzName);

    return instanzName;
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public int gibZaehler() {
    this.counter++;
    return this.counter;
  }


}
