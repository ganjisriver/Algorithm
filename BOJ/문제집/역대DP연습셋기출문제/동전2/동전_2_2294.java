package BOJ.문제집.역대DP연습셋기출문제.동전2;



import java.io.*;
import java.util.*;

class 동전_2_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int[] dp = new int[K+1];
        Arrays.fill(dp, 1000001);
        dp[0] = 0;
        for (int index = 0; index < N; index++) {
            coins[index] = Integer.parseInt(br.readLine());
        }
        for (int coin : coins) {
            for (int target = coin; target <= K; target++) {
                if(K - target >= 0) {
                    dp[target] = Math.min(dp[target - coin] + 1, dp[target]);
                }
            }
        }
        int answer = dp[K];
        if (answer == 1000001) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}