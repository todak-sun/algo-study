# 깊이우선탐색(DFS)

## 문제 - 음료수 얼려 먹기

### 설명
N x M 크기의 얼음 틀이 있습니다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시됩니다.
구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주합니다.
이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하세요.
다음의 4 x 5 얼음 틀 예시에서는 아이스크림이 총 3개 생성됩니다.
```
00110
00011
11111
00000
```
### 입력 조건
- 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어집니다. (1 <= N, M <= 1,000)
- 두번 째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어집니다.
- 이떄 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1입니다.
  
### 출력 조건
- 한 번에 만들 수 있는 아이스크림의 개수를 출력합니다.

## 풀이
```java

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

```
---

## 문제 - 미로 탈출

### 설명
- 동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 합니다.
- 동빈이의 위치는 (1, 1)이며 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있습니다. 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있습니다. 미로는 반드시 탈출할 수 있는 형태로 제시됩니다.
- 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하세요. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다.

### 입력조건
- 첫째 줄에 두 정수 N, M(4 <= N, M <= 200)이 주어집니다. 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어집니다. 각각의 수들은 공백 없이 붙어서 입력으로 제시됩니다. 또한 시작칸과 마지막 칸은 항상 1입니다.

## 출력조건
- 첫째 줄에 최소 이동 칸의 개수를 출력합니다.

## 입력 예시
```
5 6
101010
111111
000001
111111
111111

// 10
```
## 풀이







---
# 기타 정리한 코드

``` java
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Graph g = new Graph(9);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(5, 6);
    g.addEdge(5, 7);
    g.addEdge(6, 8);

    g.dfsR(3);
  }
}

class Queue<T> {
  class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node<T> first;
  private Node<T> last;

  public void add(T data) {
    Node<T> t = new Node<>(data);
    if (last != null) {
      last.next = t;
    }
    last = t;
    if (first == null) {
      first = last;
    }
  }

  public T remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    T data = first.data;
    first = first.next;

    if (first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }
}

class Graph {
  class Node {
    int data;
    LinkedList<Node> adjacent;
    boolean marked;

    Node(int data) {
      this.data = data;
      this.marked = false;
      adjacent = new LinkedList<>();
    }
  }

  Node[] nodes;

  Graph(int size) {
    nodes = new Node[size];
    for (int i = 0; i < size; i++) {
      nodes[i] = new Node(i);
    }
  }

  void addEdge(int i1, int i2) {
    Node n1 = nodes[i1];
    Node n2 = nodes[i2];
    if (!n1.adjacent.contains(n2)) {
      n1.adjacent.add(n2);
    }
    if (!n2.adjacent.contains(n2)) {
      n2.adjacent.add(n1);
    }
  }

  void dfs() {
    dfs(0);
  }

  void dfs(int index) {
    Node root = nodes[index];
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    root.marked = true;
    while (!stack.isEmpty()) {
      Node r = stack.pop();
      for (Node n : r.adjacent) {
        if (!n.marked) {
          n.marked = true;
          stack.push(n);
        }
      }
      visit(r);
    }
  }

  void bfs() {
    bfs(0);
  }

  void bfs(int index) {
    Node root = nodes[index];
    Queue<Node> queue = new Queue<>();
    queue.add(root);
    root.marked = true;
    while (!queue.isEmpty()) {
      Node r = queue.remove();
      for (Node n : r.adjacent) {
        if (!n.marked) {
          n.marked = true;
          queue.add(n);
        }
      }
      visit(r);
    }
  }

  void dfsR(Node r) {
    if (r == null)
      return;
    r.marked = true;
    visit(r);
    for (Node n : r.adjacent) {
      if (!n.marked) {
        dfsR(n);
      }
    }
  }

  void dfsR(int index) {
    Node r = nodes[index];
    dfsR(r);
  }

  void dfsR() {
    dfsR(0);
  }

  void visit(Node n) {
    System.out.print(n.data + " ");
  }
}
```




