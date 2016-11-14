/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.servlets.filters;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@XmlRootElement(name = "mapping")
public class RewriteMapping {

  private String pattern;
  private String toView;

  public RewriteMapping() {
  }

  public RewriteMapping(String pattern, String toView) {
    this.pattern = pattern;
    this.toView = toView;
  }

  
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public String getToView() {
    return toView;
  }

  public void setToView(String toView) {
    this.toView = toView;
  }
}
