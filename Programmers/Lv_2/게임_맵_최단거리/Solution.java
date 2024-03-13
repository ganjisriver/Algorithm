package Programmers.Lv_2.게임_맵_최단거리;

import java.util.*;
class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] maps;
    private static int n = 0;
    private static int m = 0;
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;

        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        List<Integer> intialIndex = Arrays.asList(0, 0, 1);
        bfs(visited, intialIndex);
        answer = visited[n-1][m-1];
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

    private void bfs(int[][] visited, List<Integer> initialIndex) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(initialIndex);
        while (!q.isEmpty()) {
            List<Integer> currentIndex = q.poll();
            for(int[] direction: directions) {
                int nx = currentIndex.get(0) + direction[0];
                int ny = currentIndex.get(1) + direction[1];
                int count = currentIndex.get(2) + 1;
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maps[nx][ny] == 1 && (visited[nx][ny] == 0 || visited[nx][ny] > count)) {
                        visited[nx][ny] = count;
                        q.add(Arrays.asList(nx, ny, count));
                    }
                }
            }
        }


    }

}