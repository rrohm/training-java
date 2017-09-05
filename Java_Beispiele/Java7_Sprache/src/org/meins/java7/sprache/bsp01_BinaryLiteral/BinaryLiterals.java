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
package org.meins.java7.sprache.bsp01_BinaryLiteral;

/**
 * Binäre Literale erlauben ab JDK 7 die direkte Eingabe von binären Werten.
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class BinaryLiterals {

// An 8-bit 'byte' value:
    byte aByte = (byte) 0b00100001;
// A 16-bit 'short' value:
    short aShort = (short) 0b1010000101000101;
// Some 32-bit 'int' values:
    int anInt1 = 0b10100001010001011010000101000101;
    int anInt2 = 0b101;
    int anInt3 = 0B101; // The B can be upper or lower case.
// A 64-bit 'long' value. Note the "L" suffix:
    long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

    /*  Binary literals can make relationships among data more apparent than they
     * would be in hexadecimal or octal. For example, each successive number in the
     * following array is rotated by one bit:
     *
     */
    public static final int[] phases = {
        0b00110001,
        0b01100010,
        0b11000100,
        0b10001001,
        0b00010011,
        0b00100110,
        0b01001100,
        0b10011000
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
