import java.util.Scanner;

public class StringTypeOperationEx02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two words >> ");
    String word1 = scanner.next();
    String word2 = scanner.next();
    scanner.close();

    System.out.println();
    System.out.println("[Called By Reference] \"" + word1 + "\" == \"" + word2 + "\"\t-> " + (word1 == word2)); // 인스턴스 주소 값 비교
    System.out.println("[Called By Value] \"" + word1 + "\".equals(\"" + word2 + "\")\t-> " + (word1.equals(word2))); // 데이터 값 비교
  }
}
