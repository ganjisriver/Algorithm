package Programmers.Lv_2.테이블_해시_함수_147354;

import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] - o2[col-1] == 0) {
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        });
        int[] sArray = makeSArray(data);
        answer = sArray[row_begin];
        for (int index = row_begin+1; index <= row_end; index++) {
            answer = answer ^ sArray[index];
        }


        return answer;
    }
    private int[] makeSArray(int[][] data) {
        int size = data.length;
        int rowSize = data[0].length;
        int[] sArray = new int[size+1];
        sArray[0] = 0;
        for (int i = 0; i < size; i++) {
            int cnt = 0;
            for (int j = 0; j < rowSize; j++) {
                cnt += data[i][j] % (i+1);
            }
            sArray[i+1] = cnt;
        }
        return sArray;
    }
}