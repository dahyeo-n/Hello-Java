package ver2;

public class Student extends Person {

  private int grade;
  private Score[] scores;
  private int sum;
  private double average;
  private char rank;

  /*
   * ✅ Project
   * 1. 학생 관리 프로그램의 DB 연동 버전을 시험 결과물로 봄 (프로젝트 형식 / CRUD)
   * 2. 제시한 기능 외에 다른 부가적인 기능도 알아서 추가해야 함 (가산점 요소)
   * 
   * 🚨 참고: 직접 사용해 보고 문제 없는지 테스트함. 버그 있으면 감점됨
   * 
   * ✨👉🏻 이게 되면 Back-end를 시작할 준비가 된 거임
   */

  public Student() { }

  public Student(String name, int age, String phoneNumber) {
    super(name, age, phoneNumber); // 부모 생성자 호출 ('this'는 자기 자신 생성자)
    this.setGrade();
  }

  @Override
  public void setAge(int age) {
    super.setAge(age);
    this.setGrade();
  }

  public int getGrade() {
    return this.grade;
  }

  private void setGrade() {
    switch (super.age) {
      case 17: this.grade = 1; break;
      case 18: this.grade = 2; break;
      case 19: this.grade = 3; break;
      default: this.grade = 1;
    }

    this.setScoresLength();
  }

  public int getScoresLength() {
    return this.scores.length;
  }

  private void setScoresLength() {
    switch (this.grade) {
      case 1: this.scores = new Score[3]; break;
      case 2: this.scores = new Score[6]; break;
      case 3: this.scores = new Score[9]; break;
      default: this.scores = new Score[3];
    }
  }

  public String getScoreSubject(int index) {
    return this.scores[index].getSubject();
  }

  public void setScoreSubject(int index, String newSubject) {
    this.scores[index].setSubject(newSubject);
  }

  public int getScoreValue(int index) {
    return this.scores[index].getValue();
  }

  public void setScoreValue(int index, int newValue) {
    this.scores[index].setValue(newValue);
    this.setSum();
  }

  public void setScore(int index, String subject, int value) {
    this.scores[index].setSubject(subject);
    this.scores[index].setValue(value);
    this.setSum();
  }

  public int getSum() {
    return this.sum;
  }

  private void setSum() {
    this.sum = 0;

    for (int i = 0; i < this.scores.length; i++) {
      this.sum += this.scores[i].getValue();
    }

    this.setAverage();
  }

  public double getAverage() {
    return this.average;
  }

  private void setAverage() {
    this.average = (double) this.sum / this.scores.length;
    this.setRank();
  }

  public char getRank() {
    return this.rank;
  }

  private void setRank() {
    switch ((int) this.average / 10) {
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

  @Override
  public void print() {
    System.out.println("학생 정보 출력");
  }

}
