# StarStamp


문제
====
카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
다음은 카카오 아이디의 규칙입니다.

+ 아이디의 길이는 3자 이상 15자 이하여야 합니다.
+ 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
+ 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고
규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
신규 유저가 입력한 아이디가 new_id 라고 한다면,

1. 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
1. 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
1. 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
1. 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
1. 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
1. 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
1. 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.




출처 : [프로그래머스](https://programmers.co.kr/learn/courses/30/lessons/72410 "프로그래머스")
------------------------------------------------------------



풀이
----
<pre>
<code>
public class NewId {
	public static void main(String[] args) {
		
		int step = 0;
		String str = "";
		
//		===============================================================
//		step0 시작
//		===============================================================
		str = "!@#$%^Jinwoo123.-_!@#";
		System.out.println("step" + step + " : " + str);
		
		
//		===============================================================
//		step1 모두 소문자로 치환
//		===============================================================
		str = str.toLowerCase();
		
		System.out.println("step" + ++step + " : " + str);
		
		
//		===============================================================
//		step2 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
//		===============================================================
		str = "!@#$%^Jinwoo123.-_!@#"; // 초기화
		String match = "[^a-z0-9\\_\\-\\.]";

		str = str.replaceAll(match, "");
		
		System.out.println("step" + ++step + " : " + str);
		
		
// 		===============================================================
//		step3 .이 2개이상 반복되면 .하나로 변경
// 		===============================================================
		str = ".1..2...3....4.........10"; // 초기화
		while(str.contains("..")) {
			str = str.replace("..", ".");
		}
		
		System.out.println("step" + ++step + " : " + str);
		
		
//		===============================================================
//		step4 .이 처음이나 끝에 있으면 없앰
//		===============================================================
		str = ".!@#$%^Jinwoo123.-_!@#."; // 초기화
		if(str.indexOf(".") == 0) {
			str = str.replaceFirst("\\.", "");
		}
		if(str.lastIndexOf(".") == str.length()-1) {
			str = str.substring(0, str.length() - 1);
		}
		
		System.out.println("step" + ++step + " : " + str);
		
		
//		===============================================================
//		step5 빈문자열이면 "a" 대입
//		===============================================================
		str = "";	// 빈문자열로 초기화
		if(str.length() < 1) {
			str = "a";
		}
		
		System.out.println("step" + ++step + " : " + str);
		
		
//		===============================================================
//		step6 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 제거 후 마침표가 끝에 위치한다면 .도 제거
//		===============================================================
		str = ".!@#$%^Jinwoo123.-_!@#."; // 초기화
		if(str.length() > 15) {
			str = str.substring(0, 15);
		}
		if(str.lastIndexOf(".") == str.length()-1) {
			str = str.substring(0, str.length() - 1);
		}
		
		System.out.println("step" + ++step + " : " + str);
		
		
// 		===============================================================
// 		step7 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될떄까지 반복해서 긑에 붙임
// 		===============================================================
		str = "ab";	// 초기화
		int strLow = 2;
		StringBuffer stringBuffer = new StringBuffer(str);
		int strLen = stringBuffer.length();
		
		if(strLen <= 2) {
			String strLast = stringBuffer.substring(stringBuffer.length() - 1, stringBuffer.length());
			for(int i = strLen; i <= strLow; i++) {
				stringBuffer.append(strLast);
			}
		}
		
		System.out.println("step" + ++step + " : " + stringBuffer);
		
	}
}
</code>
</pre>