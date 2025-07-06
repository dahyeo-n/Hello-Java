package domain;

import java.util.ArrayList;
import java.util.List;

public class Student {

  // field: 직접 접근하지 않고 method로 접근해야 함 ('private'가 기본)
  // private String studentId; // 고유 번호가 있음
  private String name;
  private int grade;
  private List<Score> scores;
  private int sumScore;
  private double averageScore;
  private char rank;

  // constructor
  public Student(String name, int grade) {
    // this.studentId = UUID.randomUUID().toString();
    this.name = name;
    this.grade = grade;
    this.setScoresLength();
  }

  // cmd + . (quick start)
  // public String getStudentId() {
  //   return this.studentId;
  // }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return this.grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
    this.setScoresLength();
  }

  public String getScoreSubject(int index) {
    return this.scores.get(index).getSubject(); // 특정 인덱스의 과목명을 가져옴
  }

  public int getScoreValue(int index) {
    return this.scores.get(index).getValue(); // 특정 인덱스의 점수를 가져옴
  }

  public void setScoreValue(int index, int value) {
    this.scores.set(index, this.scores.get(index).updateValue(value));
    this.setSumScore();
  }

  public void setScore(int index, String subject, int value) {
    this.scores.set(index, new Score(subject, value));
    this.setSumScore();
  }

  public int getScoresLength() {
    return this.scores.size();
  }

  private void setScoresLength() {
    this.scores = new ArrayList<>();
    int size;
    
    switch (this.grade) {
      case 1:
        size = 3;
        break;
      case 2:
        size = 6;
        break;
      case 3:
        size = 9;
        break;
      default:
        size = 3;
    }

    // 빈 Score 객체로 초기화
    for (int i = 0; i < size; i++) {
      this.scores.add(null);
    }
  }

  public int getSumScore() {
    return this.sumScore;
  }

  private void setSumScore() {
    this.sumScore = 0;

    for (Score e : this.scores) {
      if (e == null) return;

      this.sumScore += e.getValue();
    }

    this.setAverageScore();
  }

  public double getAverageScore() {
    return this.averageScore;
  }

  private void setAverageScore() {
    this.averageScore = (double) this.sumScore / this.scores.size();
    this.setRank();
  }

  public char getRank() {
    return this.rank;
  }

    private void setRank() {
    switch ((int) this.averageScore / 10) {
      case 10:
      case 9:
        this.rank = 'A';
        break;
      case 8:
        this.rank = 'B';
        break;
      case 7:
        this.rank = 'C';
        break;
      case 6:
        this.rank = 'D';
        break;
      default:
        this.rank = 'F';
    }
  }

}
