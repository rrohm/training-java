/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *  Copyright 2013 AEONIUM SOFTWARE SYSTEMS - ALL RIGHTS RESERVED.
 *
 *  The contents of this file are intellectual property of
 *  Aeonium Software Systems, Robert Rohm. All rights reserved.
 *  You must NOT, especially:
 *  - redistribute this file in source form,
 *  - redistribute this file in binary form,
 *  - modify this file,
 *  - use this file for your own work
 *  WITHOUT WRITTEN PERMISSION.
 *
 *  Anyway, we appreciate any interest in our work and knowledge.
 *  So, if you wish to use this file for your own purposes,
 *  please contact us:
 *  mailto:info@aeonium-systems.de
 *
 *
 *  © 2013 Aeonium Software Systems, Robert Rohm.
 */

package com.mycompany.maven03.logic;

import junit.framework.TestCase;

/**
 *
 * @author robert
 */
public class BusinessLogikTest extends TestCase {

  public BusinessLogikTest(String testName) {
    super(testName);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of average method, of class BusinessLogik.
   */
  public void testAverage() {
    System.out.println("average");
    int[] n = {1,2,0,1,2,0};
    BusinessLogik instance = new BusinessLogik();
    double expResult = 1.0;
    double result = instance.average(n);
    assertEquals(expResult, result, 0.0);
  }

}
