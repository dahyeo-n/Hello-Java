import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameVer1 {
  public static final Scanner scanner = new Scanner(System.in);

  public static final int EASY = 1;
  public static final int NORMAL = EASY + 1;
  public static final int HARD = NORMAL + 1;

  public static void main(String[] args) {
    startNumberGuessingGame();
  }

  /**
   * <p>숫자 맞히기 게임에 필요한 메소드의 집합</p>
   */
  public static void startNumberGuessingGame() {
    int difficulty = inputDifficulty();
    int maxRange = calculateMaxRange(difficulty);

    int randomNumber = randomNumber(maxRange);

    int round = playGame(maxRange, randomNumber);
    printGameResult(randomNumber, round);
  }

  /**
   * <p>easy, normal, hard 난이도에 따른 숫자를 입력 받고, 해당 숫자를 반환</p>
   * <p>난이도 범위 외 숫자 입력 시 오류 문구 출력 ("You input a number that does not correspond to easy, normal, hard.")</p>
   * @return 입력된 난이도 숫자
   */
  public static int inputDifficulty() {
    int difficulty = 0;

    while (true) {
      System.out.print("Input difficulty (easy: " + EASY + ", normal: " + NORMAL + ", hard: " + HARD + ") >> ");
      difficulty = scanner.nextInt();

      if (difficulty >= EASY && difficulty <= HARD)
        break;

      System.out.println("You input a number that does not correspond to easy, normal, hard.");
    }

    return difficulty;
  }

  /**
   * <p>난이도에 따라 최대 범위를 산정하고, 최대 범위 반환</p>
   * @param difficulty 난이도
   * @return 난이도에 따른 최대 범위
   */
  public static int calculateMaxRange(int difficulty) {
    int maxRange = 0;

    switch (difficulty) {
      case EASY:
        maxRange = 20;
        break;
      case NORMAL:
        maxRange = 30;
        break;
      case HARD:
        maxRange = 50;
        break;
    }

    return maxRange;
  }

  /**
   * <p>최대 범위 내에서 숫자를 랜덤으로 생성 후, 반환</p>
   * @param maxRange 랜덤 숫자의 최대 범위
   * @return 랜덤 숫자
   */
  public static int randomNumber(int maxRange) {
    Random random = new Random();
    return random.nextInt(1, maxRange + 1);
  }

  /**
   * <p>1부터 최대 범위 내의 숫자를 입력 받아, 입력 받은 숫자를 반환</p>
   * <p>해당 범위 외 숫자 입력 시, 오류 문구 출력 ("You input wrong number.")</p>
   * @param maxRange 입력 받을 수 있는 수의 최대 범위
   * @return 입력 받은 숫자
   */
  public static int inputGuessedNumber(int maxRange) {
    int guessedNumber = 0;

    while (true) {
      System.out.print("Input number (1~" + maxRange + ") >> ");
      guessedNumber = scanner.nextInt();

      if (guessedNumber >= 1 && guessedNumber <= maxRange) {
        break;
      }

      System.out.println("You input wrong number.");
    }

    return guessedNumber;
  }

  /**
   * <p>round 횟수와 추측한 숫자에 따른 결과를 출력</p>
   * <p>1. round 횟수 출력</p>
   * <p>2. 정답일 경우 게임 종료 및 축하 문구 출력 ("Congratulation!! You found a game number!!")</p>
   * <p>3. 추측한 숫자가 정답 숫자보다 작을 경우: round 수 증가 & "Up!!" 문구 출력</p>
   * <p>4. 추측한 숫자가 정답 숫자보다 클 경우: round 수 증가 & "Down!!" 문구 출력</p>
   * @param maxRange 정답인 숫자의 최대 범위
   * @param correctNumber 정답인 숫자
   * @return 라운드 횟수
   */
  public static int playGame(int maxRange, int correctNumber) {
    int round = 1;

    while (true) {
      System.out.println("\n--- Round " + round + " ---\n");

      int guessedNumber = inputGuessedNumber(maxRange);

      if (guessedNumber == correctNumber) {
        scanner.close();
        System.out.println("\nCongratulation!! You found a game number!!");
        break;
      } else if (guessedNumber < correctNumber) {
        System.out.println("\nUp!!");
      } else {
        System.out.println("\nDown!!");
      }

      round++;
    }

    return round;
  }

  /**
   * <p>게임 결과 출력</p>
   * <p>"--- Game Result ---"</p>
   * <p>"Game number: " + correctNumber</p>
   * <p>"You found the game number in \'" + round + "\' rounds."</p>
   * @param randomNumber 맞힌 숫자
   * @param round 몇 라운드 만에 맞혔는지
   */
  public static void printGameResult(int correctNumber, int round) {
    System.out.println("\n--- Game Result ---\n");
    System.out.println("Game number: " + correctNumber);
    System.out.println("You found the game number in \'" + round + "\' rounds.");
  }
}

/*
 * < 의사코드 >
 * (1) random, scanner 인스턴스를 생성해 사용자 입력 받음 ("Input difficulty (easy: 1, normal: 2, hard: 3) >> ")
 * (2) easy, normal, hard 난이도를 각각 연속적인 int type 1, 2, 3으로 설정해 상수화
 * (3) easy, normal, hard에 해당하는 숫자가 아닐 시 "오류 문구" 출력 후 재입력 (오류 문구: "You input a number that does not correspond to easy, normal, hard.")
 * (4) 랜덤 숫자: int type / easy, normal, hard 난이도에 따라 숫자 범위 다르게 설정
 * (4-1) easy: 1 이상 20 이하 (case 1: randomNumber = random.nextInt(1, 20 + 1))
 * (4-2) normal: 1 이상 30 이하
 * (4-3) hard: 1 이상 50 이하
 * (5) 난이도에 따른 알맞은 숫자를 입력하면 한 줄 띄우고, "--- Round 1 ---" 출력 (round 횟수는 변수에 저장하고, 반복문 loop 마지막에 횟수++)
 * (6) 임의의 숫자를 int type으로 입력 받음 ("Input number (1~30) >> ")
 * (7) 해당 난이도의 범위에 알맞지 않을 시 "오류 문구" 출력 후 재입력 (오류 문구: "You input wrong number.")
 * (8) 플레이어 숫자 입력 후, 게임 숫자와 비교하여 "Up!!" or "Down!!" or "Congratulation!! You found a game number!!" 문구 출력 (if문으로 구현)
 * (9) 플레이어가 입력한 숫자와 게임 숫자가 같을 시, 게임 종료 후 결과 출력
 * (9-1) "--- Game Result ---"
 * (9-2) Game number: 17
 * (9-3) 몇 round에 걸쳐서 플레이어가 숫자를 맞췄는지 출력 ("You found the game number in '3' rounds.")
 */