package Programmers.Lv_2.짝지어_제거하기_12973;

import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    public int solution(String s) {
        int answer = -1;
        Deque<Character> deque = new LinkedList<>();
        int stringLength = s.length();
        for(int i = 0; i < stringLength; i++) {
            char target = s.charAt(i);
            if(deque.isEmpty()) {
                deque.add(target);
                continue;
            }
            if(deque.getLast() == target) {
                deque.pollLast();
            } else {
                deque.addLast(target);
            }
        }
        if (deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

    }
}
