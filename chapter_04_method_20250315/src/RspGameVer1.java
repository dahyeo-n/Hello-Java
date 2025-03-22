import java.util.Random;
import java.util.Scanner;

public class RspGameVer1 {
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
    int playerItem = getPlayerItem();
    int computerItem = randomNumber();

    System.out.println();
    printItems("player", playerItem);
    printItems("computer", computerItem);
    printGameResult(playerItem, computerItem);
  }

  /**
   * <p>가위/바위/보에 따른 숫자를 입력 받고, 올바르게 입력했는지 검사 후 입력 받은 숫자 반환</p>
   * @return 입력한 숫자
   */
  public static int getPlayerItem() {
    Scanner scanner = new Scanner(System.in);
    int playerItem = 0;

    System.out.print("Input player item (rock: " + ROCK + ", scissors: " + SCISSORS + ", paper: " + PAPER + ") >> ");
    playerItem = scanner.nextInt();

    validateItem(playerItem, scanner);
    scanner.close();

    return playerItem;
  }

  /**
   * <p>해당 숫자가 rock, scissors, paper에 해당하는 숫자가 아닐 시,</p>
   * <p>오류 문구 출력 후 프로그램 강제 종료 ("You input a number that does not correspond to rock, paper, or scissors.")</p>
   * @param playerItem 검증할 숫자
   * @param scanner Scanner 인스턴스 (`scanner.close()`를 위해 필요)
   */
  public static void validateItem(int playerItem, Scanner scanner) {
    if (playerItem > PAPER || playerItem < ROCK) {
      scanner.close();
      System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
      System.exit(1); // 프로그램을 강제 종료하려면 return이 아닌, System.exit(1)을 사용해야 함
    }
  }

  /**
   * <p>범위(1~3) 내의 랜덤한 숫자 생성 후, 반환</p>
   * @return 랜덤 숫자
   */
  public static int randomNumber() {
    Random random = new Random();
    return random.nextInt(ROCK, PAPER + 1); // 2 + 1하여 최대값을 3으로 맞춤
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
   */
  public static void printGameResult(int playerItem, int computerItem) {
    System.out.println();

    if (playerItem == computerItem) {
      System.out.println("Draw.");
    } else if ((playerItem == ROCK && computerItem == SCISSORS)
        || (playerItem == SCISSORS && computerItem == PAPER)
        || playerItem == PAPER && computerItem == ROCK) {
      System.out.println("You win!!");
    } else {
      System.out.println("You lose...");
    }
  }
}
