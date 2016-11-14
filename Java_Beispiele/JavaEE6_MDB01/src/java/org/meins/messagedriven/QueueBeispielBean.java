package org.meins.messagedriven;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.meins.jms.entities.JMSMeldung;

/**
 * Message Driven Beans: Beispielklasse für eine Message-Queue 
 * (Point-to-point-Modell)
 *
 * @author robert rohm
 */
@MessageDriven(mappedName = "jms/meineQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueBeispielBean implements MessageListener {

    @PersistenceContext(name = "JavaEE6_GF4_JMSClient-jpaPU")
    private EntityManager em;
    
    public QueueBeispielBean() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println("> QueueBeispielBean hat Nachricht erhalten: " + text);
                
                JMSMeldung meldung = new JMSMeldung();
                meldung.setText(text);
                
                em.persist(meldung);
                em.flush();
                
            } catch (JMSException ex) {
                Logger.getLogger(QueueBeispielBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
