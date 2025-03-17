import java.util.Scanner;

public class ReverseNumberVer02 {
  public static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int inputNumber = inputNumber();
    scanner.close();

    int originalNumber = inputNumber;
    inputNumber = convertedSignNumber(inputNumber, inputNumber);
    int reversedNumber = convertedReverseNumber(inputNumber);

    System.out.println();
    reversedNumber = convertedSignNumber(reversedNumber, originalNumber);
    print(originalNumber, reversedNumber);
  }

  // NOTE: /** */ Javadoc 스니펫

  /**
   * <p>숫자 입력 후 해당 숫자 반환</p>
   * @return 입력된 숫자
   */
  public static int inputNumber() { // NOTE: 반환 타입을 'void' 대신 작성
    System.out.print("Input number >> ");

    return scanner.nextInt();
  }

  /**
   * <p>기준점이 되는 숫자의 부호를 기준으로 바뀔 숫자의 부호를 반영하여 반환</p>
   * @param changedNumber 바뀔 숫자
   * @param standardNumber 기준점 숫자
   * @return 기준점 숫자의 부호에 의하여 바뀐 숫자
   */
  public static int convertedSignNumber(int changedNumber, int standardNumber) {
    return standardNumber > 0 ? changedNumber : changedNumber * (-1);
  }

  /**
   * <p>특정 숫자를 거꾸로 변환하여 반환</p>
   * @param originalNumber 기존 숫자
   * @return 기존 숫자를 거꾸로 변환한 숫자
   */
  public static int convertedReverseNumber(int originalNumber) {
    int reversedNumber = 0;

    while (originalNumber != 0) {
      reversedNumber = reversedNumber * 10 + (originalNumber % 10);
      originalNumber /= 10;
    }
    
    return reversedNumber;
  }

  /**
   * <p>특정 두 개의 숫자를 이용해서 특정 문장 출력</p>
   * <p>기존 숫자와 거꾸로 된 숫자를 출력하는 내용</p>
   * <hr>
   * <p>예시<p>
   * <code>The number converted from '1234' is '4321'.</code>
   * @param originalNumber 기존 숫자
   * @param reversedNumber 거꾸로 된 숫자
   */
  public static void print(int originalNumber, int reversedNumber) {
    System.out.println("The number converted from \'" + originalNumber + "\' is \'" + reversedNumber + "\'.");
  }
}