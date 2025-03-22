import java.util.Scanner;

public class StudentScoreVer1 {
  public static Scanner scanner = new Scanner(System.in);

  // 학생의 국어, 영어, 수학 점수를 입력 받아 합계, 평균, 등급 출력
  public static void main(String[] args) {
    startStudentScore();
  }

  public static void startStudentScore() {
    int korean = getScore("Korean");
    int english = getScore("English");
    int math = getScore("Math");

    scanner.close();

    // 변수에 합계, 평균, 등급 계산
    int sum = korean + english + math;
    double average = (double) sum / 3;
    char grade = calculateGrade(average);

    printResult(sum, average, grade);
  }

  /**
   * <p>과목명에 따른 점수를 입력 받고, 올바르게 입력했는지 검사 후 반환</p>
   * @param subjectName 과목명
   * @return 입력 받은 점수
   */
  public static int getScore(String subjectName) {
    final int MIN_SCORE = 0;
    final int MAX_SCORE = 100;

    System.out.print("Input " + subjectName + " score (" + MIN_SCORE + "~" + MAX_SCORE + ") >> ");
    int score = scanner.nextInt();

    validateScore(score, MIN_SCORE, MAX_SCORE);

    return score;
  }

  /**
   * <p>최소 점수에서 최대 점수 사이의 점수가 아닌 잘못된 점수일 경우, 에러 메시지 출력 ("You input a number out of range.")</p>
   * @param score 점수
   * @param MIN_SCORE 최소 점수 (0)
   * @param MAX_SCORE 최대 점수 (100)
   */
  public static void validateScore(int score, int MIN_SCORE, int MAX_SCORE) {
    if (score > MAX_SCORE || score < MIN_SCORE) {
      scanner.close();
      System.out.println("You input a number out of range.");
      System.exit(1);
    }
  }

  /**
   * <p>점수의 평균에 따른 등급을 계산하여 반환</p>
   * <p>1. A: 90~100점</p>
   * <p>2. B: 80~89점</p>
   * <p>3. C: 70~79점</p>
   * <p>4. D: 60~69점</p>
   * <p>5. F: 0~59점</p>
   * @param average 점수 평균
   * @return 평균에 따른 등급
   */
  public static char calculateGrade(double average) {
    char grade = 'A';
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
   * <p>점수의 합계 및 평균, 등급 출력</p>
   * <p>예시 ⬇️</p>
   * <p>1. "Your sum score is '281' score."</p>
   * <p>2. "Your average score is '93.66666666666667' score."</p>
   * <p>3. "Your rank is 'A' grade."</p>
   * @param sum 점수 합계
   * @param average 점수 평균
   * @param grade 등급
   */
  public static void printResult(int sum, double average, char grade) {
    System.out.println("\nYour sum score is \'" + sum + "\' score.");
    System.out.println("Your average score is \'" + average + "\' score.");
    System.out.println("Your rank is \'" + grade + "\' grade.");
  }
}
