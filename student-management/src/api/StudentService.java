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

  public void updateStudent(Student student, String newName, int newScore) {
    studentRepository.updateStudent(student, newName, newScore);
  }

  public int save(Student student) {
    return studentRepository.save(student);
  }

  public boolean isExist(int index) {
    return studentRepository.isExist(index);
  }

}
