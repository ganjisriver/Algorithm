package Programmers.Lv_2.두_큐_합_같게_만들기_118667;

import java.util.*;
class Solution {
    private long q1Sum = 0;
    private long q2Sum = 0;
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public int solution(int[] queue1, int[] queue2) {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        int size = queue1.length;
        for (int i = 0; i < size; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            q1Sum += (long) queue1[i];
            q2Sum += (long) queue2[i];
        }
        int answer = execute(size);
        return answer;
    }

    private int execute(int size) {
        int cnt = 0;
        while (cnt < size*4+1) {
            if (q1Sum > q2Sum) {
                long poped = (long) q1.poll();
                q2.add((int)poped);
                q1Sum -= poped;
                q2Sum += poped;
            } else if (q1Sum < q2Sum) {
                long poped = (long) q2.poll();
                q1.add((int)poped);
                q1Sum += poped;
                q2Sum -= poped;
            } else {
                return cnt;
            }
            cnt++;
        }
        return -1;
    }
}