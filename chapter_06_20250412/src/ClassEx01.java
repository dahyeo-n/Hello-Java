import java.util.Scanner;

import ver1.Score;
import ver1.Student;

public class ClassEx01 {

  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    start();
  }

  public static void start() {
    Student student = inputStudent();
    scanner.close();

    student = setStudent(student);

    System.out.println();
    printStudent(student);
  }

  public static Student inputStudent() {
    Student student = new Student();
    
    System.out.print("Input name >> ");
    student.name = scanner.next();

    while (true) {
      System.out.print("Input grade(1~3) >> ");
      int grade = scanner.nextInt();

      if (grade >= 1 && grade <= 3) {
        student.grade = grade;
        break;
      }

      System.out.println("You input wrong grade.");
    }

    student.scores = new Score[getScoreLength(student.grade)];

    for (int i = 0; i < student.scores.length; i++)
      student.scores[i] = inputScore();

    return student;
  }

  public static Score inputScore() {
    Score score = new Score();

    scanner.nextLine();

    System.out.print("Input score subject >> ");
    score.subject = scanner.nextLine();

    while (true) {
      System.out.print("Input \"" + score.subject + "\" score (0~100) >> ");
      int value = scanner.nextInt();

      if (value >= 0 && value <= 100) {
        score.value = value;
        break;
      }

      System.out.println("You input wrong score.");
    }

    return score;
  }

  public static Student setStudent(Student student) {
    student.sumScore = 0;

    for (Score e : student.scores)
      student.sumScore += e.value;

    student.averageScore = (double)student.sumScore / student.scores.length;

    switch ((int)student.averageScore / 10) {
      case 10:
      case 9:
        student.rank = 'A';
        break;
      case 8:
        student.rank = 'B';
        break;
      case 7:
        student.rank = 'C';
        break;
      case 6:
        student.rank = 'D';
        break;
    }

    return student;
  }

  public static void printStudent(Student student) {
    System.out.println("name >> " + student.name);
    System.out.println("grade >> " + student.grade);

    for (Score e: student.scores)
      System.out.println("\"" + e.subject + "\" score >> " + e.value);

    System.out.println("sum of score >> " + student.sumScore);
    System.out.println("average of score >> " + student.averageScore);
    System.out.println("rank >> " + student.rank);
  }

  public static int getScoreLength(int grade) {
    switch (grade) {
      case 1: return 3;
      case 2: return 6;
      case 3: return 9;
      default: return 0;
    }
  }
}
