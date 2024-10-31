package Programmers.Lv_2.석유_시추_250136;

import java.util.*;
class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private boolean[][] visited;
    private int[] arr;

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        visited = new boolean[n][m];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, n, m, land);
                }
            }
        }
        int answer = 0;
        for (int candidate : arr) {
            answer = Math.max(answer, candidate);
        }
        return answer;
    }

    private void bfs(int r, int c, int n, int m, int[][] land) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        count++;
        boolean[] columnCheck = new boolean[m];
        columnCheck[c] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int index = 0; index < 4; index++) {
                int nr = current[0] + dr[index];
                int nc = current[1] + dc[index];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    count++;
                    q.add(new int[]{nr, nc});
                    columnCheck[nc] = true;
                }
            }
        }

        for (int index = 0; index < m; index++) {
            if (columnCheck[index]) {
                arr[index] += count;
            }
        }
    }

}