import java.util.Random;

public class TwoDimensionalArrayEx {
  public static void main(String[] args) {
    Random random = new Random();

    final int MAX_RANDOM_NUMBER = 100;
    int[][] numbers = new int[2][3]; // 2차원 배열

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        numbers[i][j] = random.nextInt(MAX_RANDOM_NUMBER);
      }
    }

    System.out.println("--- Values of this array ---");

    for (int[] e : numbers) {
      for (int e2 : e) {
        System.out.print(e2 + " ");
      }

      System.out.println();
    }
  }
}
