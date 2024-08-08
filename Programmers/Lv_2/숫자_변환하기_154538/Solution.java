package Programmers.Lv_2.숫자_변환하기_154538;

import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] popped = q.poll();
            int num = popped[0];
            int cnt = popped[1];

            if (num > y) continue;

            if (num == y) {
                return cnt;
            } else {
                cnt++;
                if (!visited.contains(num + n)) {
                    visited.add(num + n);
                    q.add(new int[]{num + n, cnt});
                }
                if (!visited.contains(num * 2)) {
                    visited.add(num * 2);
                    q.add(new int[]{num * 2, cnt});
                }
                if (!visited.contains(num * 3)) {
                    visited.add(num * 3);
                    q.add(new int[]{num * 3, cnt});
                }
            }
        }
        return -1;
    }
}
