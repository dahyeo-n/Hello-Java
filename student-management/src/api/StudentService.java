package api;

import domain.Student;
import domain.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository = new StudentRepository();

  public Student[] findAll() {
    return studentRepository.findAll();
  }

  public Student findByIndex(int index) {
    return studentRepository.findByIndex(index);
  }

  public void updateStudentName(Student student, String newName) {
    studentRepository.updateStudentName(student, newName);
  }

  public void updateStudentGradeAndSubjects(Student student, int grade) {
    studentRepository.updateStudentGradeAndSubjects(student, grade);
  }

  public void updateStudentSubjectScore(Student student, int index, String subject, int score) {
    studentRepository.updateStudentSubjectScore(student, index, subject, score);
  }

  public int save(Student student) {
    return studentRepository.save(student);
  }

  public boolean deleteByIndex(int index) {
    return studentRepository.deleteByIndex(index);
  }

  public boolean isExist(int index) {
    return studentRepository.isExist(index);
  }

  public int getStudentCount() {
    return studentRepository.getStudentCount();
  }

}
