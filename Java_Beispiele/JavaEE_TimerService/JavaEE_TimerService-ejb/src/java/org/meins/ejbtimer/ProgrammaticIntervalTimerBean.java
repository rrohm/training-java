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
 * Beispiel zur programmatischen Steuerung von Interval-Timern.
 * 
 * @author robert rohm
 */
@Singleton
@LocalBean
public class ProgrammaticIntervalTimerBean {
  private static final Logger LOG = Logger.getLogger(ProgrammaticIntervalTimerBean.class.getName());

  @Resource
  TimerService timerService;

  private int counter = 0;

  public void startIntervalTimer(int ms) {
    LOG.info("IntervalTimer gestartet um " + new Date());
    TimerConfig config = new TimerConfig("Neuer programmatischer Timer", true);
    Timer timer = timerService.createIntervalTimer(new Date(), ms, config);
  }

  @Timeout
  public void timeout(Timer timer) {
    Date nextTimeout = timer.getNextTimeout();
    String info = (String) timer.getInfo();
    LOG.info("Interval-Timer '" + info + "' abgelaufen um " + new Date()
            + ", nächster Timout um " + nextTimeout
            + ", Zähler " + this.counter);

    if (this.counter > 10) {
      timer.cancel();
    }
    this.counter++;
  }


}
