import java.util.Scanner;

public class StudentScoreVer1 {
  public static Scanner scanner = new Scanner(System.in);

  // 각각 점수는 0점 이상 100점 이하이며 잘못 입력 시 오류 문구 출력 후, 강제 종료
  public static final int MAX_SCORE = 100;
  public static final int MIN_SCORE = 0;

  // 학생의 국어, 영어, 수학 점수를 입력 받아 합계, 평균, 등급 출력
  public static void main(String[] args) {
    System.out.print("Input Korean score (" + MIN_SCORE + "~" + MAX_SCORE + ") >> ");
    int korean = scanner.nextInt();
    printErrorMessage(korean);

    System.out.print("Input English score (" + MIN_SCORE + "~" + MAX_SCORE + ") >> ");
    int english = scanner.nextInt();
    printErrorMessage(english);

    System.out.print("Input Math score (" + MIN_SCORE + "~" + MAX_SCORE + ") >> ");
    int math = scanner.nextInt();
    printErrorMessage(math);

    scanner.close();

    // 변수에 합계, 평균, 등급 저장
    int sum = korean + english + math;
    double average = (double) sum / 3;
    char grade = 'A';

    printSumAndAverage(sum, average);

    grade = calculateGrade(average, grade);
    printGrade(grade);
  }

  /**
   * <p>최소 점수에서 최대 점수 사이의 점수가 아닌 잘못된 점수일 경우 에러 메시지 출력</p>
   * @param score 과목 점수
   */
  public static void printErrorMessage(int score) {
    if (score > MAX_SCORE || score < MIN_SCORE) {
      System.out.println("You input a number out of range.");
      scanner.close();
      return;
    }
  }

  /**
   * <p>점수의 합계 및 평균 출력</p>
   * @param sum 점수 합계
   * @param average 점수 평균
   */
  public static void printSumAndAverage(int sum, double average) {
    System.out.println("\nYour sum score is \'" + sum + "\' score.");
    System.out.println("Your average score is \'" + average + "\' score.");
  }

  /**
   * <p>평균에 따른 등급을 계산하여 반환</p>
   * @param average 점수 평균
   * @param grade 등급 초기값: 'A'
   * @return 평균에 따른 등급
   */
  public static char calculateGrade(double average, char grade) {
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

    return grade;
  }

  /**
   * <p>등급 출력</p>
   * @param grade 등급
   */
  public static void printGrade(char grade) {
    System.out.println("Your rank is \'" + grade + "\' grade.");
  }
}
