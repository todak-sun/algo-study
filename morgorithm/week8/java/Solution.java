package week8.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public int minimumCost(int[] cost) {
    List<Integer> sorted =  Arrays.stream(cost).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    int total = 0;
    for (int i = 0; i < sorted.size(); i++) {
      if (i % 3 != 2) {
        total += sorted.get(i);
      }
    }
    return total;
  }

  public static void main(String[] args) {

    System.out.println("result : " + new Solution().minimumCost(new int[] { 1, 2,
    3 }));
    System.out.println("result : " + new Solution().minimumCost(new int[] { 6, 5,
    7, 9, 2, 2 }));
    System.out.println("result : " + new Solution().minimumCost(new int[] { 5, 5 }));
  }

}
