public class TypeEx {
  public static void main(String[] args) {
    byte numberOfByteType = 127;
    System.out.println("The value of \"byte\" type variable is \'" + numberOfByteType + "\'."); // 127

    short numberOfShortType = 32767;
    System.out.println("The value of \"short\" type variable is \'" + numberOfShortType + "\'."); // 32767

    // underscore(_)를 이용하여 luteral 표현 시, 가독성 향상 가능
    int numberOfIntType = 2_147_483_647;
    System.out.println("The value of \"int\" type variable is \'" + numberOfIntType + "\'."); // 2147483647

    // long type literal 표현 시, 접미사 L or l 표시
    long numberOfLongType = 9_223_372_036_854_775_807L; // L은 'long'임을 나타내는 접미사
    System.out.println("The value of \"long\" type variable is \'" + numberOfLongType + "\'."); // 9223372036854775807

    // float type literal 표현 시, 접미사 F or f 표시
    float numberOfFloatType = 3.14F;
    System.out.println("The value of \"float\" type variable is \'" + numberOfFloatType + "\'."); // 3.14

    double numberOfDoubleType = 51.12321;
    System.out.println("The value of \"double\" type variable is \'" + numberOfDoubleType + "\'."); // 51.12321

    // unicode 값(16진수) 또는 숫자 literal로 표현 가능 ('A': 65, '\u0041')
    char valueOfCharType = 'A';
    System.out.println("The value of \"char\" type variable is \'" + valueOfCharType + "\'."); // A

    boolean valueOfBooleanType = true;
    System.out.println("The value of \"boolean\" type variable is \'" + valueOfBooleanType + "\'."); // true
  }
}

/*
 * 문자와 문자열 표시
 * 
 * 문자: 작은 따옴표 사용
 * ex: 'A', '\n', '\u0041' ... 등
 * 
 * 문자열: 큰 따옴표 사용
 * ex: "A", "Hello" ... 등
 */

/*
 * Type 별 variable 선언 시 할당되는 크기
 * 
 * byte     -> 1byte
 * short    -> 2byte
 * int      -> 4byte
 * long     -> 8byte
 * 
 * float    -> 4byte
 * double   -> 8byte
 * 
 * char     -> 2byte
 * 
 * boolean  -> 1byte
 */