package Programmers.Lv_2.문제_2xN_타일링;

class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int count = 2; count < n+1; count++) {
            dp[count] = (dp[count-1] + dp[count-2]) % 1000000007;
        }
        int answer = dp[n];

        return answer;
    }
}
