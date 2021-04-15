# 코딩테스트 연습 > 연습문제 > 2016년

## 문제설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a, b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수 solution을 완성하세요.<br/>
요일의 이름은 일요일부터 토요일까지 각각 `"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"` 입니다. <br/>
예를 들어 a = 5, b = 24라면 2016년 5월 24일은 화요일이므로 "TUE"를 반환하세요.

### 제한 조건
- 2016년은 윤년입니다.
- 2016년 a 월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일 같은 날짜는 주어지지 않습니다. )

### 입출력 예
|a|b|result
|---|---|---|
|5|24|"TUE"

---

## 문제풀이

```java
import java.util.Calendar;

public class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        a = a -1;
        cal.set(2016, a<10? Integer.parseInt( "0"+a) : a, b<10? Integer.parseInt( "0"+b) : b);
        int i = cal.get(Calendar.DAY_OF_WEEK) -1;
        answer = week[i];
        return answer;
    }
}
```

#### 풀이 
```
a = a -1;
위 부분은 Java Calendar Library에 월의 경우 0~11까지 표기되기때문에 그에 맞게 해주기 위하여 빼준것.
Calendar.DAY_OF_WEEK은 해당 일자의 요일을 표시해주는 숫자이며, 
0~6까지로 표시되고, week 배열과 같이 SUN 부터 시작하여 SAT으로 끝난다.

난 JAVA의 기본 라이브러리인 Calendar를 사용했으므로, 윤년을 따로 계산하지 않았다.  
```
 
---
> 문제 출처 : [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/12901)
> 