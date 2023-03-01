package week14.java;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  class Index {
    int first;
    int last;

    @Override
    public String toString() {
      return "Index [first=" + first + ", last=" + last + "]";
    }

  }

  public List<Integer> partitionLabels(String s) {
    ArrayList<Integer> result = new ArrayList<>();
    int[] lastIndexs = new int[26];
    for (int i = 0; i < s.length(); i++) {
      lastIndexs[s.charAt(i) - 'a'] = i;
    }
  
    int firstMeet = 0;
    int max = 0;

    for(int i = 0; i < s.length(); i++) {
      max = Math.max(max, lastIndexs[s.charAt(i) - 'a']);

      if(i == max) {
        int nextMeet = max + 1;
        result.add(nextMeet - firstMeet);
        firstMeet = nextMeet;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    System.out.println(
        new Solution().partitionLabels("eccbbbbdec"));
  }

}
