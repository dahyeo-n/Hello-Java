import java.util.Scanner;

public class OperatorEx04 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    double number1 = scanner.nextDouble(); // 4.5
    double number2 = scanner.nextDouble(); // 10
    scanner.close();

    System.out.println();
    System.out.println(number1 + " == " + number2 + "\t-> " + (number1 == number2)); // false
    System.out.println(number1 + " != " + number2 + "\t-> " + (number1 != number2)); // true
    System.out.println(number1 + " > " + number2 + "\t-> " + (number1 > number2)); // false
    System.out.println(number1 + " >= " + number2 + "\t-> " + (number1 >= number2)); // false
    System.out.println(number1 + " < " + number2 + "\t-> " + (number1 < number2)); // true
    System.out.println(number1 + " <= " + number2 + "\t-> " + (number1 <= number2)); // true
  }
}

// \t: tab처럼 작동