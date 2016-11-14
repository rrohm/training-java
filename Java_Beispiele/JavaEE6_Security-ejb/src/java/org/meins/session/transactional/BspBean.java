/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.session.transactional;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

/**
 * Dieses Beispiel illustriert den Einsatz von Container-gesteuerter Transaktion
 * im Zusammenhang mit einem entity-Manager (nur Code-Fragment, nicht lauffähig).
 *
 * @author robert rohm
 */
@Stateless
@LocalBean
public class BspBean {

  EntityManager em;

  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public void transaktionaleMethode(){
    //
    em.find(null, this);
    //
    em.merge(this);
    em.flush();

    // nochmal find()? - Vorsicht, je nach JPA u.U. nich einheitlich.
    em.find(null, this);
    em.flush();

    //
    // und hier:
    // weitere SB aufrufen
    // ... muss ggf. auch zurückgrollt werden.
    // ACHTUNG! TESTEN, ob einmal geflushtes auch zurückgerollt wird!
  }
}
