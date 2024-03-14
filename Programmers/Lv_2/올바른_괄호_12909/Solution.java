package Programmers.Lv_2.올바른_괄호_12909;

import java.util.*;
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
