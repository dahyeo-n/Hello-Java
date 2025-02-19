import java.util.Scanner;

public class OperatorEx03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt(); // 10
    int number2 = scanner.nextInt(); // 8
    scanner.close();

    System.out.println();
    System.out.println("--- Before Operation ---");
    System.out.println("The value of the \"first\" input number is '" + number1 + "'.");
    System.out.println("The value of the \"second\" input number is '" + number2 + "'.");

    // [🚨중요] 시험 문제일 수 있음
    // 전위 연산: 증감 연산이 적용된 후, 다음 연산 진행
    int result = ++number1 + number2;

    System.out.println();
    System.out.println("--- After Pre-Operation ---");
    System.out.println("The value of the \"first\" input number is '" + number1 + "'."); // 11
    System.out.println("The value of the \"second\" input number is '" + number2 + "'."); // 8
    System.out.println("The value of the \"result\" number is '" + result + "'."); // 19

    // 후위 연산: 다른 연산들이 적용된 후, 증감 연산 진행
    result = number1++ + number2; // ++의 위치에 따라 연산 우선순위가 달라짐

    System.out.println();
    System.out.println("--- After Post-Operation ---");
    System.out.println("The value of the \"first\" input number is '" + number1 + "'."); // 12
    System.out.println("The value of the \"second\" input number is '" + number2 + "'."); // 8
    System.out.println("The value of the \"result\" number is '" + result + "'."); // 19
  }
}
