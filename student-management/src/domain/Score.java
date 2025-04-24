package domain;

public class Score {

  private String subject;
  private int value;

  public Score(String subject) {
    this.subject = subject;
  }

  public Score(String subject, int value) {
    this.subject = subject;
    this.value = value;
  }

  public String getSubject() {
    return this.subject; // 'this' 붙이는 게 가독성에 좋음
  }

  public int getValue() {
    return this.value;
  }

  public Score updateValue(int value) {
    this.value = value;
    return this; // 나 자신을 return
  }

}
