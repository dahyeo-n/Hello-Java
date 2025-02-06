public class TypeConversionEx {
  public static void main(String[] args) {
    // int type에서 long type으로 compiler가 type conversion 자동 실행
    int numberOfIntType = 2_147_483_647;
    long numberOfLongType = numberOfIntType;

    System.out.println("The value of \"int\" type variable is \'" + numberOfIntType + "\'."); // 2147483647
    System.out.println("The value of \"long\" type variable is \'" + numberOfLongType + "\'."); // 2147483647

    // short type에서 byte type으로 type cast 연산자를 사용하여 type conversion 자동 실행
    short numberOfShortType = 32767;
    byte numberOfByteType = (byte)numberOfShortType;
    
    // 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    System.out.println();
    System.out.println("The value of \"short\" type variable is \'" + numberOfShortType + "\'."); // 32767
    System.out.println("The value of \"byte\" type variable is \'" + numberOfByteType + "\'."); // -1 
  }
}
