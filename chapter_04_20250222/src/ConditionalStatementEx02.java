import java.util.Scanner;

public class ConditionalStatementEx02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_NUMBER = 100;
    final int MIN_NUMBER = 0;

    System.out.print("Input score (" + MIN_NUMBER + "~" + MAX_NUMBER + ") >> ");
    int score = scanner.nextInt();

    scanner.close();

    if (score < MIN_NUMBER || score > MAX_NUMBER) {
      System.out.println("You input wrong score.");
      return;
    }

    System.out.println();
    // System.out.println("You input correct score.");

    // if (score >= 90) {
    //   System.out.println("Your grade is 'A'.");
    // } else if (score >= 80) {
    //   System.out.println("Your grade is 'B'.");
    // } else if (score >= 70) {
    //   System.out.println("Your grade is 'C'.");
    // } else if (score >= 60) {
    //   System.out.println("Your grade is 'D'.");
    // } else {
    //   System.out.println("Your grade is 'F'.");
    // }

    switch (score / 10) {
      case 10:
      case 9:
        System.out.println("Your grade is 'A'.");
        break;
      case 8:
        System.out.println("Your grade is 'B'.");
        break;
      case 7:
        System.out.println("Your grade is 'C'.");
        break;
      case 6:
        System.out.println("Your grade is 'D'.");
        break;
      default:
        System.out.println("Your grade is 'F'.");
    }
  }
}

// return: method에서 return을 쓴 시점에서 해당 method 종료

/*
 * 등급의 기준
 * (1) 90점 이상 100점 이하 >> A
 * (2) 80점 이상 90점 미만 >> B
 * (3) 70점 이상 80점 미만 >> C
 * (4) 60점 이상 70점 미만 >> D
 * (5) 60점 미만 >> F
 */

/*
 * Input score (0~100) >> 89
 * 
 * Your grade is 'B'.
 */

/*
 * (1) 0 이상이고, 100 이하이면 올바른 점수
 * (2) 0 미만이거나 100 초과면 틀린 점수 => score < 0 || score > 100
 * 
 * Input score (0~100) >> 101
 * You input wrong score.
 * 
 * Input score (0~100) >> -1
 * You input wrong score.
 * 
 * Input score (0~100) >> 100
 * 
 */