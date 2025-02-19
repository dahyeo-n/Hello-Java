import java.util.Scanner;

public class OperatorEx06 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt(); // 10
    int number2 = scanner.nextInt(); // 8
    scanner.close();

    int maxNumber = number1 > number2 ? number1 : number2;

    System.out.println();
    System.out.println("The value of \"max\" number is \'" + maxNumber + "\'."); // 10
  }
}
