package Programmers.Lv_2.디펜스_게임_142085;

import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        int size = enemy.length;
        if (size <= k) {
            return size;
        }
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < size; index++) {
            int enemyOne = enemy[index];
            if (n < enemyOne) {
                if (k <= 0) {
                    return answer;
                }
                if (pq.isEmpty() || pq.peek() < enemyOne) {
                    answer++;
                    k--;
                    continue;
                }
                while (n < enemyOne &&!pq.isEmpty() && k > 0) {
                    n += pq.poll();
                    k--;
                }
            }
            pq.add(enemyOne);
            n -= enemyOne;
            answer++;
        }

        return answer;
    }
}
