import java.util.Scanner;

public class ExchangeOfMoney {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input sum of money >> ");
    int money = scanner.nextInt();
    scanner.close();

    int exchangeFor50000 = money / 50000;
    money %= 50000;

    int exchangeFor10000 = money / 10000;
    money %= 10000;

    int exchangeFor5000 = money / 5000;
    money %= 5000;

    int exchangeFor1000 = money / 1000;
    money %= 1000;

    int exchangeFor500 = money / 500;
    money %= 500;

    int exchangeFor100 = money / 100;
    money %= 100;

    System.out.println();
    System.out.println("The number of \"50,000\" won bills is \'" + exchangeFor50000 + "\'.");
    System.out.println("The number of \"10,000\" won bills is \'" + exchangeFor10000 + "\'.");
    System.out.println("The number of \"5,000\" won bills is \'" + exchangeFor5000 + "\'.");
    System.out.println("The number of \"1,000\" won bills is \'" + exchangeFor1000 + "\'.");
    System.out.println("The number of \"500\" won bills is \'" + exchangeFor500 + "\'.");
    System.out.println("The number of \"100\" won bills is \'" + exchangeFor100 + "\'.");

    System.out.println();
    System.out.println("The remaining amount is \"" + money + "\" won.");
  }
}
