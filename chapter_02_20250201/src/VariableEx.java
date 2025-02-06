public class VariableEx {
  public static void main(String[] args) {
    // variable 선언: int type으로 memory에서 "number" 이름으로 4byte 할당
    int number1;

    // 선언된 "number" variable에 108 초기화(저장)
    number1 = 108; // =: 대입 연산자 ('같다'와는 다름)
    System.out.println("The value of the variable \"number1\" is " + number1 + "."); // 108

    // 선언된 "number" variable에 54 초기화 (1개의 변수는 1개의 data만 저장 가능)
    number1 = 54;
    System.out.println("The value of the variable \"number1\" is " + number1 + "."); // 54

    // variable 선언 및 동시 초기화
    int number2 = 49;
    System.out.println("The value of the variable \"number2\" is " + number2 + "."); // 49
  }
}
