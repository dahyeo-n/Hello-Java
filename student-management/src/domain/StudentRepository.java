package domain;

public class StudentRepository {

  // 상태 관리는 'static'으로 안 함
  private Student[] students = new Student[10];

  public Student[] findAll() {
    Student[] students = new Student[this.checkStudentsLength()];

    for (int i = 0; i < students.length; i++) {
      students[i] = this.students[i];
    }

    return students;
  }

  public Student findByIndex(int index) {
    if (index < 0 || index > this.students.length)
      return null;

    return this.students[index];
  }

  public int save(Student student) {
    for (int i = 0; i < students.length; i++) {
      if (this.students[i] == null) {
        this.students[i] = student;
        return 1; // 저장 성공하면 '1' 반환
      }
    }

    return 0; // 저장 실패하면 '0' 반환
  }

  // public void updateStudent(Student student, String newName, int newScore) {
  //   // updateName
  //   if (newName != null) {
  //     student.setName(newName);
  //   }

  //   // updateGradeAndSubject
  //   // int 타입이라 null 체크를 못 해서 -1로 체크로 대체
  //   // if (newGrade != -1) {
  //   //   student.setGrade(newGrade);
  //   // }

  //   // updateScoresOnly
  //   if (newScore != -1) {
  //     for (int i = 0; i < student.getScoresLength(); i++) {
  //       String subject = student.getScoreSubject(i);
  //       student.setScore(i, subject, newScore);
  //     }
  //   }
  // }

  public void updateStudentName(Student student, String newName) {
    if (newName != null) {
      student.setName(newName);
    }
  }

  public void updateStudentGradeAndSubjects(Student student, int grade) {
    student.setGrade(grade);
  }

  public void updateStudentSubjectScore(Student student, int index, String subject, int score) {
    student.setScore(index, subject, score);
  }

  public boolean isExist(int index) {
    return index >= 0 && index <= this.students.length && students[index] != null;
  }

  private int checkStudentsLength() {
    int studentLength = 0;

    for (Student e: this.students) {
      if (e == null)
        return studentLength;

      studentLength++;
    }

    return studentLength;
  }

}
