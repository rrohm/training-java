/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jaxb.basics;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * You need a XmlRootElement
 * @author robert rohm
 */
@XmlRootElement(namespace = "org.meins.java.jaxb")
public class Data {

  private int ID = 1;
  private String name = "Mein Name";

  @XmlElementWrapper(name = "items")
  @XmlElement(name = "item")
  private List<Item> items = new ArrayList<Item>();

  public Data() {
  }

  /**
   * @return the ID
   */
  public int getID() {
    return ID;
  }

  /**
   * @param ID the ID to set
   */
  public void setID(int ID) {
    this.ID = ID;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the items
   */
  public List<Item> getItems() {
    return items;
  }
}
