package start;

import ver1.Person;
import ver1.Student;

public class InheritEx01 {

  public static void main(String[] args) {
    Person person1 = new Person("DDD", 19, "010-0000-0000");

    // --- 출력 ---
    System.out.println(person1.getName());
    System.out.println(person1.getAge());
    System.out.println(person1.getPhoneNumber());
    System.out.println();

    Person person2 = new Person();

    person2.setName("HHH");
    person2.setAge(17);
    person2.setPhoneNumber("010-1111-1111");

    // --- 출력 ---
    System.out.println(person2.getName());
    System.out.println(person2.getAge());
    System.out.println(person2.getPhoneNumber());
    System.out.println();

    Student student1 = new Student("JJJ", 18, "010-2222-2222");

    // --- 출력 ---
    System.out.println(student1.getName());
    System.out.println(student1.getAge());
    System.out.println(student1.getPhoneNumber());

    System.out.println(student1.getGrade());
    System.out.println(student1.getScoresLength());
    System.out.println();

    Student student2 = new Student();

    student2.setName("AAA");
    student2.setAge(17);
    student2.setPhoneNumber("010-3333-3333");
    
    // --- 출력 ---
    System.out.println(student2.getName());
    System.out.println(student2.getAge());
    System.out.println(student2.getPhoneNumber());

    System.out.println(student2.getGrade());
    System.out.println(student2.getScoresLength());
    System.out.println();
  }

}
