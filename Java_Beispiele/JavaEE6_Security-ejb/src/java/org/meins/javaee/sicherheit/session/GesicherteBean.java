/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.javaee.sicherheit.session;

import javax.ejb.Stateless;

/**
 *
 * @author robert
 */
@Stateless
public class GesicherteBean implements GesicherteBeanLocal {


  public String gesichertesSagHallo(String name){
    return "Hallo " + name;
  }

}
