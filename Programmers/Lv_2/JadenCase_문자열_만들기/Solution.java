package Programmers.Lv_2.JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int sLength = s.length();
        char initialChar = check(s.charAt(0));
        answer.append(initialChar);
        for (int i = 1; i < sLength; i++){
            char target = s.charAt(i);
            char currentChar;
            if (s.charAt(i-1) == ' ') {
                currentChar = check(target);
                answer.append(currentChar);
                continue;
            }
            currentChar = Character.toLowerCase(target);
            answer.append(currentChar);
        }
        return answer.toString();
    }

    private char check(char c) {
        try {
            return Character.toUpperCase(c);
        } catch (Exception e) {
            return c;
        }
    }
    // StringBuilder에서 값을 넣는 append() 메소드는 char타입도 넣을 수 있다.
    // char 타입은 Character.toUpperCase(char c), Character.toLowerCase(char c)라는 스태틱 메서드를 사용한다.
    // String 타입이 str.toUpperCase() 처럼 사용 하는 형태와는 차이가 있다.
}
