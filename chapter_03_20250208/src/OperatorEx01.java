import java.util.Scanner;

public class OperatorEx01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    scanner.close();

    System.out.println();
    System.out.println(number1 + " + " + number2 + " -> " + (number1 + number2));
    System.out.println(number1 + " - " + number2 + " -> " + (number1 - number2));
    System.out.println(number1 + " * " + number2 + " -> " + (number1 * number2));
    System.out.println(number1 + " / " + number2 + " -> " + (number1 / number2));
    System.out.println(number1 + " % " + number2 + " -> " + (number1 % number2));
  }
}

// [중요] 요구사항 먼저 분석하고 코드 작성

/*
 * Input first number >> 5
 * Input second number >> 7
 * 
 * You input '5' and '7'.
 */

/*
 * Input two numbers >> 5 7
 * 
 * You input '5' and '7'.
 */

/*
 * Input two numbers >> 5 7
 * 
 * 5 + 7 -> 12
 * 5 - 7 -> -2
 * 5 * 7 -> 35
 * 5 / 7 -> 0
 * 5 % 7 -> 5
 */