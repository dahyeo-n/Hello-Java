import java.util.Scanner;

public class OperatorEx02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt(); // 10
    int number2 = scanner.nextInt(); // 8
    scanner.close();

    System.out.println();
    System.out.println("--- Before Operation ---");
    System.out.println("The value of the \"first\" input number is '" + number1 + "'."); // 10
    System.out.println("The value of the \"second\" input number is '" + number2 + "'."); // 8

    number2 += number1; // number2 = number2 + number1

    System.out.println();
    System.out.println("--- After Operation ---");
    System.out.println("The value of the \"first\" input number is '" + number1 + "'."); // 10
    System.out.println("The value of the \"second\" input number is '" + number2 + "'."); // 18
  }
}
