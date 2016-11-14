/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejbtimer;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Beispiel zur programmatischen Timer-Steuerung.
 * 
 * @author robert rohm
 */
@Singleton
@LocalBean
public class ProgrammaticTimerBean {
  private static final Logger LOG = Logger.getLogger(ProgrammaticTimerBean.class.getName());
  private static final String NEUER_PROGRAMMATISCHER_TIMER = "Neuer programmatischer Timer";

  @Resource
  TimerService timerService;

  public void startTimer(int ms) {
    LOG.info("Timer gestartet um " + new Date());
    Timer timer = timerService.createTimer(ms, NEUER_PROGRAMMATISCHER_TIMER);
  }

  @Timeout
  public void timerListenerMethode(Timer timer) {
    // hier: eigentliche Arbeit implementieren!
    // wenn mehrere Timer hier ausgewertet werden:
    // Timer-Info auswerten
    String info = (String) timer.getInfo();
    if (info == NEUER_PROGRAMMATISCHER_TIMER) {
      LOG.info("Timer abgelaufen um " + new Date());
    }
  }


}
