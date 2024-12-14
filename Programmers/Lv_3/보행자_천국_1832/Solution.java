package Programmers.Lv_3.보행자_천국_1832;

import java.util.*;
class Solution {
    int MOD = 20170805;
    private boolean[][] visited;
    private int[][] map;
    private int[][][] dp;
    public int solution(int m, int n, int[][] cityMap) {
        map = cityMap;
        dp = new int[m+1][n+1][2];
        dp[0][0][0] = 1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if(map[x][y] == 0) {
                    if (check(x+1, y)) {
                        dp[x+1][y][0] += (dp[x][y][0] + dp[x][y][1]) % MOD;
                    }
                    if (check(x, y+1)) {
                        dp[x][y+1][1] += (dp[x][y][0] + dp[x][y][1]) % MOD;
                    }
                } else if (map[x][y] == 2) {
                    if (check(x+1, y)) {
                        dp[x+1][y][0] += dp[x][y][0] % MOD;
                    }
                    if (check(x, y+1)) {
                        dp[x][y+1][1] += dp[x][y][1] % MOD;
                    }
                }
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
    private boolean check(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length && map[x][y] != 1;
    }
}