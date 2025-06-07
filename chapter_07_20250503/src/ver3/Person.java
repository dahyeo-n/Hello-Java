package ver3;

// 'implements' 키워드를 통해 확장
public class Person implements PersonInterface {

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

  @Override
  public void print() {
    System.out.println("person information");
  }

}
