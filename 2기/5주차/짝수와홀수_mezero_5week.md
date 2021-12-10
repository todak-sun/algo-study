# 프로그래머스 코딩테스트 연습 > 연습문제 > 짝수와 홀수

## 문제설명
정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

### 제한사항
- num은 int범위의 정수입니다. 
- 0은 짝수입니다. 


### 입출력 예

|reserve|return|
|---|---|
|3|Odd
|4|Even
|0|Even

---

## 문제 풀이

```java
public class Solution{
    public String solution(int num) {
        String answer = "";
        if(num%2 == 0){
            answer = "Even";
        }else{
            answer = "Odd";
        }
        return answer;
    }
}
```

```java
public class Solution{
    public String solution(int num) {
        String answer = num % 2 == 0? "Even" : "Odd";
        return answer;
    }
}
```

> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/12937)