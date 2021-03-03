import java.util.Scanner;

public class IceCream {

  static int n;
  static int m;
  static int graph[][] = new int[1001][1001];

  public static boolean dfs(int x, int y) {
    if (x <= -1 || x >= n || y <= -1 || y >= m) {
      return false;
    }

    if (graph[x][y] == 0) {
      graph[x][y] = 1;
      dfs(x - 1, y);
      dfs(x, y - 1);
      dfs(x + 1, y);
      dfs(x, y + 1);
      return true;
    }

    return false;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (dfs(i, j)) {
          result += 1;
        }
      }
    }

    System.out.println(result);
  }
}
