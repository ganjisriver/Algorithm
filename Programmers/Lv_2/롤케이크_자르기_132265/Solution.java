package Programmers.Lv_2.롤케이크_자르기_132265;

import java.util.*;
class Solution {
    private Map<Integer, Integer> firstMap;
    private Map<Integer, Integer> lastMap;
    private int answer;
    public int solution(int[] topping) {
        answer = 0;
        firstMap = new HashMap<>();
        lastMap = new HashMap<>();
        int size = topping.length;
        setLastMap(size, topping);

        for (int i = 0; i < size; i++) {
            int target = topping[i];
            // 1. fisrtMap 체크 및 추가
            checkFirstMap(target);
            // 2. lastMap 체크 및 추가
            checkLastMap(target);
            // firstMap이 lastMap보다 커지면 return
            int firstMapSize = firstMap.size();
            int lastMapSize = lastMap.size();
            if (firstMapSize > lastMapSize) {
                return answer;
            } else if (firstMapSize == lastMapSize) {
                answer++;
            }

        }
        return answer;
    }
    private void checkLastMap(int target) {
        if (lastMap.get(target) == 1) {
            lastMap.remove(target);
        } else {
            lastMap.put(target, lastMap.get(target) - 1);
        }
    }
    private void checkFirstMap(int target) {
        if (firstMap.containsKey(target)) {
            firstMap.put(target, firstMap.get(target) + 1);
        } else {
            firstMap.put(target, 1);
        }
    }

    private void setLastMap(int size, int[] topping) {
        for (int i = 0; i < size; i++) {
            int target = topping[i];
            if (lastMap.containsKey(target)) {
                lastMap.put(target, lastMap.get(target)+1);
            } else {
                lastMap.put(target, 1);
            }
        }
    }
}
