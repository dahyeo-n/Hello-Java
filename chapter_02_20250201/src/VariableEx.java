public class VariableEx {
  public static void main(String[] args) {
    // variable 선언: int type으로 memory에서 "number1" 이름으로 4byte 공간 할당
    int number1;

    // 선언된 "number1" variable에 '108' 초기화 (저장)
    number1 = 108; // 대입 연산자(=)는 '같다'와는 다른 개념임
    System.out.println("The value of the varible \"number1\" is \'" + number1 + "\'."); // 108

    // 선언된 "number1" variable에 '49' 초기화 (1개의 변수는 1개의 값만 저장 가능)
    number1 = 49;
    System.out.println("The value of the varible \"number1\" is \'" + number1 + "\'."); // 49

    // variable 선언 및 동시 초기화
    int number2 = 54;
    System.out.println("The value of the varible \"number2\" is \'" + number2 + "\'."); // 54
  }
}
