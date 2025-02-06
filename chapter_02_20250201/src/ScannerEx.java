import java.util.Scanner;

public class ScannerEx {
  public static void main(String[] args) {
    // Scanner instance 생성
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input number: ");

    // nextInt() method: data를 int type으로 읽어와 반환 (공백 사용 시, 공백 이전까지의 data 반환)
    int number = scanner.nextInt();
    scanner.close();

    System.out.println();
    System.out.println("You input \'" + number + "\' number.");
  }
}

/*
 * instance
 * - class type으로부터 선언된 variable
 * - instance 할당 시, new keyword 사용
 */

/*
 * import
 * - 해당 class가 위치한 package 명시
 * - java.lang package 관련 class 사용 시, import 생략 가능
 */