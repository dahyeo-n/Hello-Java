import java.util.Random;
import java.util.Scanner;

public class RspGameVer1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    // 연속적인 숫자 1, 2, 3으로 변경
    final int ROCK = 1;
    final int SCISSORS = ROCK + 1;
    final int PAPER = SCISSORS + 1;

    System.out.print("Input player item (rock: " + ROCK + ", scissors: " + SCISSORS + ", paper: " + PAPER+ ") >> ");
    int playerItem = scanner.nextInt();

    scanner.close();

    // rock, scissors, paper에 해당하는 숫자가 아닐 시 "오류 문구" 출력 후 프로그램 강제 종료
    if (playerItem > PAPER || playerItem < ROCK) {
      System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
      return;
    }

    // 컴퓨터는 랜덤한 숫자로 설정
    int computerItem = random.nextInt(ROCK, PAPER + 1); // 2 + 1하여 최대값을 3으로 맞춤

    System.out.println();

    switch (playerItem) {
      case ROCK:
        System.out.println("The player choosed \"rock\".");
        break;
      case SCISSORS:
        System.out.println("The player choosed \"scissors\".");
        break;
      case PAPER:
        System.out.println("The player choosed \"paper\".");
        break;
    }

    switch (computerItem) {
      case ROCK:
        System.out.println("The computer choosed \"rock\".");
        break;
      case SCISSORS:
        System.out.println("The computer choosed \"scissors\".");
        break;
      case PAPER:
        System.out.println("The computer choosed \"paper\".");
        break;
    }

    System.out.println();

    // 바위 > 가위
    // 가위 > 보
    // 보 > 바위
    if ((playerItem == ROCK && computerItem == SCISSORS)
        || (playerItem == SCISSORS && computerItem == PAPER)
        || playerItem == PAPER && computerItem == ROCK) {
      System.out.println("You win!!");
    } else if (playerItem == computerItem) {
      System.out.println("Draw.");
    } else {
      System.out.println("You lose...");
    }
  }
}
