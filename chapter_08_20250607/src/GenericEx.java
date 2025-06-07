public class GenericEx {

  public static void main(String[] args) {
    GenericBox<String> box1 = new GenericBox<>(); // new GenericBox<String>() 으로 작성해도 되나, 타입 생략 가능

    // Generic을 사용하면 '컴파일 타임'에서 오류를 잡아줌
    box1.setItem("Hello");
    System.out.println("[Box] " + box1);

    String word = box1.getItem();
    System.out.println("[String] " + word);
  }

}

// 패키지가 같은데 이름도 같으면 '빌드 에러' 뜸
class GenericBox<T> { // <T>는 타입 변수 ('T' 아니어도 됨)

  private T item;

  public GenericBox() { }

  public GenericBox(T item) {
    this.item = item;
  }

  public T getItem() {
    return this.item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return item.toString(); // toString 커스텀
  }

}
