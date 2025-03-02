import java.util.Scanner;

public class IterationStatementEx02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SUM_NUMBER = 100;

    int sum = 0;
    int totalCount = 0;

    while (sum < MAX_SUM_NUMBER) {
      System.out.print("Input number >> ");
      int number = scanner.nextInt();

      System.out.print(sum + " + " + number + " = ");

      sum += number;
      totalCount++;

      System.out.println(sum + "\n");
    }

    scanner.close();

    System.out.println("Total \'" + totalCount + "\' calculations were made.");
  }
}
