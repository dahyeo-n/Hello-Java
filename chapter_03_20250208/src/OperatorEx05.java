import java.util.Scanner;

public class OperatorEx05 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two numbers >> ");
    double number1 = scanner.nextDouble(); // 17
    double number2 = scanner.nextDouble(); // 19
    scanner.close();

    boolean result = number1 != number2 && number1 > number2;
    System.out.println();
    System.out.println(number1 + "!= " + number2 + " && " + number1 + " > " + number2 + " -> " + result); // false
    
    result = number1 != number2 || number1 > number2;
    System.out.println();
    System.out.println(number1 + "!= " + number2 + " || " + number1 + " > " + number2 + " -> " + result); // true
    
    result = !(number1 != number2 || number1 > number2);
    System.out.println();
    System.out.println("!(" + number1 + "!= " + number2 + " || " + number1 + " > " + number2 + ") -> " + result); // false
    
    result = number1 != number2 || number1++ > number2;
    System.out.println();
    System.out.println(number1 + "!= " + number2 + " || " + number1 + "++ > " + number2 + " -> " + result); // true
    System.out.println("The value of the \"first\" input number is '" + number1 + "'."); // 17
    System.out.println("The value of the \"second\" input number is '" + number2 + "'."); // 19
  }
}
