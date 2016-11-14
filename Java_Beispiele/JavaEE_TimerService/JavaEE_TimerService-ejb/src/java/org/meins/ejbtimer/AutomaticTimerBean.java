/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejbtimer;

import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 * Einfacher automatischer Timer.
 * 
 * @author robert rohm
 */
@Singleton
@Startup
public class AutomaticTimerBean {
  private static final Logger LOG = Logger.getLogger(AutomaticTimerBean.class.getName());

  @Schedule(second="*/1", minute="*",hour="*", persistent=false)
  public void automaticTimeout(){
    LOG.info("automaticTimeout um " + new Date());
  }
}
