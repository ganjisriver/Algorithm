package Programmers.Lv_2.괄호_변환_60058;

import java.util.*;
class Solution {
    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.equals("")) {
            return "";
        }

        // 2. 문자열을 두 균형잡힌 괄호 문자열 u, v로 분리합니다.
        String[] dividedString = divide(p);
        String u = dividedString[0];
        String v = dividedString[1];


        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(checkRightString(u)) {
            String newV = solution(v);
            //3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u+newV;
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            // 4-1 빈 문자열에 첫 번째 문자로, '('를 붙입니다.
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            // 4-2 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            sb.append(solution(v));
            // 4-3 ')'를 다시 붙입니다.
            sb.append(')');
            // 4-4 u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            sb.append(makeReverse(u));
            // 4-5 생성된 문자열을 반환합니다.
            return sb.toString();
        }


    }

    private String makeReverse(String u) {
        String newString = u.substring(1, u.length()-1);
        int size = newString.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            Character str = newString.charAt(i);
            if(str.equals('(')) {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    private boolean checkRightString(String p) {
        Stack<Character> stack = new Stack<>();
        int size = p.length();
        for(int i = 0; i < size; i++) {
            Character str = p.charAt(i);
            if (str.equals('(')) {
                stack.push(str);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(!stack.peek().equals('(')) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    private String[] divide(String p) {
        String[] arr = new String[2];
        int left = 0;
        int right = 0;
        int size = p.length();
        for (int i =0; i< size; i++) {
            if(p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                arr[0] = p.substring(0, left+right);
                arr[1] = p.substring(left+right, size);
                break;
            }
        }

        return arr;
    }
}