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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.javastrings;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Chars {
  
  public static void main(String[] args) {
    
    // A primitive char
    char a = 'a';
    // A char Wrapper object
    Character b = new Character('b');
    
    System.out.println("Unicode values: ");
    System.out.println("Character.getNumericValue(0) = " + Character.getNumericValue('0'));
    System.out.println("Character.getNumericValue(1) = " + Character.getNumericValue('1'));
    System.out.println("Character.getNumericValue(2) = " + Character.getNumericValue('2'));
    System.out.println("Character.getNumericValue(4) = " + Character.getNumericValue('4'));
    System.out.println("Character.getNumericValue(5) = " + Character.getNumericValue('5'));
    System.out.println("Character.getNumericValue(6) = " + Character.getNumericValue('6'));
    System.out.println("Character.getNumericValue(7) = " + Character.getNumericValue('7'));
    System.out.println("Character.getNumericValue(8) = " + Character.getNumericValue('8'));
    System.out.println("Character.getNumericValue(9) = " + Character.getNumericValue('9'));
    System.out.println("Character.getNumericValue(a) = " + Character.getNumericValue('a'));
    System.out.println("Character.getNumericValue(b) = " + Character.getNumericValue('b'));
    System.out.println("Character.getNumericValue(c) = " + Character.getNumericValue('c'));
    System.out.println("Character.getNumericValue(d) = " + Character.getNumericValue('d'));
    System.out.println("Character.getNumericValue(e) = " + Character.getNumericValue('e'));
    System.out.println("Character.getNumericValue(f) = " + Character.getNumericValue('f'));
    System.out.println("Character.getNumericValue(g) = " + Character.getNumericValue('g'));
    System.out.println("Character.getNumericValue(h) = " + Character.getNumericValue('h'));
    System.out.println("Character.getNumericValue(i) = " + Character.getNumericValue('i'));
    System.out.println("Character.getNumericValue(j) = " + Character.getNumericValue('j'));
    System.out.println("Character.getNumericValue(k) = " + Character.getNumericValue('k'));
    System.out.println("Character.getNumericValue(a) = " + Character.getNumericValue('a'));
    
//    Character.getName(numericValue)
  }
}
