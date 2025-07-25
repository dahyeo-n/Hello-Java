package ver1;

public class Person {

  // protected: (접근제어자) 나뿐만 아니라 자식도 쓸 수 있도록 함
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