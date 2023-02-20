package week7.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

  public int[] solution(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int[] answer = new int[s.length()];
  
    for(int index = 0; index < s.length(); index++) {
      Character str = s.charAt(index);
      Integer founded = map.get(str);
      if(Objects.isNull(founded)) {
        answer[index] = -1;
      } else {
        answer[index] = index - founded;
      }
      map.put(str, index);
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().solution("banana")) 
    );

    System.out.println(
      Arrays.toString(new Solution().solution("foobar")) 
    );
  }

}
