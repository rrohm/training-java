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
package org.meins.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Diese Klasse wertet Annotationen mittels Reflection API aus.
 *
 * @author R. Rohm
 */
public class RFEAnnotationBspProcessor {

  public static void untersucheKlasse(Class klasse) {

    // Annotationen an der Methode
    System.out.println("Annotation in der Klasse");
    Annotation[] a = klasse.getAnnotations();
    for (int i = 0; i < a.length; i++) {
      Annotation aktuelleAnnotation = a[i];
      System.out.println(aktuelleAnnotation.toString());
    }

    // Annotationen an der Methode:
    Method[] methods = klasse.getMethods();
    for (int i = 0; i < methods.length; i++) {
      Method method = methods[i];
      System.out.println("Methode: " + method.getName());
      // Methode auf Annotationen untersuchen:

      if (method.isAnnotationPresent(RFEAnnotation.class)) {
        System.out.println(" - RFEAnnotation ");
        RFEAnnotation rfeAnnotation = method.getAnnotation(RFEAnnotation.class);

        String assignedTo = rfeAnnotation.assignedTo();
        System.out.println("Zugewiesen an: ".concat(assignedTo));
      }
    }
  }

  public static void main(String[] args) {

    // Der Klassentyp wird übergeben und untersucht:
    untersucheKlasse(BeispielKlasse.class);
  }
}
