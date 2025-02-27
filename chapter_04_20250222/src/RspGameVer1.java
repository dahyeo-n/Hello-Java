import java.util.Random;
import java.util.Scanner;

public class RspGameVer1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.print("Input player item (rock: 1, scissors: 2, paper: 3) >> ");
    int playerItem = scanner.nextInt();

    final int MAX_SCORE = 3;
    final int MIN_SCORE = 1;

    // rock, scissors, paper에 해당하는 숫자가 아닐 시 "오류 문구" 출력 후 프로그램 강제 종료
    if (playerItem > MAX_SCORE || playerItem < MIN_SCORE) {
      System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
      scanner.close();
      return;
    }

    scanner.close();

    // 컴퓨터는 rock, scissors, paper 아이템을 각각 연속적인 int type 숫자 1, 2, 3으로 랜덤 설정
    int computerItem = random.nextInt(MIN_SCORE, MAX_SCORE + 1); // 2 + 1하여 최대값을 3으로 맞춤

    String player = "paper";
    String computer = "paper";

    switch (playerItem) {
      case 3:
        player = "paper";
        break;
      case 2:
        player = "scissors";
        break;
      case 1:
        player = "rock";
        break;
    }

    switch (computerItem) {
      case 3:
        computer = "paper";
        break;
      case 2:
        computer = "scissors";
        break;
      case 1:
        computer = "rock";
        break;
    }

    System.out.println();
    System.out.println("The player choosed \"" + player + "\".");
    System.out.println("The computer choosed \"" + computer + "\".");

    System.out.println();

    // 바위 > 가위
    // 가위 > 보
    // 보 > 바위
    if ((player == "rock" && computer == "scissors")
        || (player == "scissors" && computer == "paper")
        || player == "paper" && computer == "rock") {
      System.out.println("You win!!");
    } else if (player == computer) {
      System.out.println("Draw.");
    } else {
      System.out.println("You lose...");
    }
  }
}
