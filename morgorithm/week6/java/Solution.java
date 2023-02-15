public class Solution {

  public static void main(String[] args) {

    int result = new Solution().numberOfBeams(new String[] {
        "011001", "000000", "010100", "001000"
    });
    System.out.println(result);
  }

  public int numberOfBeams(String[] bank) {
    int result = 0;
    int previousCount = 0;
    for (String line : bank) {
      int countOfBeam = line.replaceAll("0", "").length();
      if (countOfBeam == 0) {
        continue;
      } else {
        result += countOfBeam * previousCount;
        previousCount = countOfBeam;
      }
    }
    return result;
  }

}
