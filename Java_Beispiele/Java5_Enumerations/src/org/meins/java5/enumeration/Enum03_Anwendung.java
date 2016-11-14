/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java5.enumeration;

/**
 * Diese Anwendung illustriert die Verwendung von erweiterten Enums.
 *
 * @author R. Rohm
 */
public class Enum03_Anwendung {

    public static void main(String[] args) {
 
        // Verwendung z.b: in einer lokalen Variablen
        Enum03_ErweiterteEnum wert = Enum03_ErweiterteEnum.M_MUSTERMANN;
        System.out.println("Zugriff auf Eigenschaften des Enum-Werts:");
        System.out.println("Name   : " + wert.getName());
        System.out.println("Vorname: " + wert.getVorname());
        System.out.println("Alter  : " + wert.getAlter());
        
    }
}
