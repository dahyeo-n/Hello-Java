import java.util.Scanner;

public class ReverseNumberVer01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input number >> ");
    int inputNumber = scanner.nextInt();

    scanner.close();

    int originalNumber = inputNumber;
    inputNumber = inputNumber > 0 ? inputNumber : inputNumber * (-1);

    int reversedNumber = 0;

    while (inputNumber != 0) {
      reversedNumber = reversedNumber * 10 + (inputNumber % 10);
      inputNumber /= 10;
    }

    reversedNumber = originalNumber > 0 ? reversedNumber : reversedNumber * (-1);

    System.out.println();
    System.out.println("The number converted from \'" + originalNumber + "\' is \'" + reversedNumber + "\'.");
  }
}
