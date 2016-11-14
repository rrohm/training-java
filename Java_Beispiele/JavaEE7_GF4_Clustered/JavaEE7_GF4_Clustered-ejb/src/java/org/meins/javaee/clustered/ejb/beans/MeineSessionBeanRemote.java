/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.javaee.clustered.ejb.beans;

import javax.ejb.Remote;

/**
 *
 * @author robert
 */
@Remote
public interface MeineSessionBeanRemote {

  Integer getCount();

  String zeigeInstanzInfo();
  // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
  
}
