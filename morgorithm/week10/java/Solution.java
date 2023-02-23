package week10.java;

public class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) {
      return true;
    }
    int placeCounter = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      int curr = flowerbed[i];
      int prev = i > 0 ? flowerbed[i - 1] : curr;
      int next = i == flowerbed.length - 1 ? curr : flowerbed[i + 1];
      if (prev == 0 && curr == 0 && next == 0) {
        flowerbed[i] = 1;
        placeCounter += 1;
        if (placeCounter == n) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1) == true);

    System.out.println(
        new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2) == false);

    System.out.println(
        new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 1, 0, 0 }, 2) == true);
  }

}
