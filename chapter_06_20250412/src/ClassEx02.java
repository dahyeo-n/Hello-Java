import java.util.Scanner;

import utils.ScannerInputStream;
import ver2.Student;

public class ClassEx02 {

  public static void main(String[] args) {
    start();
  }

  public static void start() {
    Student student = inputStudent();
    ScannerInputStream.close();

    System.out.println();
    printStudent(student);
  }

  public static Student inputStudent() {
    Scanner scanner = ScannerInputStream.getInstance();

    System.out.print("Input name >> ");
    String name = scanner.next();

    int grade = 0;

    while (true) {
      System.out.print("Input grade (1~3) >> ");
      grade = scanner.nextInt();

      if (grade >= 1 && grade <= 3)
        break;

      System.out.println("You input wrong grade.");
    }

    Student student = new Student(name, grade);

    for (int i = 0; i < student.getScoreLength(); i++) {
      scanner.nextLine();

      System.out.print("Input score subject >> ");
      student.setScoreSubject(i, scanner.nextLine());
      student.setScoreValue(i, getScoreValue(student.getScoreSubject(i)));
    }

    return student;
  }

  public static int getScoreValue(String subject) {
    Scanner scanner = ScannerInputStream.getInstance();

    while (true) {
      System.out.print("Input \"" + subject + "\" score (0~100) >> ");
      int value = scanner.nextInt();

      if (value >= 0 && value <= 100) {
        return value;
      }

      System.out.println("You input wrong score.");
    }
  }

  public static void printStudent(Student student) {
    System.out.println("name >> " + student.getName());
    System.out.println("grade >> " + student.getGrade());

    for (int i = 0; i < student.getScoreLength(); i++) {
      System.out.println("\"" + student.getScoreSubject(i) + "\" score >> " + student.getScoreValue(i));
    }

    System.out.println("sum of score >> " + student.getSumScore());
    System.out.println("average of score >> " + student.getAverageScore());
    System.out.println("rank >> " + student.getRank());
  }

}
