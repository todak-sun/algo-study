## 프로그래머스 코딩테스트 연습 > 2020 카카오 인턴십 > 키패드누르기

### 문제 설명
스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀있습니다.

|키|패|드|
|----|----|----|
|`1`|`2`|`3`|
|`4`|`5`|`6`|
|`7`|`8`|`9`|
|`*`|`0`|`#`|

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 `*` 키패드에 오른손 엄지손가락은 `#` 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.<br/>

1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 `1`, `4`, `7`을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 `3`, `6`, `9`를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 `2`,`5`,`8`,`0`을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.<br/>
   4-1.  만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

<br/>

### 제한사항

- numbers 배열의 크기는 1 이상 1,000 이하입니다.
- numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
- hand는 `"left"` 또는 `"right"` 입니다.
    - `"left"`는 왼손잡이, `"right"`는 오른손잡이를 의미합니다.
- 왼손 엄지손가락을 사용한 경우는 `L`, 오른손 엄지손가락을 사용한 경우는 `R`을 순서대로 이어붙여 문자열 형태로 return 해주세요.
  <br/>

--- 

### 입출력 예

|numbers | hand|result|
|----------|-----|-----------------|
|[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]|`"right"`|`LRLLLRLLRRL`
|[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]|`"left"`|`LRLLRRLLLRR`
|[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]|`"right"`|`LLRLLRLLRL`


<br/>

### 입출력 예 설명
#### 입출력 예 #1

순서대로 눌러야 할 번호가 [1,3,4,5,8,2,1,4,5,9,5] 이고, 오른손잡이입니다.

|왼손위치|오른손위치|눌러야할숫자|사용한손|설명|
|-----|-----|-----|-----|---------------|
|`*`|`#`|`1`|L| 1은 왼손으로 누릅니다.|
|`1`|`#`|`3`|R| 3은 오른손으로 누릅니다.|
|`1`|`3`|`4`|L| 4은 왼손으로 누릅니다.|
|`4`|`3`|`5`|L| 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다. |
|`5`|`3`|`8`|L| 왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다. |
|`8`|`3`|`2`|R| 왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다. |
|`8`|`2`|`1`|L| 1은 왼손으로 누릅니다.|
|`1`|`2`|`4`|L| 4은 왼손으로 누릅니다.|
|`4`|`2`|`5`|R| 왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다. |
|`4`|`5`|`9`|R| 9는 오른손으로 누릅니다.|
|`4`|`9`|`5`|L| 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.  |

따라서 `LRLLLRLLRRL`을 return 합니다.


  <br/>

#### 입출력 예 #2

왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 `LRLLRRLLLRR`이 됩니다.

<br/>

#### 입출력 예 #3

오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 `LLRLLRLLRL`이 됩니다.

<br/>


> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/67256)

<br/>


--- 

### 해결과정
1. 왼손고정 : `1`, `4`, `7`, `*`

   1-1.  왼손 고정 값 구하는 법 : (들어온 수 % 3 == 1)
2. 오른손고정 : `3`, `6`, `9`, `#`

   2-1. 오른손 고정 값 구하는 법 : (들어온 수 % 3 == 0)
3. 시작위치 : L - `*` , R - `#`
4. `r_temp` , `l_temp`변수를 사용하여 손가락위치 기억
5. 맨 아랫줄의 `*` `0` `#` 은 각각 `10` `11` `12` 로 치환하여 계산


|키|패|드|
|---|---|---|
|`1`|`2`|`3`|
|`4`|`5`|`6`|
|`7`|`8`|`9`|
|`10`|`11`|`12`|

6. 현재 위치에서 들어온 수 까지의 거리 구하기

   6-1. 움직일 수 있는 방향 : 상하좌우

#### 소요거리 구하기

- 좌표를 이용하여 소요거리 계산

|''|0|1|2|
|---|---|---|---|
|**0**|`1`<br/>(0,0)|`2`<br/>(0,1)|`3`<br/>(0,2)|
|**1**|`4`<br/>(1,0)|`5`<br/>(1,1)|`6`<br/>(1,2)|
|**2**|`7`<br/>(2,0)|`8`<br/>(2,1)|`9`<br/>(2,2)|
|**3**|`10`<br/>(3,0)|`11`<br/>(3,1)|`12`<br/>(3,2)|

- 소요거리 구하는 법 : `|(현재위치 - 1) / 3| + |(현재위치 - 1) % 3|`
- `Java`로 변환 : `Math.abs` 메소드 사용
- `getDistance` 메소드 생성

```java
public class SolutionSample {
    public static int getDistance(int temp, int number) {
        temp = (temp == 0) ? 10 : temp - 1;
        number = (number == 0) ? 10 : number - 1;

        int temp_x = temp / 3;
        int temp_y = temp % 3;

        int number_x = number / 3;
        int number_y = number % 3;

        return Math.abs(number_x - temp_x) + Math.abs(number_y - temp_y);
    }
}
```
- temp : 현재 위치, number : 다음에 누를 위치
- 현재 위치와 이동할 위치를 좌표로 변경, 둘의 차이를 구해 소요거리 반환


--- 

### Full Source

```java
import java.util.ArrayList;

public class Solution7 {
    public String solution1(int[] numbers, String hand) {
        String answer = "";
        int r_temp = 12;
        int l_temp = 10;

        for(int i : numbers){
            i = (i == 0)? 11 : i;
            int remain = i % 3;
            if(remain == 0){
                r_temp = i;
                answer = answer + "R";
            }else if(remain == 1){
                l_temp = i;
                answer = answer + "L";
            }else {
                int r_distance = getDistance(r_temp, i);
                int l_distance = getDistance(l_temp, i);

                if (r_distance == l_distance) {
                    if ("right".equals(hand)) {
                        answer = answer + "R";
                        r_temp = i;
                    } else {
                        answer = answer + "L";
                        l_temp = i;
                    }

                } else if (r_distance > l_distance) {
                    answer = answer + "L";
                    l_temp = i;
                } else {
                    answer = answer + "R";
                    r_temp = i;
                }
            }
        }

        return answer;
    }

    public static int getDistance(int temp, int number){
        temp = (temp == 0) ? 10 : temp - 1;
        number = (number == 0) ? 10 : number - 1;

        int temp_x = temp / 3;
        int temp_y = temp % 3;

        int number_x = number / 3;
        int number_y = number % 3;
        return Math.abs(number_x - temp_x) + Math.abs(number_y - temp_y);
    }
}
```