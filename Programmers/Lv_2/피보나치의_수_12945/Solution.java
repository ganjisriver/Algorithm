package Programmers.Lv_2.피보나치의_수_12945;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567 ;
        }
        answer = dp[n];
        return answer;
    }
}
