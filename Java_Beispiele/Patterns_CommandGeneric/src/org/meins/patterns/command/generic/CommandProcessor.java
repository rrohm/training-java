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
public class CommandProcessor {
  
  private  ItemVisitor itemVisitor = new ItemVisitor();
  
  public void processCommand(Command c){
    System.out.println("Processing Command " + c);
    
    if (c.getItems().size() > 0) {      
      System.out.println("- item class: " + c.getItems().get(0).getClass() );
    }
    
    // geht nicht mehr - Typauslöschung!
//    for (Object item : c.getItems()) {
//      this.processItems(item);
//    }
    
    c.accept(this.itemVisitor);
  }
  
  public void processItems(ItemA a){
    System.out.println("Processing Item A " + a);
  }
  
  
  public class ItemVisitor {
    public void visit(ItemA a){
      System.out.println("ItemVisitor visits A " + a);
    }
    public void visit(ItemB b){
      System.out.println("ItemVisitor visits B " + b);
    }
  }
  
}
