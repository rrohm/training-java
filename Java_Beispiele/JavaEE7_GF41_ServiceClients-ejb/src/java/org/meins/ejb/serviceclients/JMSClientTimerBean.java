/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.ejb.serviceclients;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Singleton
@LocalBean
@Startup
public class JMSClientTimerBean {

  @Resource(mappedName = "jms/__defaultConnectionFactory")
  private ConnectionFactory factory;

  @Resource(mappedName = "jms/testQueue")
  private Queue meineQueue;

  @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
  public void onScedule(Timer t){
    System.out.println("JMSClientTimerBean.onSchedule");
    Connection connection = null;
    Session session = null;

    try {
      connection = factory.createConnection();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      MessageProducer messageProducer = session.createProducer(meineQueue);

      TextMessage tm = session.createTextMessage();
      tm.setText("Test-Nachricht");
      messageProducer.send(tm);

    } catch (JMSException ex) {
      ex.printStackTrace();
      Logger.getLogger(JMSClientTimerBean.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (JMSException e) {
          Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (JMSException ex) {
          Logger.getLogger(JMSClientTimerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }
}
