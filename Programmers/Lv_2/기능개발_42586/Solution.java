package Programmers.Lv_2.기능개발_42586;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int progressLength = progresses.length;
        for (int i = 0; i < progressLength; i++) {
            int share = (100 - progresses[i]) / speeds[i];
            int day = (100 - progresses[i]) % speeds[i] == 0 ? share : share+1;
            q.offer(day);
        }
        int currentDay = 0;
        while (!q.isEmpty()) {
            int time = q.poll();
            if (currentDay < time) {
                currentDay = time;
            }
            int size = q.size();
            int count = 1;
            for (int i = 0; i < size; i++) {
                int first = q.peek();
                if (currentDay >= first) {
                    q.poll();
                    count++;
                } else {

                    break;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
