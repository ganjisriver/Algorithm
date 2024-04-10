package Programmers.Lv_2.큰_수_만들기_42883;

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int len = number.length();
        int remain = len - k; // 남은 숫자의 개수

        // 스택을 활용하여 큰 숫자 구성
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char digit = number.charAt(i);
            // 스택의 맨 위의 숫자가 현재 숫자보다 작으면 스택에서 pop하고, k를 감소시킴
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 남은 숫자 중에서 가장 큰 숫자 구성
        while (stack.size() > remain) {
            stack.pop();
        }

        // 스택에 있는 숫자들을 문자열로 변환하여 answer에 추가
        for (char ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}