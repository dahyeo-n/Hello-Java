import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGameVer1 {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    startGame();
  }

  /**
   * <p>숫자 야구 게임에 필요한 메소드의 집합</p>
  */
  public static void startGame() {
    int[] gameNumber = getGameNumber();
    int convertedGameNumber = convertArrayToInt(gameNumber);

    System.out.println("\n🧞 Correct Number: " + convertedGameNumber + "\n"); // Debugging 용도
    printTutorial();

    int round = playGame(gameNumber);
    scanner.close();

    printGameResult(convertedGameNumber, round);
  }

  /**
   * 게임에 대한 설명을 출력하는 method
  */
  public static void printTutorial() {
    System.out.println("< Game Tutorial >");
    System.out.println("1. Enter a 4-digit number with no duplicates.\n");
    System.out.println("2. Game Results");
    System.out.println("2-1. [Out] All numbers and locations do not match");
    System.out.println("2-2. [Strike] Same number in the same location");
    System.out.println("2-3. [Ball] Numbers exist but different locations");
    System.out.println("2-4. [🥳 Congratulations!] 4 Strike");
    System.out.println("\nAre you ready? 😆 Have fun playing!\n\n");
  }

  /*
   * (1) getGameNumber: 랜덤 숫자 생성 (숫자는 총 4자리이며 각 자릿수는 1 이상 9 이하의 숫자들로만 채워져야 하며 중복 허용 불가)
   * NOTE: Random 인스턴스 및 4자리를 가진 배열(gameNumber) 생성
   * NOTE: 숫자 1개씩 for문을 돌려서 1~9의 숫자로 생성
   * NOTE: if문으로 현재 index의 숫자가 배열 내에 존재하면 i-- 하여 다시 반복문 돌림
   * NOTE: 중복되지 않는 숫자 4개로 배열이 완성되면 해당 배열 return
  */

  /**
   * <p>각 자리의 수가 겹치지 않는 4자리의 랜덤 숫자 생성</p>
   * <p>⬇️ 예시</p>
   * <p>1. 1357 (O)</p>
   * <p>2. 1111 (X)</p>
   * @return 생성된 랜덤 숫자
  */
  public static int[] getGameNumber() {
    Random random = new Random();
    int[] gameNumber = new int[4];

    for (int i = 0; i < 4; i++) { // index는 3까지 있으니 4 미만으로 반복
      gameNumber[i] = random.nextInt(1, 9 + 1);

      for (int j = 0; j < i; j++) {
        if (gameNumber[j] == gameNumber[i]) {
          i--;
          break;
        }
      }
    }

    return gameNumber;
  }

  /* (2) getPlayerNumber: 정답을 맞힐 때까지 반복해서 player에게 숫자를 입력 받음
    * NOTE: Scanner 인스턴스 생성
    * NOTE: 입력 문구 출력 후 입력 받음
    * NOTE: validatePlayerNumber()를 통해 해당 숫자 검사
    * NOTE: validatePlayerNumber()의 결과가 false일 경우, 오류 문구 출력 후 재입력 받음
    * NOTE: 올바르게 입력했을 경우, 입력 받은 숫자를 그대로 return
  */

  /**
   * <p>각 자리의 수가 겹치지 않는 4자리의 숫자를 입력 받고, 입력 받은 숫자를 반환</p>
   * <p>입력 받는 문구: "Please enter a 4-digit number with no duplicate digits. (e.g. 1357) >> "</p>
   * <p>올바르지 않게 입력했을 경우, 오류 문구 출력 후 재입력 받음 ("Invalid input. Please enter a valid 4-digit number.")</p>
   * @return 입력 받은 숫자
  */
  public static int[] getPlayerNumber() {
    while (true) {
      System.out.print("Please enter a 4-digit number with no duplicate digits. (e.g. 1357) >> ");
      int playerNumber = scanner.nextInt();

      if (validatePlayerNumber(playerNumber)) {
        return convertIntToArray(playerNumber);
      }

      System.out.println("Invalid input. Please enter a valid 4-digit number.\n");
    }
  }

  /**
   * <p>4자리 정수를 배열로 변환</p>
   * @param number 4자리 정수
   * @return 변환된 정수 배열
  */
  public static int[] convertIntToArray(int number) {
    int[] digits = new int[4];

    for (int i = 3; i >= 0; i--) {
      digits[i] = number % 10;
      number /= 10;
    }

    return digits;
  }

  /*
   * (3) validatePlayerNumber: 입력값 검증 (중복 숫자 / 0 포함 여부 / 4자리 체크)
   * NOTE: if문을 통해 각 자릿수가 중복, 0 포함, 4자리가 아닐 시를 조건으로 작성
  */

  /**
   * <p>숫자를 검증해서 true, false 반환 (중복 숫자 / 0 포함 여부 / 4자리 체크)</p>
   * @param number 검증할 숫자
   * @return 검증해서 통과된 경우: true, 불통과된 경우: false
  */
  public static boolean validatePlayerNumber(int number) {
    // 4자리인지 체크
    if (number < 1000 || number > 9999) {
      return false;
    }

    boolean[] isDuplicatedDigits = new boolean[9];
    int temp = number;

    while (temp > 0) {
      int lastDigit = temp % 10 - 1; // 마지막 자리 숫자 추출

      if (lastDigit == -1 || isDuplicatedDigits[lastDigit]) return false; // 0 포함 여부 & 중복 체크 (0~9까지의 숫자가 사용되었는지 확인)

      isDuplicatedDigits[lastDigit] = true; // 숫자 사용 기록
      temp /= 10; // 다음 자리로 이동
    }

    return true;
  }

  /*
   * (4) playGame: player 숫자와 정답 숫자를 비교한 결과값을 주어진 조건대로 출력
   * 
   * ⬇️ Example
   * gameNumber: [1, 3, 5, 7]
   * playerNumber: 1529
   * 
   * int round = 1;
   * int ball = 0;
   * int strike = 0;
   * 
   * 2중 for문으로 각 숫자 4번 반복
   * gameNumber는 마지막 index(3)부터 차례대로 체크 (e.g. 7, 5, 3, 1)
   * playerNumber는 마지막 자릿수 추출(temp % 10)해서 비교
   * 
   * if문 사용
   * (1) 모든 숫자 불일치 → "😔 Out! There is no number or position of the number you guessed."
   * (2) 같은 위치에 같은 숫자 → strike++
   * (3) 숫자는 있지만 위치 다름 → ball++
   * *** 😈 정답이 아닐 경우, round++
   * 
   * 예시1: [game number: 3529] 1784 → "Out!"
   * 예시2: [game number: 3529] 1592 → "😎 1 Strike 2 Ball!"
   * 
   * (4) 4 Strike 완료 시 게임 종료 및 축하 문구 출력 ("🥳 Congratulations!");
  */

  /**
   * <p>Player 숫자와 정답 숫자를 비교하여 결과에 따라 다음과 같이 출력</p>
   * <p>⬇️ 출력 예시</p>
   * <p>1. 모든 숫자 불일치: "😔 Out! There is no number or position of the number you guessed."</p>
   * <p>2. 같은 위치에 같은 숫자: "🔢 1 Strike!"</p>
   * <p>3. 숫자는 있지만 위치 다름: "🔢 2 Ball!"</p>
   * <p>4. 정답을 맞힌 경우: "🥳 Congratulations!"</p>
   * @param gameNumber 정답인 숫자
   * @return 라운드 수
  */
  public static int playGame(int[] gameNumber) {
    int round = 1;

    while (true) {
      System.out.println("--- Round " + round + " ---");

      int[] playerNumber = getPlayerNumber();
      boolean[] checkedPlayerNumber = new boolean[playerNumber.length];
      int strike = 0, ball = 0;

      for (int i = 0; i < playerNumber.length; i++) {
        // 같은 위치에 같은 숫자 → strike++
        if (playerNumber[i] == gameNumber[i]) {
          strike++;
          checkedPlayerNumber[i] = true;
          continue;
        }

        // 숫자는 있지만 위치 다름 → ball++
        if (contains(gameNumber, playerNumber[i])) {
          ball++;
        }
      }

      if (strike == 4) {
        scanner.close();
        System.out.println("\n\n🎉 Congratulations!\n");
        break;
      } else if (strike == 0 && ball == 0) {
        System.out.println("😔 Out! There is no matching number.\n");
      } else {
        System.out.println("🔢 " + strike + " Strike, " + ball + " Ball!\n");
      }

      round++;
    }

    return round;
  }

  // (5) convertArrayToInt: 정답 배열을 하나의 숫자로 변환 (e.g. [1, 3, 5, 7] → 1357)

  /**
   * <p>숫자 배열을 하나의 숫자로 변환하여 반환 (e.g. [1, 3, 5, 7] → 1357)</p>
   * @param number 변환할 숫자 배열
   * @return 하나의 숫자로 변환된 수
  */
  public static int convertArrayToInt(int[] number) {
    int result = 0;

    for (int num : number) {
      result = result * 10 + num; // e.g. 10 + 4 = 14, 140 + 5 = 145...
    }

    return result;
  }

  /**
   * <p>정수 배열 내 특정 숫자 포함 여부 확인</p>
   * @param array 정수 배열
   * @param num 확인할 숫자
   * @return 포함됨: true, 포함 안 됨: false
  */
  public static boolean contains(int[] array, int num) {
    for (int n : array) {
      if (n == num) return true;
    }

    return false;
}

  /*
   * (6) printGameResult: 정답 숫자 및 시도한 횟수 출력
   * NOTE: "Game Number: " + gameNumber
   * NOTE: "You got the answer right in \'" + round + "\' rounds."
  */

  /**
   * <p>정답인 숫자 및 정답을 맞히기 위해 시도한 횟수 출력</p>
   * <p>⬇️ 출력 예시</p>
   * <p>1. "Game Number: 1357"</p>
   * <p>2. "You got the answer right in '7' rounds."</p>
   * @param gameNumber 정답인 숫자
   * @param round 라운드 수
  */
  public static void printGameResult(int gameNumber, int round) {
    System.out.println("--- 👾 Game Result 👾 ---");
    System.out.println("Game Number: " + gameNumber);
    System.out.println("You got the answer right in \'" + round + "\' rounds.");
  }
}
