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
package org.meins.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations werden als Interfaces mit vorangestelltem
 * \@ deklariert.
 *
 * Mit "Meta-Annotationen" wird das Verhalten und die Verwendung von
 * Annotationen näher definiert:
 *
 * \@Retention(RetentionPolicy.RUNTIME) bestimmt z.B., dass die Annotation auch
 * zur Laufzeit noch ausgewertet werden kann.
 *
 * \@Target(ElementType.METHOD) bestimmt z.B. dass die Annotation nur auf
 * Methoden angewendet werden kann.
 *
 * \@author R. Rohm
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface RFEAnnotation {

  /**
   * Ticket-ID für den RFE
   */
  int id();

  /**
   * Beschreibung/Zusammenfassung
   */
  String synopsis();

  /**
   * Wer soll sich darum kümmern:
   */
  String assignedTo() default "[unassigned]";
  /*
   * Einschränkungen:
   * - Rückgabetypen sind beschränkt auf String, Class, enums und arrays sowie primitive Typen
   * - Methoden dürfen keine Parameter haben
   *
   *  Methoden dürfen jedoch default-Werte haben.
   */
}
