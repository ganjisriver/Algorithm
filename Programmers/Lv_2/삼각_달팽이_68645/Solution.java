package Programmers.Lv_2.삼각_달팽이_68645;

import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<List<Integer>> snare = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            snare.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                snare.get(i).add(0);
            }
        }
        int[][] direction = {{1, 0}, {0, 1},{-1, -1}};
        int k = 1;
        int r = 0;
        int c = 0;
        int idx = 0;
        snare.get(r).set(c, 1);
        while (k < n*(n+1)/2) {
            k+= 1;
            int nr = r + direction[idx][0];
            int nc = c + direction[idx][1];
            if (nr >= n || nc >= n || snare.get(nr).get(nc) != 0) {
                if (idx == 2) {
                    idx = 0;
                } else {
                    idx++;
                }
            }
            r = r + direction[idx][0];
            c = c + direction[idx][1];
            snare.get(r).set(c, k);
        }
        int[] answer = new int[n*(n+1)/2];
        int ansIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[ansIdx] = snare.get(i).get(j);
                ansIdx++;
            }
        }

        return answer;
    }
}