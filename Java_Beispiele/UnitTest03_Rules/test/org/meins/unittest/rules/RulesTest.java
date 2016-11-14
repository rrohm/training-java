/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.unittest.rules;

import org.junit.rules.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class RulesTest {
  
  public RulesTest() {
  }
  
  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();
  
  @Rule
  public TestName name = new TestName();

  @Rule
  public TestRule globalTimeout = new Timeout(20);
  
  @Rule
  public ExpectedException thrown= ExpectedException.none();
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of main method, of class Rules.
   */
  @Test
  public void testMain() {
    System.out.println("main");
    String[] args = null;
    Rules.main(args);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
