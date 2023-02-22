package week9.java;

import java.util.stream.IntStream;

public class Solution {

  public int solution(String t, String p) {
    long max = Long.parseLong(p);
    int size = p.length();
    return (int) IntStream.rangeClosed(0, t.length() - p.length())
        .mapToLong((i) -> Long.parseLong(t.substring(i, i + size)))
        .filter((num) -> num <= max)
        .count();
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().solution("3141592", "271") == 2);
    System.out.println(
        new Solution().solution("500220839878", "7") == 8);
    System.out.println(
        new Solution().solution("10203", "15") == 3);
  }
}
