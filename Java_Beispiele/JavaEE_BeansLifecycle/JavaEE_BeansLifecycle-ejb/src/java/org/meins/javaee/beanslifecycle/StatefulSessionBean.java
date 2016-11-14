/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.javaee.beanslifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;

/**
 *
 * @author robert rohm
 */
@Stateful
@LocalBean
public class StatefulSessionBean {

  @PostConstruct
  public void nachErzeugung() {
    System.out.println(">>> " + this.toString() + ": @PostConstruct");
  }


  @PrePassivate
  public void vorPassivierungDerSFSB(){
    System.out.println(">>> " + this.toString() + ": @PrePassivate");
  }

  @PostActivate
  public void nachReAktivierungDerSFSB(){
    System.out.println(">>> " + this.toString() + ": @PostActivate");
  }

  @PreDestroy
  public void vorDestroy() {
    System.out.println(">>> " + this.toString() + ": @PreDestroy");
  }


  public String sagHallo(String name){
    return "Hallo " + name;
  }
}
