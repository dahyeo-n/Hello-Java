public class TypeConversionEx {
  public static void main(String[] args) {
    // int type에서 long type으로 compiler가 type conversion 자동 실행
    int numberOfIntType = 2_147_483_647;
    long numberOfLongType = numberOfIntType;

    System.out.println("The value of the \"int\" type variable is \'" + numberOfIntType + "\'."); // 2147483647
    System.out.println("The value of the \"long\" type variable is \'" + numberOfLongType + "\'."); // 2147483647

    // short type에서 byte type으로 type cast 연산자를 사용해 type conversion 자동 실행
    short numberOfShortType = 32767;
    byte numberOfByteType = (byte)numberOfShortType;
    
    // 🔥 중요!!!
    System.out.println();
    System.out.println("The value of the \"short\" type variable is \'" + numberOfShortType + "\'."); // 32767
    System.out.println("The value of the \"byte\" type variable is \'" + numberOfByteType + "\'."); // -1
  }
}

/*
 * [🔥 중요] short 타입의 최대값 32767을 byte 타입으로 변환하는 과정
 * (1) 32767 (short 최대값) → 16비트 이진수
 * 0111 1111 1111 1111  (32767, 16-bit)
 * 
 * (2) byte는 8비트만 저장 가능하므로 하위 8비트만 남고, 상위 비트는 버려짐
 * 0111 1111 1111 1111  (32767, 16-bit)
 * → 1111 1111  (255, 8-bit)
 * 
 * (3) byte는 '부호 있는 정수(Signed Integer)'이므로, 2의 보수 표현을 사용
 * 1111 1111을 1의 보수(비트 반전): 0000 0000
 * 여기에 1을 더함: 0000 0001 → -1
 */