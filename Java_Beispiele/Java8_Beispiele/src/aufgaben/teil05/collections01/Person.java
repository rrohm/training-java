package aufgaben.teil05.collections01;

  /**
 * Beispielklasse zur Modellierung einer Person.
 *
 * @author R. Rohm,
 *
 */
public class Person {

  private String firstname;
  private String lastname;
  private int age;
  private Gender gender;

  public Person() {
  }
  
  public Person(String firstname, String lastname, int age, Gender gender) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
    this.gender = gender;
  }

  
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
