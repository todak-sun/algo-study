# 코딩테스트 연습 > 연습문제 > 같은 숫자는 싫어

### 문제설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. <br/>
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
- arr = [1,1,3,3,0,1,1] 이면 [1,3,0,1]을 return 합니다.
- arr = [4,4,4,3,3] 이면 [4,3]을 return 합니다.

배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return하는 solution 함수를 완성해주세요.

#### 제한 조건
- 배열 arr의 크기 : 1,000,000 이하의 자연수
- 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수

### 입출력 예
|arr | answer|
|---|---|
|[1,1,3,3,0,1,1]|[1,3,0,1]
|[4,4,4,3,3]|[4,3]

---

### 문제풀이
```java
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length-1]);

        int[] answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```

#### 해석
```
받은 배열의 앞, 뒤를 확인하여 비교한 후, 두개의 숫자가 다를 경우 list에 추가. 
이 경우 마지막 배열의 값이 추가되지 않으므로, list에 마지막 값을 추가. 
ArrayList -> Array 
```

---
> 문제 출처 : [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/12906)