/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.userdb.session;

import javax.ejb.Stateless;

/**
 *
 * @author robert
 */
@Stateless
public class UserSessionBean implements UserSessionBeanRemote {

  @Override
  public String echo() {
    return null;
  }

    // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
  
}
