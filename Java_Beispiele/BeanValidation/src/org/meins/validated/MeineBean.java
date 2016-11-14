/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.validated;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;

/**
 *
 * @author robert rohm
 */
public class MeineBean {


  @AssertTrue
  private boolean ok;

  @Min(0)
  private int prozent;

  /**
   * @return the ok
   */
  public boolean isOk() {
    return ok;
  }

  /**
   * @param ok the ok to set
   */
  public void setOk(boolean ok) {
    this.ok = ok;
  }

}
