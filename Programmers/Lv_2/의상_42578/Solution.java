package Programmers.Lv_2.의상_42578;

import java.util.*;
class Solution {
    Map<String, Integer> map;
    public int solution(String[][] clothes) {
        int answer = 1;
        this.map = new HashMap<>();
        for (String[] clothe: clothes) {
            String clotheKind = clothe[1];
            if (map.containsKey(clotheKind)) {
                map.put(clotheKind, map.get(clotheKind) +1);

            } else {
                map.put(clotheKind, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue()+1);
        }

        return answer-1;
    }
}
