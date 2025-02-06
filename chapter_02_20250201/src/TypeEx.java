public class TypeEx {
  public static void main(String[] args) {
    byte numberOfByteType = 127;
    System.out.println("The value of the \"byte\" type variable is\'" + numberOfByteType + "\'."); // 127

    short numberOfShortType = 32767;
    System.out.println("The value of the \"short\" type variable is\'" + numberOfShortType + "\'."); // 32767

    // underscore(_)를 사용해 literal 표현 시, 가독성 향상 가능
    int numberOfIntType = 2_147_483_647;
    System.out.println("The value of the \"int\" type variable is\'" + numberOfIntType + "\'."); // 2147483647

    // long type literal 표현 시, 접미사 L or l 표시
    long numberOfLongType = 9_223_372_036_854_775_807L;  // L은 'long'임을 나타내는 접미사
    System.out.println("The value of the \"long\" type variable is\'" + numberOfLongType + "\'."); // 9223372036854775807

    // float type literal 표현 시, 접미사 F or f 표시
    float numberOfFloatType = 3.14F;
    System.out.println("The value of the \"float\" type variable is\'" + numberOfFloatType + "\'."); // 3.14

    double numberOfDoubleType = 5.18;
    System.out.println("The value of the \"double\" type variable is\'" + numberOfDoubleType + "\'."); // 5.18

    // unicode 값(16진수) 또는 숫자 literal로 표현 가능 ('A': '\u0041', 65)
    char valueOfCharType = 'A';
    System.out.println("The value of the \"char\" type variable is\'" + valueOfCharType + "\'."); // A

    boolean valueOfBooleanType = true;
    System.out.println("The value of the \"boolean\" type variable is\'" + valueOfBooleanType + "\'."); // true
  }
}

/*
 * (1) 문자와 문자열 표시
 * 문자: 작은 따옴표 사용
 * e.g. 'A', '\n', '\u0041'
 * 
 * 문자열: 큰 따옴표 사용
 * e.g. "Hello", "A", ""
 */

/*
 * (2) Type별 variable 선언 시, 할당되는 크기
 * byte:     1byte
 * short:    2byte
 * int:      4byte
 * long:     8byte
 * 
 * float:    4byte
 * double:   8byte
 * 
 * char:     2byte
 * boolean:  1byte
 */