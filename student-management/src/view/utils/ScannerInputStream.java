package view.utils;

import java.util.Scanner;

public class ScannerInputStream {

  private static Scanner scanner = null;

  public static Scanner getInstance() {
    if (scanner == null) {
      scanner = new Scanner(System.in);
    }

    return scanner;
  }

  public static void close() {
    scanner.close();
  }

}
