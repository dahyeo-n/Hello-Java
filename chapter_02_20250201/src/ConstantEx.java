public class ConstantEx {
  public static void main(String[] args) {
    // constant 선언: 'final' keyword를 이용하여 'int' type으로, memory에서 "CONSTANT_NUMBER_1" 이름으로 4byte 공간 할당
    final int CONSTANT_NUMBER_1;

    // 선언된 "CONSTANT_NUMBER_1" constant에 6 초기화
    CONSTANT_NUMBER_1 = 6;
    System.out.println("The value of the variable \"CONSTANT_NUMBER_1\" is \'" + CONSTANT_NUMBER_1 + "\'."); // 6

    // constant 선언 및 동시 초기화
    final int CONSTANT_NUMBER_2 = 12;
    System.out.println("The value of the variable \"CONSTANT_NUMBER_2\" is \'" + CONSTANT_NUMBER_2 + "\'."); // 12
  }
}
