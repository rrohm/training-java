/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.easymock.samples;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ClassTestedTest {
  
  public ClassTestedTest() {
  }
  
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
   * Test of setListener method, of class ClassTested.
   */
  @Test
  public void testSetListener() {
    System.out.println("setListener");
    Collaborator listener = null;
    ClassTested instance = new ClassTested();
    instance.setListener(listener);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of addDocument method, of class ClassTested.
   */
  @Test
  public void testAddDocument() {
    System.out.println("addDocument");
    String title = "";
    String content = "";
    ClassTested instance = new ClassTested();
    instance.addDocument(title, content);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of removeDocument method, of class ClassTested.
   */
  @Test
  public void testRemoveDocument() {
    System.out.println("removeDocument");
    String title = "";
    ClassTested instance = new ClassTested();
    boolean expResult = false;
    boolean result = instance.removeDocument(title);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of removeDocuments method, of class ClassTested.
   */
  @Test
  public void testRemoveDocuments() {
    System.out.println("removeDocuments");
    String[] titles = null;
    ClassTested instance = new ClassTested();
    boolean expResult = false;
    boolean result = instance.removeDocuments(titles);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
