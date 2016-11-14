/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.javaee.beanslifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author robert rohm
 */
@Stateless(mappedName = "MeineStatelessSessionBean", name = "MeineStatelessSessionBean")
@LocalBean
public class StatelessSessionBean {

  @PostConstruct
  public void nachErzeugung(){
    System.out.println(">>> " + this.toString() + ": @PostConstruct");
  }


  @PreDestroy
  public void vorDestroy(){
    System.out.println(">>> " + this.toString() + ": @PreDestroy");
  }

  public String sagHallo(String name){
    return "Hallo " + name;
  }
}
