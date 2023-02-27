import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      List<List<Integer>> temp = new ArrayList<>();
      for (List<Integer> subset : result) {
        List<Integer> _temp = new ArrayList<>(subset);
        _temp.add(num);
        temp.add(_temp);
      }
      result.addAll(temp);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().subsets(new int[] { 1, 2, 3 }));
    System.out.println(
        new Solution().subsets(new int[] { 0 }));
  }
}
