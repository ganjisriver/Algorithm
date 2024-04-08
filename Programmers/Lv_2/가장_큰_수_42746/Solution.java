package Programmers.Lv_2.가장_큰_수_42746;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] stringArray = new String[numbers.length];
        for(int i = 0; i< numbers.length; i++) {
            stringArray[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(stringArray, (idx1, idx2) -> {
            if (Integer.valueOf((idx1 + idx2)) > Integer.valueOf((idx2 + idx1))) {
                return -1;
            } else if (Integer.valueOf((idx1 + idx2)) < Integer.valueOf((idx2 + idx1))) {
                return 1;
            } else {
                return 0;
            }
        });

        if(stringArray[0].equals("0")) {
            return "0";
        }
        for(String str: stringArray) {
            sb.append(str);
        }
        return sb.toString();
    }



}
