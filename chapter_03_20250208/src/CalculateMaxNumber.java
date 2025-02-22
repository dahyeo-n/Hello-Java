import java.util.Scanner;

public class CalculateMaxNumber {
  public static void main(String[] args) {
    // Scanner instance 생성
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input three numbers >> ");
    // 3개의 숫자를 입력 받음
    int number1 = scanner.nextInt();
    int number2 = scanner.nextInt();
    int number3 = scanner.nextInt();
    // Scanner 종료
    scanner.close();

    int compareNumber = number1 > number2 ? number1 : number2;
    int maxNumber = compareNumber > number3 ? compareNumber : number3;

    System.out.println();
    System.out.println("The most biggest number is \'" + maxNumber + "\'.");
  }
}

/*
 * Input three numbers >> 10 8 9
 * 
 * The most biggest number is '10'.
 */