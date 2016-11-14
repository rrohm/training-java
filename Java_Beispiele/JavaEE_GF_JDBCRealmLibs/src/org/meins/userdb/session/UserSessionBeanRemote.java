/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.userdb.session;

import javax.ejb.Remote;

/**
 *
 * @author robert
 */
@Remote
public interface UserSessionBeanRemote {

  String echo();
  
}
