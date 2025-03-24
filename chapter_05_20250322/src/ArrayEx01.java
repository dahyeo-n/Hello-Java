import java.util.Random;

public class ArrayEx01 {
  public static void main(String[] args) {
    Random random = new Random();
    final int MAX_RANDOM_NUMBER = 100;

    // array 선언: int type으로 heap 영역에서 10개의 data를 저장할 수 있는 40byte 공간 할당
    int[] numbers = new int[10];

    System.out.println("The count of numbers is \'" + numbers.length + "\'.");

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(MAX_RANDOM_NUMBER + 1);
    }

    // for (int e : numbers) { // NOTE: forEach문은 읽기만 가능하기 때문에 값을 바꾸는 건 불가
    //   e = random.nextInt(MAX_RANDOM_NUMBER + 1);
    // }

    System.out.print("Values of this array >> ");

    // for (int i = 0; i < numbers.length; i++) {
    //   System.out.print(numbers[i] + " "); // NOTE: 숫자 배열에 값을 할당하지 않으면 자동으로 0이 할당됨
    // }

    for (int e : numbers) {
      System.out.print(e + " ");
    }
  }
}
