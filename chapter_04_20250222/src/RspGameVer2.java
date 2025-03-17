import java.util.Random;
import java.util.Scanner;

public class RspGameVer2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    // 연속적인 숫자 1, 2, 3으로 변경
    final int ROCK = 1;
    final int SCISSORS = ROCK + 1;
    final int PAPER = SCISSORS + 1;

    int round = 1;
    int playerItem = 0;
    int numberOfWins = 0;

    while (true) {
      System.out.println("\n--- Round " + round + " ---\n");

      while (true) {
        System.out.print("Input player item (rock: " + ROCK + ", scissors: " + SCISSORS + ", paper: " + PAPER + ") >> ");
        playerItem = scanner.nextInt();

        if (playerItem >= ROCK && playerItem <= PAPER) {
          break;
        }

        System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
      }

      int computerItem = random.nextInt(ROCK, PAPER + 1);

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

      if (playerItem == computerItem) {
        System.out.println("Draw.");
      } else if ((playerItem == ROCK && computerItem == SCISSORS)
          || (playerItem == SCISSORS && computerItem == PAPER)
          || playerItem == PAPER && computerItem == ROCK) {
        System.out.println("You win!!");
        numberOfWins++;
      } else {
        System.out.println("You lose...");
      }

      // 첫 번째 판부터 현재 판까지의 승률 계산
      int odds = (int) ((double) numberOfWins / round * 100);
      System.out.println("Your win rate is \'" + odds + "%\'.");

      final String KEEP_PROGRESSING = "yes";
      final String NO_PROGRESS = "no";

      System.out.println();

      while (true) {
        System.out.print("Keep continue (" + KEEP_PROGRESSING + "/" + NO_PROGRESS + ") >> ");
        String progressOrNot = scanner.next();

        if (progressOrNot.equals(KEEP_PROGRESSING)) {
          break;
        } else if (progressOrNot.equals(NO_PROGRESS)) {
          scanner.close();
          return;
        } else {
          System.out.println("Please enter either \"" + KEEP_PROGRESSING + "\" or \"" + NO_PROGRESS + "\" only.");
        }
      }

      round++;
    }
  }
}
