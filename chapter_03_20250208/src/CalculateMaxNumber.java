import java.util.Scanner;

public class CalculateMaxNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input three numbers >> ");
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int number3 = scanner.nextInt();
    scanner.close();

    int compareNumbers = number1 > number2 ? number1 : number2;
    int maxNumber = compareNumbers > number3 ? compareNumbers : number3;

    System.out.println();
    System.out.println("The most biggest number is \'" + maxNumber + "\'.");
  }
}

/*
 * Input three numbers >> 10 8 9
 * 
 * The most biggest number is '10'.
 */