import java.util.Scanner;

public class StudentScoreVer1 {
  public static void main(String[] args) {
    // 학생의 국어, 영어, 수학 점수를 입력 받아 합계, 평균, 등급 출력
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input Korean score (0~100) >> ");
    int korean = scanner.nextInt();

    // 각각 점수는 0점 이상 100점 이하이며 잘못 입력 시 오류 문구 출력 후, 강제 종료
    final int MAX_SCORE = 100;
    final int MIN_SCORE = 0;

    if (korean > MAX_SCORE || korean < MIN_SCORE) {
      System.out.println("You input a number out of range.");
      scanner.close();
      return;
    }

    System.out.print("Input English score (" + MIN_SCORE + "~" + MAX_SCORE + ") >> ");
    int english = scanner.nextInt();

    if (english > MAX_SCORE || english < MIN_SCORE) {
      System.out.println("You input a number out of range.");
      scanner.close();
      return;
    }

    System.out.print("Input Math score (0~100) >> ");
    int math = scanner.nextInt();

    if (math > MAX_SCORE || math < MIN_SCORE) {
      System.out.println("You input a number out of range.");
      scanner.close();
      return;
    }

    scanner.close();

    // 변수에 합계, 평균, 등급 저장
    int sum = korean + english + math;
    double average = (double) sum / 3;
    char grade = 'A';

    System.out.println();
    System.out.println("Your sum score is \'" + sum + "\' score.");
    System.out.println("Your average score is \'" + average + "\' score.");

    int averageOfIntType = (int) average;

    switch (averageOfIntType / 10) {
      case 10:
      case 9:
        grade = 'A';
        break;
      case 8:
        grade = 'B';
        break;
      case 7:
        grade = 'C';
        break;
      case 6:
        grade = 'D';
        break;
      default:
        grade = 'F';
    }

    System.out.println("Your rank is \'" + grade + "\' grade.");
  }
}
