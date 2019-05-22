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
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package java8.teil01.lambdas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Die Lambda-Syntax erlaubt mehrere Vereinfachungen.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Lambdas03_Syntax {

  public static void main(String[] args) {

    JButton button = new JButton("Ein Swing-Button");

    // Alte Form: Anonymer Listener
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button geklickt");
      }
    });

    // Lambda in Langform
    button.addActionListener((ActionEvent e) -> {
      System.out.println("Button geklickt");
    });

    // Kürzung 1: Parametertyp
    button.addActionListener((e) -> {
      System.out.println("Button geklickt");
    });

    // Kürzung 2: nur ein Parameter -> Runde Klammern
    button.addActionListener(e -> {
      System.out.println("Button geklickt");
    });

    // Kürzung 3: nur ein Ausdruck -> Geschweifte Klammern
    button.addActionListener(e -> System.out.println("Button geklickt"));

  }
}
