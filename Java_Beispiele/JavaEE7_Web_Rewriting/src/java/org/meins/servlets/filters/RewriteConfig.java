/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.servlets.filters;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */

@XmlRootElement(name = "rewrite-config")
public class RewriteConfig {
  
  @XmlElement(name = "mapping")
  private final List<RewriteMapping> mappings;

  public RewriteConfig() {
    this.mappings = new ArrayList<>();
  }

  public List<RewriteMapping> getMappings() {
    return mappings;
  }
}
