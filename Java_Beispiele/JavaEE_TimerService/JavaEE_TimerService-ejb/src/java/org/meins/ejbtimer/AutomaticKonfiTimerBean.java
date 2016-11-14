/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejbtimer;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 * Beispiel eiines automatischen Timers, der jedoch eigentlich als
 * programmatischer Timer in einer PostConstruct-Methode gestartet wird.
 * Dadurch kann z.B. vorab eine Konfigurationsdatei für das Timerinterval
 * eingelesen werden.
 *
 *
 * @author robert rohm
 */
@Singleton
@Startup
public class AutomaticKonfiTimerBean {

  private static final Logger LOG = Logger.getLogger(AutomaticKonfiTimerBean.class.getName());
  public static final String KONFI_TIMER = "Neuer programmatischer Timer";

  @Resource
  TimerService timerService;

  @PostConstruct
  public void nachErzeugung() {
    // Hier: Timer automatisch starten:
    // ... und ggf. vorher Konfiguration erst einlesen.
    TimerConfig config = new TimerConfig(KONFI_TIMER, true);
    Timer timer = timerService.createIntervalTimer(new Date(), 1000, config);
  }

  public void timerNeuSetzen(int ms) {
    Collection<Timer> timers = timerService.getTimers();
    for (Iterator<Timer> it = timers.iterator(); it.hasNext();) {
      Timer timer = it.next();
      if (timer.getInfo() == KONFI_TIMER) {
        timer.cancel();

        TimerConfig config = new TimerConfig(KONFI_TIMER, true);
        timerService.createIntervalTimer(new Date(), ms, config);
      }
    }
  }

  @Timeout
  public void timerBehandlung(Timer timer){
    if (timer.getInfo() == KONFI_TIMER) {
      // hier: eigentliche Arbeit ...

    }
  }

}
