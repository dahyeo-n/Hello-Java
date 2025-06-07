package start;

import ver1.Person;
import ver1.Student;
import ver1.Teacher;

public class InheritEx02 {

  public static void main(String[] args) {
    // Up Casting
    Person person = new Student("sss", 19, "010-0000-0000");

    person.setAge(18);

    Teacher teacher1 = new Teacher();

    // 모두 true
    System.out.println(person instanceof Person);
    System.out.println(person instanceof Student);
    System.out.println(teacher1 instanceof Teacher);
    System.out.println(teacher1 instanceof Student);
    System.out.println(teacher1 instanceof Person);

    teacher1 = null;

    System.out.println(teacher1 instanceof Teacher); // false
    System.out.println(person instanceof Teacher); // false

  }

}
