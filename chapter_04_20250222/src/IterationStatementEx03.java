import java.util.Scanner;

public class IterationStatementEx03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number = 0;

    while (true) {
      System.out.print("Input number (1~) >> ");
      number = scanner.nextInt();

      if (number > 0)
        break;

      System.out.println("You input wrong number.");
    }

    scanner.close();

    int sum = 0;
    int maxNumber = number % 2 == 1 ? number - 1 : number;

    System.out.println();

    for (int i = 1; i <= maxNumber; i++) {
      if (i % 2 == 1)
        continue;

      sum += i;

      char operatorSymbol = i == maxNumber ? '=' : '+';
      System.out.print(i + " " + operatorSymbol + " ");
    }

    System.out.println(sum);
  }
}
