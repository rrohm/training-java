/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.clustered.gf;

import javax.ejb.Remote;

/**
 *
 * @author robert
 */
@Remote
public interface MeineStatefulSessionBeanRemote {

  String zeigeInstanzInfo();

  int gibZaehler();

}
