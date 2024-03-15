package Programmers.Lv_2.땅따먹기_12913;

import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0] = land[0];
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]) + land[i][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]) + land[i][1];
            dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]) + land[i][2];
            dp[i][3] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + land[i][3];
        }
        answer = Arrays.stream(dp[land.length-1]).max().getAsInt();
        return answer;
    }
}
