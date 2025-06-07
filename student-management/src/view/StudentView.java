package view;

import java.util.Scanner;

import api.StudentService;
import domain.Student;
import view.utils.ScannerInputStream;

public class StudentView {

  private final StudentService studentService = new StudentService();

  public void start() {
    while (true) {
      this.printGuideLine();

      System.out.println();

      Scanner scanner = ScannerInputStream.getInstance();
      System.out.print("Input number (1~5) >> ");

      int programNumber = scanner.nextInt();
      System.out.println();  

      switch (programNumber) {
        case 1: this.inputStudent(); break;
        case 2: this.updateStudentByIndex(); break;
        case 3: this.printStudentByIndex(); break;
        case 4: this.printAllStudents(); break;
        case 5: this.exitProgram(); return;
        default: System.out.println("You input wrong number.");
      }

      System.out.println();
    }
  }

  private void printGuideLine() {
    System.out.println("--- Student Management Program GuideLine ---\n");
    System.out.println("1. Input student");
    System.out.println("2. Update student by student's index");
    System.out.println("3. Print student by student's index");
    System.out.println("4. Print all students");
    System.out.println("5. Exit program");
  }

  // ✨ 재사용할 수 있도록 분리하는 게 좋음 (객체 지향)
  private void inputStudent() {
    Scanner scanner = ScannerInputStream.getInstance();

    System.out.println("--- Input student ---\n");

    while (true) {
      System.out.print("Input student's name (without spaces) >> ");
      String name = scanner.next();

      System.out.println();
      int grade = inputGrade(name, 1, 3);

      Student student = new Student(name, grade);
      int studentScoreLength = student.getScoresLength();

      for (int i = 0; i < studentScoreLength; i++) {
        scanner.nextLine();

        System.out.print("\n[" + (i + 1) + "/" + studentScoreLength + "] Input subject name >> ");
        String subject = scanner.nextLine();

        int score = inputScore(subject, 0, 100);
        student.setScore(i, subject, score);
      }

      System.out.print("\nHave you entered all the student's information correctly ([y]/n) >> ");

      String isCorrect = scanner.next();

      if (isCorrect.equals("y")) {
        int isSaved = studentService.save(student);

        if (isSaved == 1) {
          return;
        } else if (isSaved == 0) {
          System.out.println("An unknown error occurred.");
        }
      }
    }
  }

  private void printStudentByIndex() {
    Scanner scanner = ScannerInputStream.getInstance();

    System.out.println("--- Print student by index ---\n");

    System.out.print("Input index >> ");
    int index = scanner.nextInt() - 1;

    System.out.println();

    Student student = studentService.findByIndex(index);

    if (student != null) {
      this.printStudent(student);
    } else {
      System.out.println("No students are registered in the index.");
    }
  }

  private void printAllStudents() {
    System.out.println("--- Print all students ---");
    Student[] students = studentService.findAll();

    if (students.length == 0) {
      System.out.println("\nNo students are registered.");
      return;
    }

    for (int i = 0; i < students.length; i++) {
      System.out.println("\n-- [" + (i + 1) + "/" + students.length + "] student --");
      this.printStudent(students[i]);
    }
  }

  /*
   * "What information would you like to change? (name: 1, grade: 2, score of subject: 3)  >> "
   * 번호 잘못 입력 시, 오류 문구 ("Please enter a number from 1 to 3.") 출력
   * 
   * (0) 학생의 인덱스를 입력 받고, 해당 인덱스에 맞는 학생의 정보 수정
   * 
   * (1) name
   * : 해당 학생의 이름 수정
   * 
   * (2) grade
   * : 같은 학년이든 다른 학년이든 전부 재입력 받음 (모든 점수, 과목명)
   * 
   * (3) score of subject
   * : 각 과목명에 따른 점수 재입력 받음. 안 바꾼다고 하면 다음 과목으로 넘어감
   * 
   * [최종] 변경된 student 정보 저장 (save) → 저장 결과 보여주기
   */

  private void updateStudentByIndex() {
    // 등록된 학생이 1명도 없으면(0번째 인덱스의 학생) 해당 method 실행 안 함
    if (!studentService.isExist(0)) {
      System.out.println("❌ No students are registered.");
      return;
    }

    this.printAllStudents();

    Scanner scanner = ScannerInputStream.getInstance();
    System.out.print("\nEnter the index of the student whose information you want to modify >> ");
    int index = scanner.nextInt() - 1;
    System.out.println();

    // 해당 인덱스의 학생이 존재하는지 확인
    if (!studentService.isExist(index)) {
      System.out.println("❌ No students are registered in the index.");
      return;
    }

    // 수정할 학생의 인덱스를 저장한 뒤, 그걸 기준으로 학생의 정보 수정
    Student student = studentService.findByIndex(index);
    this.printStudent(student);

    String newName = null;

    // 수정할 field 선택 후 처리
    while (true) {
      System.out.print("\nWhat information would you like to change? (name: 1, grade: 2, score of subject: 3) >> ");
      int choseNumber = scanner.nextInt();

      switch (choseNumber) {
        case 1:
          System.out.print("\nInput name to update (without spaces) >> ");
          newName = scanner.next();
          studentService.updateStudentName(student, newName);
          break;

        case 2:
          int newGrade = inputGrade(student.getName(), 1, 3);
          studentService.updateStudentGradeAndSubjects(student, newGrade);

          // 기존 과목 수만큼 새로 입력
          for (int i = 0; i < student.getScoresLength(); i++) {
            scanner.nextLine();
            System.out.print("\n[" + (i + 1) + "/" + student.getScoresLength() + "] Input subject name >> ");
            String subject = scanner.nextLine();
            int score = inputScore(subject, 0, 100);
            studentService.updateStudentSubjectScore(student, i, subject, score);
          }
          break;

        case 3:
          // 과목 점수만 update
          for (int i = 0; i < student.getScoresLength(); i++) {
            String subject = student.getScoreSubject(i);
            System.out.print("\n\"" + subject + "\" Do you update student scores? (y/n) >> ");
            String answer = scanner.next();
            System.out.println();

            // 안 바꾼다고 하면 다음 과목으로 넘어감
            if (answer.equals("n"))
              continue;

            int score = inputScore(subject, 0, 100);
            studentService.updateStudentSubjectScore(student, i, subject, score);
          }
          break;

        default:
          System.out.println("You input wrong number.");
          continue;
      }

      System.out.println("\n✅ Student information has been updated.");
      System.out.println("\n--- Updated student's information ---\n");
      this.printStudent(student); // 저장 결과 보여줌
      break;
    }
  }

  private void printStudent(Student student) {
    System.out.println("name: " + student.getName());
    System.out.println("grade: " + student.getGrade());

    int studentScoreLength = student.getScoresLength();

    for (int j = 0; j < studentScoreLength; j++) {
      System.out.println("\"" + student.getScoreSubject(j) + "\" score: " + student.getScoreValue(j));
    }

    System.out.println("sum: " + student.getSumScore());
    System.out.println("average: " + student.getAverageScore());
    System.out.println("rank: " + student.getRank());
  }

  private int inputGrade(String name, int minGrade, int maxGrade) {
    Scanner scanner = ScannerInputStream.getInstance();
    int grade;

    while (true) {
      System.out.print("Input " + name + "'s grade (" + minGrade + "~" + maxGrade + ") >> ");
      grade = scanner.nextInt();

      if (grade >= minGrade && grade <= maxGrade) {
        System.out.println(name + "'s grade is '" + grade + "'.");
        return grade;
      }

      System.out.println("You input wrong grade.");
    }
  }

  private int inputScore(String subject, int minScore, int maxScore) {
    Scanner scanner = ScannerInputStream.getInstance();
    int score;

    while (true) {
      System.out.print(subject + " score (" + minScore + "~" + maxScore + ") >> ");
      score = scanner.nextInt();

      if (score >= minScore && score <= maxScore) {
        return score;
      }

      System.out.println("You input wrong score.");
    }
  }

  private void exitProgram() {
    ScannerInputStream.close();
  }

}
