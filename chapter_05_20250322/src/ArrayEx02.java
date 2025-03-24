public class ArrayEx02 {
  public static void main(String[] args) {
    // array 선언 및 각 element 값 동시 초기화
    int[] numbers = new int[] { 1, 7, 2, 8, 6 };

    System.out.println("The count of numbers is \'" + numbers.length + "\'.");
    System.out.print("Values of this array >> ");

    for (int e : numbers) {
      System.out.print(e + " ");
    }
  }
}
