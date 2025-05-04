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

  // NOTE: update 로직을 하나로 만들고, '바뀌는 Field'만 변경하도록 수정하는 게 요청을 줄일 수 있고 재사용성이 좋음
  public void updateName(Student student, String newName) {
    student.setName(newName);
  }

  public void updateGradeAndSubject(Student student, int newGrade, String newSubject) {
    student.setGrade(newGrade);

    for (int i = 0; i < student.getScoresLength(); i++) {
      student.setScore(i, newSubject, newGrade);
    }
  }

  public void updateScore(Student student, int newScore) {
    for (int i = 0; i < student.getScoresLength(); i++) {
      String subject = student.getScoreSubject(i);
      student.setScore(i, subject, newScore);
    }
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
