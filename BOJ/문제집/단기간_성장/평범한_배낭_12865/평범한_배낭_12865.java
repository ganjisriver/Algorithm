package BOJ.문제집.단기간_성장.평범한_배낭_12865;

import java.io.*;
import java.util.*;

class 평범한_배낭_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][K + 1];
        int[][] things = new int[N][2];
        for (int index = 0; index < N; index++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            things[index] = new int[]{W, V};
        }
        for (int index = 0; index < N; index++) {
            Arrays.fill(dp[index], 0);
        }
        if (things[0][0] <= K) {
            dp[0][things[0][0]] = things[0][1];
        }
        for (int index = 1; index < N; index++) {
            for (int k = 0; k <= K; k++) {
                int weight = things[index][0];
                int value = things[index][1];
                if (k - weight >= 0) {
                    dp[index][k] = Math.max(dp[index-1][k-weight] + value, dp[index-1][k]);
                } else {
                    dp[index][k] = dp[index-1][k];
                }
            }
        }
        int answer = 0;
        for (int index = 0; index < K + 1; index++) {
            int value = dp[N-1][index];
            if (answer < value) {
                answer = value;
            }
        }
        System.out.println(answer);

    }
}
