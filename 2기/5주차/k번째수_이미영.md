## 프로그래머스 코딩테스트 연습 > 정렬 > K번째 수 

### 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다. <br/>
예를들어 array가 [1,5,2,6,3,7,4], i=2, j-5, k=3 이라면
1. array의 2번째부터 5번째까지 자르면 [5,2,6,3]입니다. 
2. 1에서 나온 배열을 [2,3,5,6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다. 

배열 array, [i,j,k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,<br />
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 <br />
배열에 담아 return 하도록 solution 함수를 작성해주세요. 

### 제한조건

- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.
  <br/>

### 입출력 예

|array | commands  | return |
|---|---|--------|
|[1,5,2,6,3,7,4]|[[2,5,3],[4,4,1],[1,7,3]] |[5,6,3]|

### 입출력 예 설명
[1,5,2,6,3,7,4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2,3,5,6]의 세번째 숫자는 5입니다. <br />
[1,5,2,6,3,7,4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫번째 숫자는 6입니다.<br />
[1,5,2,6,3,7,4]를 1번째부터 7번째까지 자릅니다. [1,2,3,4,5,6,7]의 세번째 숫자는 3입니다. <br />



<br/>

--- 

## 풀이
- 주어진 배열에 일부를 추출해서 정렬시키고 그 중에 하나를 K번째 숫자를 추출. 

```java
import java.util.*;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            List<Integer> temp = new ArrayList<Integer>();
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            for(int j = start; j <= end; j++){
                temp.add(array[j]);
            }
            Collections.sort(temp);
            answer[i] = temp.get(commands[i][2]-1);
        }

        return answer;
    }
}
```

정말 정석대로 풀었다; <br/>
가져와서 추출해서 Collections를 사용한 정렬을 해서, 그 배열에서 숫자를 추출하기... <br />
비록 정답은 맞았지만, 프로그래머스에서 +1점을 준 가련한 풀이. <br />

다른 사람의 풀이를 보는데 나온 코드 . 

```java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
```

Arrays.copyOfRange ... <br/>
배열을 복사하는 메소드이다.<br/>
Arrays.copyOfRange(원본배열, 복사할 길이);<br/>
Arrays.copyOfRange(원본배열, 시작인덱스, 마지막인덱스);<br/>

이 메소드를 이용하면 내가 Start, end 라고 변수를 선언했던 부분이 필요가 없다.<br/> 
또한 ArrayList를 사용하지 않아도 된다. <br/>

기본 메소드를 많이 알아야 좀 더 풀이가 쉬워지는 것 같다. <br/>


---
> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/42748)