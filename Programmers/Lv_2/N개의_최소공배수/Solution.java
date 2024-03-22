package Programmers.Lv_2.N개의_최소공배수;

import java.util.*;
class Solution {
    private Map<Integer, Integer> answerMap = new HashMap<>();
    private int answer = 1;
    public int solution(int[] arr) {

        for (int num: arr) {
            Map<Integer, Integer> currentMap = find(num);
            currentMap.forEach((key, value) -> {
                if (answerMap.containsKey(key)) {
                    int answerValue = answerMap.get(key);
                    answerMap.put(key, Math.max(answerValue, value));
                } else {
                    answerMap.put(key, value);
                }
            });

        }
        answerMap.forEach((key, value) -> {
            answer *= Math.pow(key, value);
        });
        return answer;
    }

    private Map<Integer, Integer> find(int num) {
        Map<Integer, Integer> currentMap = new HashMap<>();
        int numSqrt = (int) Math.sqrt(num);
        int numCopy = num;
        for (int i = 2; i <= numSqrt; i++) {
            int count = 0;
            boolean flag = false;
            while (numCopy % i == 0) {
                flag = true;
                count++;
                numCopy /= i;
            }
            if(flag == true) {
                currentMap.put(i, count);
            }
        }
        if (numCopy != 1) {
            currentMap.put(numCopy, 1);
        }
        return currentMap;
    }
}
