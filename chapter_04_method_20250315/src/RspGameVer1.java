import java.util.Random;
import java.util.Scanner;

public class RspGameVer1 {
  public static Scanner scanner = new Scanner(System.in);

  // 연속적인 숫자 1, 2, 3으로 변경
  public static final int ROCK = 1;
  public static final int SCISSORS = ROCK + 1;
  public static final int PAPER = SCISSORS + 1;

  public static void main(String[] args) {
    int playerItem = inputPlayerItem();
    scanner.close();

    printErrorMessage(playerItem);

    // RandomComputerItem: 컴퓨터 아이템을 랜덤한 숫자로 설정
    int computerItem = RandomNumber();

    printItems(playerItem, computerItem);
    printGameResult(playerItem, computerItem);
  }

  /**
   * <p>가위바위보에 따른 숫자를 입력 받고, 해당 숫자를 반환</p>
   * @return 입력한 숫자
   */
  public static int inputPlayerItem() {
    System.out.print("Input player item (rock: " + ROCK + ", scissors: " + SCISSORS + ", paper: " + PAPER + ") >> ");

    return scanner.nextInt();
  }

  /**
   * <p>해당 숫자가 rock, scissors, paper에 해당하는 숫자가 아닐 시,</p>
   * <p>오류 문구 출력 후 프로그램 강제 종료</p>
   * @param playerItem 검증할 숫자
   */
  public static void printErrorMessage(int playerItem) {
    if (playerItem > PAPER || playerItem < ROCK) {
      System.out.println("You input a number that does not correspond to rock, paper, or scissors.");
      System.exit(1); // 프로그램을 강제 종료하려면 return이 아닌, System.exit(1)을 사용해야 함
    }
  }

  /**
   * <p>범위 내의 랜덤한 숫자 생성 후, 반환</p>
   * @return 랜덤 숫자
   */
  public static int RandomNumber() {
    Random random = new Random();
    return random.nextInt(ROCK, PAPER + 1); // 2 + 1하여 최대값을 3으로 맞춤
  }

  /**
   * <p>플레이어와 컴퓨터가 가위/바위/보 중에 어떤 걸 냈는지 출력</p>
   * @param playerItem 플레이어가 선택한 아이템
   * @param computerItem 컴퓨터의 아이템
   */
  public static void printItems(int playerItem, int computerItem) {
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
  }

  /**
   * <p>가위바위보 게임 결과 출력</p>
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
