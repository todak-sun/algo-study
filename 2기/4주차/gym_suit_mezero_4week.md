# 프로그래머스 코딩테스트 연습 > 탐욕법(Greedy) > 체육복

## 문제설명

점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.<br/> 
다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. <br/>
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. <br/>
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. <br/>
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다. <br/>

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,<br/>
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

### 제한사항
- 전체 학생의 수는 2명 이상 30명 이하입니다.
- 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. 
- 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. 
- 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다. 
- 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,<br/>
  남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
  
### 입출력 예

|n|lost|reserve|return|
|---|---|---|---|
|5|[2,4]|[1,3,5]|5
|5|[2,4]|[3]|4
|3|[3]|[1]|2

### 입출력 설명 예
#### 예제 #1
1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다. 

#### 예제 #2
3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/42862)


---

## 문제 풀이

### 문제 해석
```
- n: 총 학생 수<br/>
- lost : 도난 당한 학생 배열 <br/>
- reserve : 여벌옷을 갖고 있는 학생 배열 <br/>
- 규칙 : 잃어버린 친구의 바로 앞 혹은 바로 뒤 친구만 빌려주기 가능 <br/>
ex) 잃어버린 사람 1 : 빌려줄수있는 사람 2 / 잃어버린 사람 2: 빌려줄수있는 사람 1,3 
```

### 풀이설명
```
1. 일단 배열 -> ArrayList 변환 : 삭제 용이
2. answer : 전체 인원 - 도난당한 항생의 수
3. 도둑맞았지만, 여벌의 옷을 가져온 아이들은 도난된 숫자에서 제외, lostList에서도 삭제 
4. lostList를 for문으로 돌면서 빌릴 수 있는 지 탐색 -> 여벌list에서 해당 학생 삭제, 인원수++ 

처음에는 단순히 비교만 하면 되겠다 싶었는데, 문제 지문을 제대로 보니 그럴 수 없었다. 
한 사람이 두명에게 빌려줄 수 없기 때문에 연속된 숫자가 나왔을 때를 대비하여 빌려준 사람을 리스트에서 제외시켰다. 
```

### Full Code 

```java 
import java.util.ArrayList;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int temp : reserve){
            reserveList.add(temp);
        }

        ArrayList<Integer> lostList = new ArrayList<>();
        for(int temp : lost){
            lostList.add(temp);
        }

        for(int i : lost){
            if(reserveList.contains(i))  {
                reserveList.remove(reserveList.indexOf(i));
                lostList.remove(lostList.indexOf(i));
                answer++;
            }
        }

        for(int i = 0; i < lostList.size(); i++) {
            if (reserveList.contains(lostList.get(i) + 1)) {
                reserveList.remove(reserveList.indexOf(lostList.get(i) + 1));
                answer++;
            } else if (reserveList.contains(lostList.get(i) - 1)) {
                reserveList.remove(reserveList.indexOf(lostList.get(i) - 1));
                answer++;
            }
        }
        return answer;
    }
}
```

### 사용 메소드
```
1. ArrayList.contains(Object o) : ArrayList 에서 찾고자 하는 값을 넣으면 return T/F;
2. ArrayList.indexOf(Object o) : ArrayList 에서 찾고자 하는 값을 넣으면 해당 값의 return index; 없을 경우 -1
3. ArrayList.remove(int index) : 삭제하고자 하는 값의 index를 넣으면 해당 인덱스 삭제 
```