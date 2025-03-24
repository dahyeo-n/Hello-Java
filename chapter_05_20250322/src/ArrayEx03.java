import java.util.Random;
import java.util.Scanner;

public class ArrayEx03 {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    start();
  }

  public static void start() {
    int numbersLength = inputNumbersLength();
    int[] numbers = getRandomNumbers(numbersLength, 0, numbersLength * 2);

    System.out.println();
    printArray("random numbers", numbers);

    int[] sortedNumbers = sort(numbers);

    System.out.println();
    printArray("sorted numbers", sortedNumbers);
  }

  public static int inputNumbersLength() {
    final int MAX_NUMBERS_LENGTH = 100;
    final int MIN_NUMBERS_LENGTH = 3;

    while (true) {
      System.out.print("Input numbers of data(" + MIN_NUMBERS_LENGTH + "~" + MAX_NUMBERS_LENGTH + ") >> ");
      int number = scanner.nextInt();
  
      if (number < MIN_NUMBERS_LENGTH || number > MAX_NUMBERS_LENGTH) {
        System.out.println("You input wrong number of data.");
        continue;
      }

      return number;
    }
  }

  public static int[] getRandomNumbers(int length, int minRandomNumber, int maxRandomNumber) {
    Random random = new Random();

    int[] randomNumbers = new int[length];

    for (int i = 0; i < randomNumbers.length; i++) {
      randomNumbers[i] = random.nextInt(minRandomNumber, maxRandomNumber + 1);

      for (int j = 0; j < i; j++) {
        if (randomNumbers[j] == randomNumbers[i]) {
          i--;
          break;
        }
      }
    }

    return randomNumbers;
  }

  public static int[] sort(int[] numbers) {
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = 0; j < numbers.length - 1 - i; j++) {
        if (numbers[j] > numbers[j + 1]) {
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }

    return numbers;
  }

  public static void printArray(String category, int[] array) {
    System.out.print(category + ": ");

    for (int e : array) {
      System.out.print(e + " ");
    }
  }
}