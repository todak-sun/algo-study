# 프로그래머스 코딩테스트 연습 > 연습문제 > 직사각형 별찍기

## 문제설명
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다. <br/>
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

### 제한사항
- n과 m은 각각 1000 이하인 자연수 입니다.

### 예시

입력 <br/>
```
5 3
```

출력 <br/>
```
*****
*****
*****
```

---
## 문제풀이

```java
import java.util.Scanner;

public class Solution {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < b ; i++){
            for(int j = 0; j < a; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
```

