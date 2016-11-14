/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.javaee.beanslifecycle;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author robert
 */
@Stateless
@LocalBean
public class EntityControllerSessionBean {

  @PersistenceContext
  EntityManager em;
  // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")

  public void erzeugeEntity(){

    EntityBean bean = new EntityBean();

    em.persist(bean);
    //

    // ACHTUNG: Persist-Callbacks werden erst bei Flush oder Commit ausgeführt
    em.flush();
  }

}
