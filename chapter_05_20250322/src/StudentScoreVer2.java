import java.util.Scanner;

public class StudentScoreVer2 {
  public static Scanner scanner = new Scanner(System.in);

  // 학생의 점수의 개수와 해당 점수의 과목들의 이름을 영어로 입력 받고 해당 점수의 합계, 평균(실수), 등급(문자)을 출력
  public static void main(String[] args) {
    startStudentScore();
  }

  /**
   * <p>점수의 합계, 평균, 등급 출력에 필요한 메소드의 집합</p>
  */
  public static void startStudentScore() {
    int subjectLength = getSubjectLength();
    int[] scores = getSubjectInfo(subjectLength);

    scanner.close();

    // 변수에 data 계산 및 저장 (합계: int, 평균: double, 등급: char)
    int sum = calculateSum(scores);
    double average = (double) sum / subjectLength;
    char grade = calculateGrade(average);

    printResult(sum, average, grade);
  }

  /*
   * 과목의 개수는 3개 이상, 10개 이하여야 하며 잘못 입력 시 오류 문구 출력 후 재입력
   * ⇒ getSubjectLength: 과목의 개수를 입력받고, 해당 개수를 반환하는 method (지역변수: subjectLength)
   * NOTE: 과목을 몇 개 입력 받을 것인지를 먼저 입력 받아서 그것의 length대로 배열(scores) 생성
   * NOTE: 3개 이상 10개 이하가 아닐 경우, 오류 메시지 출력 후 재입력 받기
   * ⇒ validateScoreLength: 올바른 범위가 아닐 시, 오류 문구 출력 및 재입력 받음 (parameter: scoreLength)
  */

  /**
   * <p>과목의 개수를 입력받고, 올바르게 입력했는지 검사 후 입력 받은 개수 반환</p>
   * <p>⚠️ 과목의 개수가 3개 이상 10개 이하가 아닐 경우, 오류 메시지 출력 ("You entered an incorrect range. Please enter again.")</p>
   * @return 입력 받은 과목의 개수
  */
  public static int getSubjectLength() {
    int subjectLength = 0;

    while (true) {
      System.out.print("Please enter the number of subjects (3~10) >> ");
      subjectLength = scanner.nextInt();

      if (subjectLength >= 3 && subjectLength <= 10) {
        break;
      }

      System.out.println("You entered an incorrect range. Please enter again.\n");
    }

    return subjectLength;
  }

  /*
   * 반드시 해당 과목명 입력 후 점수를 입력해야 하며 다음 점수 입력 전까지 해당 과목명과 점수 입력 완료 (이름 연속 입력 or 점수 연속 입력 X)
   * NOTE: 점수 배열의 scoreLength만큼 '과목명-점수'를 반복해서 입력 받을 수 있게 구현
   * ⇒ getSubjectInfo:scoreLength만큼 반복문을 돌려서 '과목명-점수'를 짝지어서 입력 받음
   * NOTE: 만약, 입력 타입이 안 맞을 경우엔 오류 문구 출력 후 재입력
   * ⇒ validateScoreType: 입력 타입이 올바르지 않으면 오류 문구 출력 및 재입력
  */

  /*
   * 각 점수는 0점 이상 100점 이하이며 잘못 입력 시 오류 문구 출력 후 재입력
   * NOTE: 0점 이상 100점 이하가 아닐 경우, 오류 문구 출력 후 재입력
   * ⇒ validateScore: 입력한 점수의 범위가 올바르지 않으면 오류 문구 출력 및 재입력
  */

  /**
   * <p>과목명과 점수를 입력 받아서 점수 배열을 반환</p>
   * <p>점수를 올바른 범위 내에서 입력하지 않았을 시, 오류 문구 출력 후 재입력 받음 ("You input a number out of range. Please enter again.")</p>
   * @param subjectLength 입력 받을 점수의 개수
   * @return 입력 받은 점수의 배열
  */
  public static int[] getSubjectInfo(int subjectLength) {
    int[] scores = new int[subjectLength];

    for (int i = 0; i < subjectLength; i++) {
      System.out.print("\nPlease enter the subject name (English only) >> ");
      String subjectName = scanner.next();

      while (true) {
        System.out.print("\nPlease enter the \'" + subjectName + "\' score (0~100, Digit only) >> ");
        int score = scanner.nextInt();

        if (score >= 0 && score <= 100) {
          scores[i] = score;
          break;
        }

        System.out.println("You input a number out of range. Please enter again.");
      }
    }

    return scores;
  }

  /**
   * <p>점수들의 합계를 계산하여 반환</p>
   * @param scores 점수들
   * @return 계산된 합계
  */
  public static int calculateSum(int[] scores) {
    int sum = 0;

    for (int score : scores) {
      sum += score;
    }

    return sum;
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
    int averageOfIntType = (int) average;

    switch (averageOfIntType / 10) {
      case 10:
      case 9: return 'A';
      case 8: return 'B';
      case 7: return 'C';
      case 6: return 'D';
      default: return 'F';
    }
  }

  /**
   * <p>점수의 합계 및 평균, 등급 출력</p>
   * <p>예시 ⬇️</p>
   * <p>1. "Your sum score is '281' score."</p>
   * <p>2. "Your average score is '93.66666666666667' score."</p>
   * <p>3. "Your rank is 'A' grade."</p>
   * @param sum 합계 점수
   * @param average 평균 점수
   * @param grade 등급
  */
  public static void printResult(int sum, double average, char grade) {
    System.out.println("\nTotal Score: " + sum);
    System.out.println("Average Score: " + average);
    System.out.println("Grade: " + grade);
  }
}
