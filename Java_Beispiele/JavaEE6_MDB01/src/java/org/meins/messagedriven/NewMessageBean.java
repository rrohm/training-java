package org.meins.messagedriven;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Beispiel-Klasse für eine MDB, die mit einem Topic arbeitet (Subscriber-Modell).
 *
 * @author robert rohm
 */
@MessageDriven(mappedName = "jms/irgendeinTopic", activationConfig = {
  @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
  @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
  @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
  @ActivationConfigProperty(propertyName = "clientId", propertyValue = "NewMessageBean"),
  @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "NewMessageBean")
})
public class NewMessageBean implements MessageListener {

  public NewMessageBean() {
  }

  @Override
  public void onMessage(Message message) {
    // Hier folgt die Logik zur Message-Behandlung
  }
}
