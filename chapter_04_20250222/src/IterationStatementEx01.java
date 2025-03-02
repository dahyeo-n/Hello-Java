import java.util.Random;
import java.util.Scanner;

public class IterationStatementEx01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Input number (1~) >> ");
    int number = scanner.nextInt();

    scanner.close();

    if (number < 1) {
      System.out.println("You input wrong number.");
      System.exit(1); // NOTE: [🚨시험 문제 가능성 높음🚨] 0이면 운영체제에게 정상적으로 종료됐음을 알림. 1이면 비정상
    }

    
    final int MAX_RANDOM_NUMBER = 10;
    final int MIN_RANDOM_NUMBER = 1;
    
    int sum = 0;

    System.out.println();

    for (int i = 1; i <= number; i++) { // [중요] 반복 횟수
      // (1) 랜덤 숫자 생성
      // (2) 랜덤 숫자 출력 (e.g. 3 + , 4 = )
      // (3) sum에 랜덤 숫자를 더함

      int randomNumber = random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER + 1);
      char operatorSymbol = i == number ? '=' : '+';
      System.out.print(randomNumber + " " + operatorSymbol + " ");
      sum += randomNumber;
    }

    System.out.println(sum);
  }
}

/*
 * for (int i = number; i > 0; i--) { // [중요] 반복 횟수
      char operatorSymbol = i == 1 ? '=' : '+';
      System.out.print((number + 1 - i) + " " + operatorSymbol + " "); // NOTE: [🚨시험 문제 가능성 높음🚨] (number + 1 - i) 패턴
      sum += i;
    }
 */