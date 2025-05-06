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

  public void updateName(Student student, String newName) {
    studentRepository.updateName(student, newName);
  }

  public void updateGradeAndSubject(Student student, int newGrade, String newSubject) {
    studentRepository.updateGradeAndSubject(student, newGrade, newSubject);
  }

  public void updateScore(Student student, int newScore) {
    studentRepository.updateScoresOnly(student, newScore);
  }

  public int save(Student student) {
    return studentRepository.save(student);
  }

  public boolean isExist(int index) {
    return studentRepository.isExist(index);
  }
  
}
