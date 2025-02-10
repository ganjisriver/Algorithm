package BOJ.문제집.역대DP연습셋기출문제.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int index = 0; index < N; index++) {
                    sticker[row][index] = Integer.parseInt(st.nextToken());
                }
            }
            if (N < 2) {
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
                continue;
            }
            int[][] dp = new int[2][N];
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = sticker[1][0] + sticker[0][1];
            dp[1][1] = sticker[0][0] + sticker[1][1];
            for (int index = 2; index < N; index++) {
                dp[0][index] = Math.max(Math.max(dp[0][index-2], dp[1][index-2]), dp[1][index-1]) + sticker[0][index];
                dp[1][index] = Math.max(Math.max(dp[0][index-2], dp[1][index-2]), dp[0][index-1]) + sticker[1][index];
            }
            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }
}
