package Programmers.Lv_2.문제_3xN_타일링;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        long[] dp = new long[n+1];
        dp[2] = 3L;
        dp[4] = 11L;
        int subDpSum = 3;
        for (int count = 6; count < n+1; count = count*2) {
            subDpSum += dp[count-4];
            dp[count] = (dp[count-2]*3 + subDpSum + 2) % 1000000007;
        }
        long answer = dp[n];
        return (int) answer;
    }
}
