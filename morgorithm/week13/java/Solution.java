package week13.java;

public class Solution {

  /**
     * n == 2 -> 2번, 1번
     * n == 3 -> 3번, 2번, 1번
     * n == 4 -> 4번, 3번, 2번, 1번
     *  => 1부터 n까지, 등차가 1인 수열의 합이, n보다 커질 때의 최소값.
     *  => f * (f - 1) / 2 >= n
     *  => f(f - 1) >= 2n
     *  => 양변에 루트 씌우고 미분 때려서 대충 근사값 식 도출하면 f >= root(2n)
     *  위의 식에서 f가 가질 수 있는 최소 크기
     */ 

  public int twoEggDrop(int n) {
    return (int) Math.round(Math.sqrt(2 * n));
  }


}
