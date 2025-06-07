package start;

import ver2.Person;
import ver2.Student;

public class InheritEx03 {

  public static void main(String[] args) {
    Person person1 = new Student();
    person1.print(); // 가리키는 건 Person, 내용물은 Student

    Person person2 = new Person() { // 이 중괄호 자체도 Person의 자식 클래스 (단지 이름이 없을 뿐)
      // Overriding은 구현체 내에서 작성하든 설계체 내에서 작성하든 차이가 없음
      @Override
      public void print() {
        System.out.println("person2 학생 정보 출력");
      }
    };

    person2.print(); // person2 학생 정보 출력
  }

}
