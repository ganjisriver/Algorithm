package Programmers.Lv_2.쿼드압축_후_개수_세기_68936;

import java.util.*;
class Solution {
    int[] answer;
    int[][] arr;
    public int[] solution(int[][] arr) {
        this.answer = new int[2];
        this.arr = arr;
        int size = arr.length;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                answer[arr[r][c]] += 1;
            }
        }
        int[] start = {0, 0};
        int[] end = {size-1, size-1};
        compressQuad(start, end);
        return answer;
    }

    private void compressQuad(int[] start, int[] end) {
        if (Arrays.equals(start, end)) {
            return;
        }
        int standard = arr[start[0]][start[1]];
        for (int r = start[0]; r <= end[0]; r++) {
            for (int c = start[1]; c <= end[1]; c++) {
                if (standard != arr[r][c]) {
                    compressQuad(new int[]{start[0], start[1]}, new int[]{(start[0] + end[0])/2, (start[1] + end[1]) /2});
                    compressQuad(new int[]{start[0], (start[1] + end[1]) /2 +1}, new int[]{(start[0] + end[0])/2, end[1]});
                    compressQuad(new int[]{(start[0] + end[0])/2 +1 , start[1]}, new int[]{end[0], (start[1] + end[1]) /2});
                    compressQuad(new int[]{(start[0] + end[0]) /2 +1, (start[1] + end[1]) /2 +1}, new int[]{end[0], end[1]});
                    return;
                }

            }
        }

        answer[standard] -= (end[0] - start[0]+1)*(end[0] - start[0] +1) - 1;
    }
}
