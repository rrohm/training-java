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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.unittest;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

/**
 * Example for running data driven, parametrized tests.
 * (See https://github.com/junit-team/junit/wiki/Parameterized-tests)
 *
 * @author robert rohm
 */
@RunWith(Parameterized.class)
public class CalculatorTestDatadriven {

  /**
   * Define the test records (as 2-dimensional array), each tuple must contain
   * all test input parameters plus the expected result when running the test
   * with these parameters.
   *
   * @return The test data array
   */
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
//    // Hier auch denkbar: z.B. Test-Daten in Datei ausgelagert
//    Stream<String> lines = Files.lines(Paths.get("c:\input.csv"));
//    lines.forEach(new Consumer<String>() {
//
//        @Override
//        public void accept(String line) {
//            String[] split = line.split(";");
//        }
//    });
    return Arrays.asList(new Object[][]{
      // param a, param b, expected result
      {(byte) 0, (byte) 0, (byte) 0},
      {(byte) 1, (byte) 1, (byte) 2},
      {(byte) Integer.MAX_VALUE, (byte) 1, (byte) -1}
    });
  }

  /**
   * Diese privaten Felder sind zentral für den datengetriebenen Test mit JUnit: 
   * Für jeden Durchgang mit einem Datensatz muss vom Frameworl eine Instanz
   * dieser Klasse gebildet werden, die die Arbeitsdaten als Konstruktorparameter
   * übergeben bekommt. 
   */
  private final byte a;
  private final byte b;
  private final byte expected;

  public CalculatorTestDatadriven(byte a, byte b, byte expected) {
    this.a = a;
    this.b = b;
    this.expected = expected;
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
   * Test of add method, of class Calculator.
   */
  @Test
  public void testAdd() {
    System.out.printf("add %d + %d = %d \n", this.a, this.b, this.expected);
    //byte x = 0; // Hier nicht mehr verwendet - wir arbeiten hier datengetrieben!
    //byte y = 0; // Hier nicht mehr verwendet - wir arbeiten hier datengetrieben!
    Calculator instance = new Calculator();
    byte result = instance.add(this.a, this.b);
    assertEquals(this.expected, result);
  }
}
