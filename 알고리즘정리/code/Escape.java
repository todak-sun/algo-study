import java.util.Scanner;

public class Escape {
  static int n, m;
  static int graph[][] = new int[201][201];




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


    
    
    // for(int i = 0; i < n; i++){
    //   for(int j = 0; j < m; j++){
    //     System.out.print(graph[i][j]);
    //   }
    //   System.out.println();
    // }

  }

}
