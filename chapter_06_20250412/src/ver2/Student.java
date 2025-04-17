package ver2;

public class Student {

  private String name;
  private int grade;
  private Score[] scores;
  private int sumScore;
  private double averageScore;
  private char rank;

  public Student() { }

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
    this.setScoreLength();
  }

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
    this.setScoreLength();
  }

  public int getScoreLength() {
    return this.scores.length;
  }

  private void setScoreLength() {
    switch (this.grade) {
      case 1: this.scores = new Score[3]; break;
      case 2: this.scores = new Score[6]; break;
      case 3: this.scores = new Score[9]; break;
      default: this.scores = new Score[3];
    }

    for (int i = 0; i < this.scores.length; i++) {
      this.scores[i] = new Score();
    }
  }

  public String getScoreSubject(int index) {
    return this.scores[index].getSubject();
  }

  public void setScoreSubject(int index, String subject) {
    this.scores[index].setSubject(subject);
  }

  public int getScoreValue(int index) {
    return this.scores[index].getValue();
  }

  public void setScoreValue(int index, int value) {
    this.scores[index].setValue(value);
    this.setSumScore();
  }

  public int getScoreValue(String subject) {
    for (Score e: this.scores) {
      if (e.getSubject().equals(subject)) {
        return e.getValue();
      }
    }
    
    return -1;
  }

  public void setScoreValue(String subject, int value) {
    for (int i = 0; i < this.scores.length; i++) {
      if (this.scores[i].getSubject().equals(subject)) {
        this.scores[i].setValue(value);
      }
    }
    this.setSumScore();
  }

  public int getSumScore() {
    return this.sumScore;
  }

  private void setSumScore() {
    this.sumScore = 0;

    for (Score e: this.scores)
      this.sumScore += e.getValue();

    this.setAverageScore();
  }

  public double getAverageScore() {
    return this.averageScore;
  }

  private void setAverageScore() {
    this.averageScore = (double)this.sumScore / this.scores.length;
    this.setRank();
  }

  public char getRank() {
    return this.rank;
  }

  private void setRank() {
    switch ((int)this.averageScore / 10) {
      case 10:
      case 9: this.rank = 'A'; break;
      case 8: this.rank = 'B'; break;
      case 7: this.rank = 'C'; break;
      case 6: this.rank = 'D'; break;
      default: this.rank = 'F';
    }
  }

}
