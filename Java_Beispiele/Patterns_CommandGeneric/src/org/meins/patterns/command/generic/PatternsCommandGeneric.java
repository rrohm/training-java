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
public class PatternsCommandGeneric {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    CommandProcessor processor = new CommandProcessor();
    
    CommandA cA = new CommandA(new ItemA());
    CommandB cB = new CommandB(new ItemB());
    
    processor.processCommand(cA);
    processor.processCommand(cB);
    
  }
  
}
