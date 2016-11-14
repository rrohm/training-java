/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejbtimer;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Diese Bean kann als Webservice aufgerufen werden, um die Timer-Beispielklassen
 * anzustoßen.
 * 
 * @author robert rohm
 */
@Singleton
@LocalBean
@WebService
public class TimerStarterBean {

  @EJB
  ProgrammaticTimerBean programmaticTimerBean;

  @EJB
  ProgrammaticIntervalTimerBean programmaticIntervalTimerBean;

  @WebMethod
  public void startSimpleTimer(int ms) {
    programmaticTimerBean.startTimer(ms);
  }

  @WebMethod
  public void startIntervalTimer(int ms) {
    programmaticIntervalTimerBean.startIntervalTimer(ms);
  }
}
