import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameVer1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    final int EASY = 1;
    final int NORMAL = EASY + 1;
    final int HARD = NORMAL + 1;

    int difficulty = 0;

    while (true) {
      System.out.print("Input difficulty (easy: " + EASY + ", normal: " + NORMAL + ", hard: " + HARD + ") >> ");
      difficulty = scanner.nextInt();

      if (difficulty >= EASY && difficulty <= HARD)
        break;

      System.out.println("You input a number that does not correspond to easy, normal, hard.");
    }

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

    int randomNumber = random.nextInt(1, maxRange + 1);

    int round = 1;
    int guessedNumber = 0;

    while (true) {
      System.out.println("\n--- Round " + round + " ---\n");

      while (true) {
        System.out.print("Input number (1~" + maxRange + ") >> ");
        guessedNumber = scanner.nextInt();

        if (guessedNumber >= 1 && guessedNumber <= maxRange) {
          break;
        }

        System.out.println("You input wrong number.");
      }

      if (guessedNumber == randomNumber) {
        System.out.println("\nCongratulation!! You found a game number!!");
        break;
      } else if (guessedNumber < randomNumber) {
        System.out.println("\nUp!!");
      } else {
        System.out.println("\nDown!!");
      }

      round++;
    }

    scanner.close();

    System.out.println("\n--- Game Result ---\n");
    System.out.println("Game number: " + randomNumber);
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