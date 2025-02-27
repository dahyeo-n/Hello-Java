import java.util.Random;
import java.util.Scanner;

public class RandomEx {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Input two numbers >> ");
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();

    scanner.close();

    int maxNumber = number1 > number2 ? number1 : number2;
    int minNumber = number1 < number2 ? number1 : number2;

    // System.out.println(minNumber + ", " + maxNumber);

    int randomNumber = random.nextInt(minNumber, maxNumber + 1);

    System.out.println();
    System.out.println("The ramdomly selected result from the numbers between \'"
      + minNumber + "\' and \'" + maxNumber + "\' is \'" + randomNumber + "\'.");
  }
}