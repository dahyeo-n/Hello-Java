import java.util.Scanner;

public class StringTypeOperationEx01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input two words >> ");
    String word1 = scanner.next();
    String word2 = scanner.next();
    scanner.close();

    System.out.println();
    System.out.println("\"" + word1 + "\" + \"" + word2 + "\" -> \"" + (word1 + word2) + "\"");
  }
}
