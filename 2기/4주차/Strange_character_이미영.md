## 프로그래머스 코딩테스트 연습 > 연습문제 > 이상한 문자 만들기

### 문제 설명
문자열 s는 한 개 이상의 단어로 구성되어 있습니다.<br />
각 단어는 하나 이상의 공백문자로 구분되어 있습니다.<br />
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.<br />


### 제한사항

- 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
- 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

  <br/>

### 입출력 예

|s | return |
|---|---|
|"try hello world"|"TrY HeLlO WoRlD"



<br/>

### 입출력 예 설명
"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다.<br/>
각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. <br/>
따라서 "TrY HeLlO WoRlD" 를 리턴합니다.

---

## 문제풀이

### 실패
```java
public class StrangeCharacter {
    public String Solution(String s) {
        StringBuffer answer = new StringBuffer();
        String temp;
        String[] arr = s.split(" ");
        int size = arr.length;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if ((j % 2) == 0) {
                    temp = Character.toString(arr[i].charAt(j)).toUpperCase();
                } else {
                    temp = Character.toString(arr[i].charAt(j)).toLowerCase();
                }
                answer.append(temp);
            }
            answer.append(" ");
        }
        return answer.toString();
    }
}
```
처음 작성했던 풀이었다. <br/>
`toUpperCase()`와 `toLowerCase()`를 사용한 풀이법으로, <br />
`String[]`에 split 하여 단어들을 넣고 그 단어들의 각각의 인덱스를 확인하여 진행했다.<br />
하지만, 틀렸다. <br />
<br />
`공백`의 소중함을 알지 못했던 나는 마지막에 공백을 또 넣는 치명타를 날렸다. <br />
결국 다시 제대로 풀기로 했다. <br />
temp 변수도 마음에 안들고 이래저래 마음에 안드니 다시 하는 걸로 ... <br />
<br />


### 성공
```java
public class StrangeCharacter {
    public String Solution1(String s) {
        int i = 0;
        StringBuffer answer = new StringBuffer();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != ' ') {
                if ((i % 2) == 0) {
                    answer.append(Character.toString(s.charAt(j)).toUpperCase());
                } else {
                    answer.append(Character.toString(s.charAt(j)).toLowerCase());
                }
                i++;
            } else {
                i = 0;
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}
```
차분하게 다시 풀어보았다. <br />
띄어쓰기가 문제라면 굳이 띄어쓰기로 split 하지않고 사용하는 방법을 생각해 보았다.<br />
변수 `i`는 총 문장의 **인덱스로 사용**하였으며, 문장을 처음부터 끝까지 돌면서 *공백일 경우*에 `answer`에 **공백을 추가**했다. <br/>



---
> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/12930)