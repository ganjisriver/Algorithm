package Programmers.Lv_2.요격_시스템_181188;

import java.util.Deque;
import java.util.LinkedList;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> charDeque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if(charDeque.isEmpty()) {
                if(character == ')') {
                    return false;
                }
                charDeque.addLast(character);
                continue;
            }

            if (character == charDeque.getLast()) {
                charDeque.addLast(character);
            } else {
                charDeque.pollLast();
            }

        }

        if (charDeque.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
