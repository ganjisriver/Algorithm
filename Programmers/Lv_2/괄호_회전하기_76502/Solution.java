package Programmers.Lv_2.괄호_회전하기_76502;

import java.util.*;
class Solution {
    private Map<Character, Character> leftMap;
    private Map<Character, Character> rightMap;
    public int solution(String s) {
        leftMap = new HashMap<>();
        rightMap = new HashMap<>();
        char[] leftArray = {'{', '[', '('};
        char[] rightArray = {'}', ']', ')'};

        for (int i = 0; i < 3; i++) {
            leftMap.put(leftArray[i], rightArray[i]);
            rightMap.put(rightArray[i], leftArray[i]);
        }


        Deque<Character> deq = new ArrayDeque<>();
        int size = s.length();

        for (int i = 0; i < size; i++) {
            deq.addLast(s.charAt(i));
        }

        int answer = 0;
        for (int i = 0; i < size; i++) {
            rotate(deq);
            if(check(deq)) {
                answer++;
            }
        }

        return answer;
    }

    private void rotate (Deque<Character> deq) {
        char first = deq.pollFirst();
        deq.addLast(first);
    }
    private boolean check(Deque<Character> deq) {
        Deque<Character> deqClone = new ArrayDeque<>(deq);
        Stack<Character> stack = new Stack<>();
        int size = deq.size();
        for (int i = 0; i < size; i++) {
            char letter = deqClone.pollFirst();
            if (stack.isEmpty()) {
                if(rightMap.containsKey(letter)) {
                    return false;
                }
            } else {
                if (leftMap.containsKey(stack.peek())) {
                    if(leftMap.get(stack.peek()) == letter) {
                        stack.pop();
                        continue;
                    }
                }
            }
            stack.add(letter);

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}