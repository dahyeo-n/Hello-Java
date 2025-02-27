import java.util.Scanner;

public class ConditionalStatementEx01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    scanner.close();

    System.out.println();
    // System.out.println(number1 + ", " + number2);

    if (number1 == number2) {
      System.out.println("Values of \"first\" number and \"second\" number is same each other.");
    } else if (number1 > number2) {
      System.out.println("Value of \"first\" number is bigger than value of \"second\" number.");
    } else {
      System.out.println("Value of \"first\" number is smaller than value of \"second\" number.");
    }
  }
}
