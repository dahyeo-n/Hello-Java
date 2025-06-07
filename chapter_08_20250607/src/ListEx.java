import java.util.ArrayList;
import java.util.List;

public class ListEx {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(); // 'LinkedList'로도 해보기

    list.add(3);
    list.add(5);
    list.add(9);

    System.out.println(list.size());

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2)); // 라이브러리를 분석하는 것도 좋은 방법! 👍🏻✨

    list.set(0, 6);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));

    list.remove(0);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2)); // Error
  }

}
