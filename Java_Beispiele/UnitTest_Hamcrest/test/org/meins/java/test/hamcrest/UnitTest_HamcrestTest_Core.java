/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 * 
 *  You are free to:
 * 
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 * 
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 * 
 *  Under the following terms:
 * 
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 * 
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 * 
 *
 *  2016 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.test.hamcrest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class UnitTest_HamcrestTest_Core {
  
  public UnitTest_HamcrestTest_Core() {
  }

  /**
   * Test whether all of the given matchers return <code>true</code>. 
   */
  @Test
  public void allOf_allMatchersMustBeTrue() {
    System.out.println("main");
    
    String value = "Hello World!";
    
    assertThat(value, allOf(notNullValue(), instanceOf(String.class)));
  }
  

  /**
   * Test whether the test candidate is a(ny) subclass if the given type.
   */
  @Test
  public void any_mustBeAnySubtype() {
    System.out.println("main");
    
    Double value = 123.5;
    
    assertThat(value, any(Number.class));
  }
  
  /**
   * Test whether at least one of the matchers is true.  
  */
  @Test
  public void anyOf_atLeastOneMatcherMustBeTrue() {
    System.out.println("main");
    
    String value = "Hello World!";
    
    assertThat(value, anyOf(notNullValue(), instanceOf(Number.class)));
  }
  
  
  
  
}
