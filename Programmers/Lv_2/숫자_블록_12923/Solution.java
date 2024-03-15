package Programmers.Lv_2.숫자_블록_12923;

import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        List<Integer> arr = new ArrayList<>();
        int start = (int) begin;
        int finish = (int) end;
        for(; start <= finish; start++) {
            if (start == 1) {
                arr.add(0);
                continue;
            }
            int count = 1;
            int beginSqrt = (int) Math.sqrt(start);
            for (int i = 2; i <= beginSqrt; i++) {
                if ((start % i == 0) && (start/i > count)) {
                    count = start/i;
                }
            }
            arr.add(count);
        }
        int arrLength = (int) (end-begin);
        int[] answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }

}
