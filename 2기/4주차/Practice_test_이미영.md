## 프로그래머스 코딩테스트 연습 > 완전탐색 > 모의고사 

### 문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. <br />
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.<br />

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... <br />
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...<br />
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...<br />

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, <br />
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한조건

- 시험은 최대 10,000 문제로 구성되어있습니다.
- 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
- 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
  <br/>

### 입출력 예

|answers | return |
|---|---|
|[1,2,3,4,5]|[1]
|[1,3,2,4,2]|[1,2,3]


<br/>

### 입출력 예 설명
입출력 예 #1
- 수포자 1은 모든 문제를 맞혔습니다. 
- 수포자 2는 모든 문제를 틀렸습니다. 
- 수포자 3은 모든 문제를 틀렸습니다. 

입출력 예 #2
- 모든 사람이 2문제씩을 맞췄습니다. 



---
## 풀이

주어진 패턴에 맞게 찍는 수포자들의 점수를 측정하는 문제로써 많은 문제를 맞춘 사람을 출력하는 문제였다.<br />
문제가 나온 일정한 패던을 배열로 줌으로 써, 반복할 수 있도록 확인. <br/>
답안지의 수가 몇 개가 주어질지는 알 수 없으므로 `%` 연산자를 사용하였다. <br/>

```
if(answers[i] == user1[i%user1.length]){
count[0]++;
}
```
윗 내용에서 `if(answers[i] == user1[i%user1.length])` 답안지 배열과 유저의 배열를 비교하는 연산 부분이다. <br/>
계산하여 두 변수의 값이 같을 경우 count배열에 해당하는 인덱스에 맞춘 갯수를 추가해서 총 맞은 갯수를 확인한다. <br/>
이후에 `Math.max(a,b)` 메소드를 사용하여 최대값을 구해주고, 그에 맞는 유저를 확인하여 배열로 만들어 리턴했다.   


## Full Source

```java
import java.util.ArrayList;

public class Solution10 {
    public int[] solution(int[] answers){
        int[] answer = {};
        int[] user1 = {1,2,3,4,5};
        int[] user2 = {2,1,2,3,2,4,2,5};
        int[] user3 = {3,3,1,1,2,2,4,4,5,5};

        int[] count = {0,0,0};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == user1[i%user1.length]){
                count[0]++;
            }
            if(answers[i] == user2[i%user2.length]){
                count[1]++;
            }
            if(answers[i] == user3[i%user3.length]){
                count[2]++;
            }
        }

        int maxScore = Math.max(count[0], Math.max(count[1], count[2]));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < count.length; i++){
            if(maxScore == count[i]){
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
```

### 다른 사람들의 풀이

나의 경우에는 list에 넣어 다시 그걸 answer 배열로 바꿔서 return을 해주었다. <br />
하지만 많은 사람들은 list에서 바로 `list.stream().mapToInt(i->i.intValue()).toArray();` 를 사용하여 리턴했다.<br /> 

```java
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
```


---
> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/42840)