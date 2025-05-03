package ver1;

public class Person {

  // protected: 
  protected String name;
  protected int age;
  protected String phoneNumber;

  public Person() { }

  public Person(String name, int age, String phoneNumber) {
    this.name = name;
    this.age = age;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}