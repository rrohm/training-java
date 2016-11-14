/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jaxb.basics;

/**
 *
 * @author robert
 */
public class Item {

  private String value = null;

  /**
   * No-args constructor is a requirement.
   */
  public Item() {
  }

  public Item(String value) {
    this.value = value;

  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

}
