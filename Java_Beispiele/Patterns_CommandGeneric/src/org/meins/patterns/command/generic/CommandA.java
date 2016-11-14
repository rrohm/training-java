/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.patterns.command.generic;

/**
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class CommandA extends Command<ItemA>{

  public CommandA(ItemA... items){
    super(items);
  }
  
  @Override
  public void accept(CommandProcessor.ItemVisitor itemVisitor) {
    for (ItemA itemA : items) {
      itemVisitor.visit(itemA);      
    }
  }  
}
