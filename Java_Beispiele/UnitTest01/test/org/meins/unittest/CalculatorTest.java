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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test-Klasse zum Calculator - sie fasst alle Testfälle zu allen Methoden
 * zusammen. Geprüft werden muss aber generell:
 * <ul>
 * <li>Reguläres Verhalten (Verhalten bei Input im erwarteten Wertebereich)</li>
 * <li>Verhalten bei Exceptions? Werden diese überhaupt/korrekt geworfen?</li>
 * <li>"Smoke Test" - Verhalten bei bewusst "böswilliger" Benutzung (siehe auch
 * "DAU!)</li>
 * <li>Verhalten an den Grenzen des gültigen Wertebereichs</li>
 * <li>Verhalten außerhalb des gültigen Wertebereichs</li>
 * <li>Verhalten bei fehlendem Input</li>
 * <li>Verhalten bei falschem Input</li>
 * </ul>
 * <p>
 * Generell soll in einer Test-Methode nur ein "point of failure", d.h., ein zu
 * testender Aspekt implementiert werden. </p>
 *
 * @author robert
 */
public class CalculatorTest {

    public CalculatorTest() {
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
     * Erste Tests der multiply-Methode.
     */
    @Test
    public void testMultiply00() throws ByteOverflowException {
        System.out.println("multiply");
        byte x = 0;
        byte y = 0;
        Calculator instance = new Calculator();
        byte expResult = 0;
        byte result = instance.multiply(x, y);
        assertEquals(expResult, result);
    }

    /**
     * This test method illustrates the "traditional style" of testing a given
     * exception to be throwen or not.
     */
    @Test
    public void testMultiplyOverflow() {
        System.out.println("testMultiplyOverflow");
        byte x = Byte.MAX_VALUE;
        byte y = 2;
        Calculator instance = new Calculator();
        byte expResult = 0;
        byte result;

        try {
            result = instance.multiply(x, y);
            fail("KEINE ByteOverflowException geworfen!");
        } catch (ByteOverflowException ex) {
            assertTrue("ByteOverflowException geworfen, OK.", true);
        }
    }

    /**
     * In JUnit 4 you may use a more convenient way for testing whether a given
     * exception is throwen - you annotate it at the method.
     *
     * @throws ByteOverflowException
     */
    @Test(expected = ByteOverflowException.class)
    public void testMultiplyOverflowThrowing() throws ByteOverflowException {
        System.out.println("testMultiplyOverflowThrowing");
        byte x = Byte.MAX_VALUE;
        byte y = 2;
        Calculator instance = new Calculator();
        byte expResult = 0;
        byte result;

        result = instance.multiply(x, y);
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Ignore("Example of an ignored case - do NOT use this to disable failing test!")
    @Test
    public void testDivide() {
        System.out.println("divide");
        byte x = 0;
        byte y = 0;
        Calculator instance = new Calculator();
        byte expResult = 0;
        byte result = instance.divide(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        byte x = 0;
        byte y = 0;
        Calculator instance = new Calculator();
        byte expResult = 0;
        byte result = instance.add(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
