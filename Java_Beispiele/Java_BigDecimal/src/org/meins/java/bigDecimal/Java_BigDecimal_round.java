/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.bigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_BigDecimal_round {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    MathContext mc01UP = new MathContext(4, RoundingMode.UP);

    BigDecimal bd3 = BigDecimal.valueOf(3);

//    System.out.println(BigDecimal.ONE.divide(bd3).toPlainString());
    System.out.println(BigDecimal.ONE.divide(bd3, 1, RoundingMode.UP).toPlainString());
    System.out.println(BigDecimal.ONE.divide(bd3, mc01UP).toPlainString());

  }

}
