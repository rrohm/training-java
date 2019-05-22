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
package java8.teil09.streams.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Beispiel-Datenklasse "Person", hier etwas vereinfacht, mit Name, Geschlecht
 * und dem alter als Integer-Wert.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Person {

  static List<Person> createData() {
    return Arrays.asList(
            new Person("M. Mustermann", 40, Person.Gender.MALE),
            new Person("A. Lyse", 30, Person.Gender.FEMALE),
            new Person("K. Käfer", 20, Person.Gender.MALE),
            new Person("P. Mustermann", 40, Person.Gender.FEMALE)
    );
  }
  
  
  public static int compareByAge(Person p1, Person p2){
    return Integer.compare(p1.getAge(), p2.getAge());
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public enum Gender {
    FEMALE, MALE
  }

  private String name;
  private int age;
  private Gender gender;

  public Person(String name, int age, Gender gender) {
    Objects.requireNonNull(name, "Name darf nicht null sein.");

    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return new StringBuilder(this.name)
            .append(", ")
            .append(this.age)
            .append(" (")
            .append(this.gender)
            .append(")")
            .toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
