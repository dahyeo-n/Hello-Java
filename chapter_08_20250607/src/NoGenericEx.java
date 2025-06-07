public class NoGenericEx {

  public static void main(String[] args) {
    Box box1 = new Box();

    box1.setItem("Hello");
    System.out.println("[Box] " + box1);

    String word = (String) box1.getItem(); // 타입 Down 캐스팅
    System.out.println("[String] " + word);
  }

}

class Box {

  // 'Object'라는 클래스는 가장 최상단 **조상** 클래스
  private Object item;

  public Box() { }

  public Box(Object item) {
    this.item = item;
  }

  public Object getItem() {
    return this.item;
  }

  public void setItem(Object item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return item.toString(); // toString 커스텀
  }

}
