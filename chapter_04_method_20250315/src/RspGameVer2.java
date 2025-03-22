import java.util.Random;
import java.util.Scanner;

public class RspGameVer2 {
  public static Scanner scanner = new Scanner(System.in);

  // 연속적인 숫자 1, 2, 3으로 변경
  public static final int ROCK = 1;
  public static final int SCISSORS = ROCK + 1;
  public static final int PAPER = SCISSORS + 1;

  public static void main(String[] args) {
    startRspGame();
  }

  /**
   * <p>가위바위보 게임에 필요한 메소드의 집합</p>
   */
  public static void startRspGame() {
    int round = 1;

    while (true) {
      System.out.println("\n--- Round " + round + " ---\n");

      int playerItem = getPlayerItem();
      int computerItem = randomNumber();

      System.out.println();
      printItems("player", playerItem);
      printItems("computer", computerItem);

      int numberOfWins = printGameResult(playerItem, computerItem);
      printOdds(numberOfWins, round);

      whetherProceedGame();

      round++;
    }
  }

  /**
   * <p>가위/바위/보에 따른 숫자를 입력 받고, 올바르게 입력했는지 검사 후 입력 받은 숫자 반환</p>
   * @return 입력 받은 숫자
   */
  public static int getPlayerItem() {
    int playerItem = 0;

    while (true) {
      System.out.print("Input player item (rock: " + ROCK + ", scissors: " + SCISSORS + ", paper: " + PAPER + ") >> ");
      playerItem = scanner.nextInt();

      if (playerItem >= ROCK && playerItem <= PAPER) {
        break;
      }

      System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
    }

    return playerItem;
  }

  /**
   * <p>범위(1~3) 내의 랜덤한 숫자 생성 후, 반환</p>
   * @return 랜덤 숫자
   */
  public static int randomNumber() {
    Random random = new Random();
    return random.nextInt(ROCK, PAPER + 1);
  }

  /**
   * <p>플레이어가 가위/바위/보 중에 어떤 걸 냈는지 출력</p>
   * @param playerName 플레이어의 이름
   * @param playerItem 플레이어가 선택한 아이템
   */
  public static void printItems(String playerName, int playerItem) {
    switch (playerItem) {
      case ROCK:
        System.out.println("The " + playerName + " choosed \"rock\".");
        break;
      case SCISSORS:
        System.out.println("The " + playerName + " choosed \"scissors\".");
        break;
      case PAPER:
        System.out.println("The " + playerName + " choosed \"paper\".");
        break;
    }
  }

  /**
   * <p>가위바위보 게임 결과 출력</p>
   * <p>1. User가 비겼을 경우: "Draw."</p>
   * <p>2. User가 이겼을 경우: "You win!!"</p>
   * <p>3. User가 졌을 경우: "You lose..."</p>
   * @param playerItem 플레이어의 아이템
   * @param computerItem 컴퓨터의 아이템
   * @return 이긴 횟수
   */
  public static int printGameResult(int playerItem, int computerItem) {
    int numberOfWins = 0;

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

    return numberOfWins;
  }

  /**
   * <p>첫 번째 판부터 현재 판까지의 승률 계산 후, 출력</p>
   * <p>예시: "Your win rate is '50%'."</p>
   * @param numberOfWins 이긴 횟수
   * @param round 진행한 라운드 수
   */
  public static void printOdds(int numberOfWins, int round) {
    int odds = (int) ((double) numberOfWins / round * 100);
    System.out.println("Your win rate is \'" + odds + "%\'.");
  }

  /**
   * <p>게임 진행 여부를 입력 받고, 입력 받은 응답에 따라 게임을 지속하거나 종료</p>
   * <p>1. 게임을 지속할 경우: 게임 재시작</p>
   * <p>2. 게임을 그만할 경우: 게임 즉시 종료</p>
   * <p>3. 잘못 입력했을 경우: 오류 문구 출력 후 입력 다시 받음 ("Please enter either "yes" or "no" only.")</p>
   */
  public static void whetherProceedGame() {
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
        System.exit(0); // 0으로 지정하여 프로그램이 정상적으로 종료됨을 명시
      } else {
        System.out.println("Please enter either \"" + KEEP_PROGRESSING + "\" or \"" + NO_PROGRESS + "\" only.");
      }
    }
  }
}
