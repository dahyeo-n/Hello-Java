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

  public Student[] updateName(Student student) {
    return studentRepository.updateName(student);
  }

  public Student[] updateGradeAndSubject() {
    return studentRepository.updateGradeAndSubject(null, 0, null);
  }

  public Student[] updateScore() {
    return studentRepository.updateScore(null)
  }

  public int save(Student student) {
    return studentRepository.save(student);
  }

  public boolean isExist(int index) {
    return studentRepository.isExist(index);
  }
  
}
