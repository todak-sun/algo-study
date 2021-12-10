## 프로그래머스 코딩테스트 연습 > 연습 문제 > 시저 암호

### 문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. <br />
예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. <br />
"z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
<br/>

### 제한조건

- 공백은 아무리 밀어도 공백입니다.
- s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
- s의 길이는 8000이하입니다.
- n은 1 이상, 25이하인 자연수입니다.
  <br/>

### 입출력 예

|s |  n  | result |
|---|---|--------|
|"AB"|1 |"BC"|
|"z"|1|"a"|
|"a B z" |4|"e F d"|


<br/>




---
## 풀이 
char 자료형을 이용하여 char 자료형에 int 수를 더하는 방식으로 했다. <br />
문제는 `a`~`z` 까지 순환되어야하며, `A`~`Z`까지 순환되어야 한다는 것이었다.<br/><br/> 
일단 알파벳은 총 `26`글자이다. <br/>
그래서 생각 해 낸 것은 해당 글자에 `n`을 더한 후, 소문자와 대문자를 구분하여 해당 문자형에 마지막 글자와 비교하는 것이다. 

## Full Source

```java
public class Solution {
    public String solution1(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                c = (c + n) > 'z' ? (char) ((c + n) - 26) : (char) (c + n);
            } else if (Character.isUpperCase(c)) {
                c = (c + n) > 'Z' ? (char) ((c + n) - 26) : (char) (c + n);
            }
            answer = answer.append(c);
        }
        return answer.toString();
    }
}
```

### 다른 사람들의 풀이

처음에는 IF문을 사용하여 작성하였지만, 삼항연산자로 바꾸게 된 것은 단순히 보기 편하기 위해서였다. <br/> 
하지만 이 방식이 아닌 다른 방식들이 있을 것이라고 생각하고 다른 풀이들을 보았다.<br/>

```java
class Caesar {
    String caesar(String s, int n) {
        String result = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            result += ch;
        }
        return result;
    }
}
```

이 방식은 생각지도 못했던 방법이었다. 분명 char를 사용하는 것은 다름없으나 나와는 다른식으로 풀었기에 같이 첨부한다.  

---
> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/12926)
