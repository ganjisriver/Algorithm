package BOJ.문제집.역대DP연습셋기출문제.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];
        for (int index = 0; index < N; index++) {
            stair[index] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N][2];
        if (N == 1) {
            System.out.println(stair[0]);
            return;
        }
        dp[0][0] = stair[0];
        dp[0][1] = 0;
        dp[1][0] = stair[1];
        dp[1][1] = stair[0] + stair[1];
        for (int index = 2; index < N; index++) {
            dp[index][0] = Math.max(dp[index - 2][0] + stair[index], dp[index - 2][1] + stair[index]);
            dp[index][1] = dp[index - 1][0] + stair[index];
        }
        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}
