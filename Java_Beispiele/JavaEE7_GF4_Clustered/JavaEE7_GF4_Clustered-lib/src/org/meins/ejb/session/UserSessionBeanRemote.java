/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.ejb.session;

import javax.ejb.Remote;

/**
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
@Remote
public interface UserSessionBeanRemote {


  public String getServerInfo();
}
