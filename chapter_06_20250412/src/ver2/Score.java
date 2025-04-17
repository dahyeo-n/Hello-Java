package ver2;

public class Score {

  private String subject;
  private int value;

  public Score() { }

  public Score(String subject) {
    this.subject = subject;
  }

  public Score(String subject, int value) {
    this.subject = subject;
    this.value = value;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

}
