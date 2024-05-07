package Programmers.Lv_2.할인_행사_131127;

import java.util.*;
class Solution {
    Map<String, Integer> wantMap;
    public int solution(String[] want, int[] number, String[] discount) {
        this.wantMap = new HashMap<>();
        int index = 0;
        for (String element: want) {
            wantMap.put(element, index);
            index++;
        }

        int[] current = new int[number.length];

        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            String menu = discount[i];
            if (wantMap.containsKey(menu)) {
                current[wantMap.get(menu)] += 1;
            }
            q.add(menu);
        }
        int answer = 0;
        answer += check(number, current);
        int day = 0;
        int size = discount.length;
        while (size > day +10) {
            int nextIndex = day+10;
            String popedMenu = q.poll();
            String addedMenu = discount[nextIndex];
            q.add(addedMenu);
            if (wantMap.containsKey(popedMenu)) {
                current[wantMap.get(popedMenu)] -= 1;
            }
            if (wantMap.containsKey(addedMenu)) {
                current[wantMap.get(addedMenu)] += 1;
            }
            day++;
            answer += check(number, current);
        }

        return answer;
    }
    private int check(int[] number, int[] current) {
        if (Arrays.equals(number, current)) {
            return 1;
        }
        return 0;
    }
}