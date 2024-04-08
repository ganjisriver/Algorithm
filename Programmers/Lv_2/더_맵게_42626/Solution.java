package Programmers.Lv_2.더_맵게_42626;

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for (int food : scoville) {
            q.offer(food);
        }

        while(q.size() > 1) {
            if (q.peek() >= K) {
                return answer;
            }
            int first = q.poll();
            int second = q.poll();
            int newFood = first + (second*2);
            q.offer(newFood);
            answer++;
        }
        if (q.peek() < K) {
            return -1;
        }
        return answer;
    }
}