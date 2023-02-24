public class Solution {
  public int solution(int a, int b, int n) {
    if (n < a) {
      return 0;
    } else {
      int returnedN = (n / a) * b;
      int rest = returnedN + n % a;
      return returnedN + this.solution(a, b, rest);
    }
  }

  public static void main(String[] args) {
    int ret1 = new Solution().solution(2, 1, 20);
    System.out.println("ret1 : " + ret1);
    System.out.println(ret1 == 19);

    System.out.println(
        new Solution().solution(3, 1, 20) == 9);

  }
}