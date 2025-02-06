public class SystemEx {
  public static void main(String[] args) {
    // System.out.print(): monitor에 전달된 data 출력'만'
    System.out.print("Hello!! My name is \"" + "DaHyeon" + "\".\n"); // ,로 argument 구분 (해당 method에서 parameter로 받음)
    System.out.print("I\'m \'" + 25 + "\' years old.\n\n");

    // System.out.println(): monitor에 전달된 data 출력 후 -> 자동 줄 바꿈
    System.out.println("Hello!! My name is \"" + "DaHyeon" + "\".");
    System.out.println("I\'m \'" + 25 + "\' years old.");
  }
}

/*
 * Escape Sequence
 * : 문자열 내에서 특별한 의미를 가지는 문자
 * 
 * \n: 줄 바꿈
 * 
 * <출력>
 * \": 큰 따옴표
 * \': 작은 따옴표
 * \\: \
 */
