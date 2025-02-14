import java.io.*;
import java.util.*;

class 동전_1_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int[] dp = new int[K + 1];
        for (int index = 0; index < N; index++) {
            int coin = Integer.parseInt(br.readLine());
            coins[index] = coin;
        }
        dp[0] = 1;
        for (int num = 1; num < N + 1; num++) {
            int coin = coins[num - 1];
            for (int cost = 1; cost < K + 1; cost++) {
                if (isValid(cost, coin)) {
                    dp[cost] += dp[cost - coin];
                }
            }
        }
        System.out.println(dp[K]);
    }
    private static boolean isValid(int target, int coin) {
        return target >= coin;
    }
}