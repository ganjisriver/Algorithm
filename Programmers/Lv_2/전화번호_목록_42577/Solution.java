package Programmers.Lv_2.전화번호_목록_42577;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // 접두어라서 sort로 해결이 가능한데, 접미어 같은 경우일 때는 어떻게 해결을 해야하는가 고민이 있다.
        // 접두어가 포함되어있느냐? 라고 묻는다면 sort를 이용하는게 꽤 좋은 방법이라는 것이 좋아 보입니다.
        // subString이 아닌 startsWith, endsWith라는 메소드도 있다는 것을 기억하자.

        Arrays.sort(phone_book);
        int bookLength = phone_book.length;
        if (bookLength == 1) {
            return false;
        }
        boolean answer = true;
        for(int i = 0; i < bookLength-1; i++) {
            String prev = phone_book[i];
            String next = phone_book[i+1];
            int prevLength = prev.length();
            int nextLength = next.length();
            if (prevLength > nextLength) {
                continue;
            }
            if (prev.equals(next.substring(0, prev.length()))) {
                return false;
            }
        }
        return answer;
    }
}