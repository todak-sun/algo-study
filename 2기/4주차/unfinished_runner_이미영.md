## 프로그래머스 코딩테스트 연습 > 해시 > 완주하지 못한 선수

### 문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, <br/>
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
<br/>

### 제한조건

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.
  <br/>

### 입출력 예

|participant |  completion  | return |
|---|---|--------|
|["leo", "kiki", "eden"]|["eden", "kiki"] |"leo"|
|["marina", "josipa", "nikola", "vinko", "filipa"]|["josipa", "filipa", "marina", "nikola"]|"vinko"|
|["mislav", "stanko", "mislav", "ana"] |["stanko", "ana", "mislav"]|"mislav"|


### 입출력 예
#### 예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다. <br />

#### 예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

#### 예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

<br/>

---

### 문제풀이 

#### 풀이 #1 ArrayList
참여자를 `ArrayList`에 추가하여 해결 했다. <br/>
`Array`의 경우 요소 삭제를 하려면 더 많은 시간을 필요로한다.  <br/> 
하지만 `ArrayList`는 쉽게 요소를 삭제 할 수 있기 때문에 `ArrayList`로 변경하여 풀이했다.  <br/> 
하지만, 중복 된 사항이 있을 경우 강제로 `for문`을 종료시켜야 하기 때문에 뭔가 마음에 들지 않는 풀이었다.  <br/> 
또한 문제 타이틀에 해시가 들어갔는데, *해시를 사용하지 않은 느낌*이었다.   <br/>

~~게다가 이 풀이의 경우 효율성테스트를 통과하지못했다. 결과만 잘 나오는 ... 더러운 코드...~~
```java
public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        ArrayList<String> arrayList = new ArrayList<>();
        for (String name : participant) {
            arrayList.add(name);
        }

        for (String name : completion) {
            for (String list : arrayList) {
                if (name.equals(list)) {
                    arrayList.remove(name);
                    break;
                }
            }
        }

        answer = arrayList.get(0);
        return answer;
    }
}
```
<br />

#### 풀이 #2 HashMap 
`HashMap`을 사용하여 풀이하었다. <br/>
참여자 배열을 `HashMap`에 추가하여 중복 된 선수들을 구분하기 위해 `value`에 **숫자를 더하여 추가**하였다. <br/>
`HashMap`은 **키의 복을 허용되지 않는다**는 부분을 이용하여, `put 메소드`로 같은 키에 값만 변경하여 추가해주었다. <br/>
그 이후 완주자배열를 `동일 HashMap`에 추가해주면서 `value`에 **숫자를 빼주면서 추가**했다. <br/>

```java
public class Solution {
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String name : participant){
            if(map.containsKey(name)){
                map.put(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }

        for(String name : completion){
            map.put(name, map.get(name)-1);
        }

        for(String name : map.keySet()){
            if(map.get(name) != 0){
                answer = name;
            }
        }

        return answer;
    }
}
```


생각보다 Hash를 잘 사용한거 같지 않다. 결과는 잘 나왔는데, 앞으로 문제 타이틀에 맞는 알고리즘을공부하면서 해야겠다...
<br/> <br/>
> 문제 출처: [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/42576)