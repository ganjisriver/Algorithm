package Programmers.Lv_2.멀리_뛰기_12914;

class Solution {

    public long solution(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        int answer = dp[n];
        return answer;
    }


}
