package domain;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

  // 상태 관리는 'static'으로 안 함
  private List<Student> students = new ArrayList<>();

  public Student[] findAll() {
    Student[] result = new Student[students.size()];
    for (int i = 0; i < students.size(); i++) {
      result[i] = students.get(i);
    }
    return result;
  }

  public Student findByIndex(int index) {
    if (index < 0 || index >= this.students.size())
      return null;

    return this.students.get(index);
  }

  public int save(Student student) {
    // 기존 코드처럼 빈 자리(null)을 찾을 필요 없음. 맨끝에 추가하면 돼서 for문 제거
    if (student == null) {
      return 0; // 저장 실패하면 '0' 반환
    }
    
    students.add(student);
    return 1; // 저장 성공하면 '1' 반환
  }

  public boolean deleteByIndex(int index) {
    if (index < 0 || index >= students.size()) {
      return false; // 삭제 실패
    }
    
    students.remove(index);
    return true; // 삭제 성공
  }

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
    return index >= 0 && index < this.students.size() && this.students.get(index) != null;
  }

  public int getStudentCount() {
    return students.size();
  }

}
