/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.patterns.command.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 * @param <T>
 */
public abstract class Command<T> {

  protected final List<T> items;

  public Command(T... items) {    
    this.items = new ArrayList<>();
    Collections.addAll(this.items, items);
  }

  /**
   * Get the value of items
   *
   * @return the value of items
   */
  public List<T> getItems() {
    return items;
  }

  public abstract void accept(CommandProcessor.ItemVisitor itemVisitor);

}
