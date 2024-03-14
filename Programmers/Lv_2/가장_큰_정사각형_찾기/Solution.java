package Programmers.Lv_2.가장_큰_정사각형_찾기;

import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length;
        int column = board[0].length;
        int[][] dp = new int[row + 1][column + 1];

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                if (board[i - 1][j - 1] == 1) {
                    int minValue = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = minValue + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}