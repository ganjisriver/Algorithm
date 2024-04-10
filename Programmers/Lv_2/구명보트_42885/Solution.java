package Programmers.Lv_2.구명보트_42885;

import java.util.*;
import java.util.*;
class Solution {
    Deque<Integer> q;
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        this.q = new ArrayDeque();
        for (int person : people) {
            q.add(person);
        }
        while (q.size() > 1) {
            int lastWeight = q.pollLast();
            int firstWeight = q.peek();
            if(firstWeight + lastWeight <= limit && !q.isEmpty()) {
                q.pollFirst();
            }
            answer++;
        }
        if(!q.isEmpty()) {
            answer++;
        }

        return answer;
    }
}
