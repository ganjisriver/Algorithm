package Programmers.Lv_2.피로도_87946;

class Solution {
    private int cnt;
    private int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        cnt = 0;
        this.dungeons = dungeons;
        int size = dungeons.length;
        boolean[] visited = new boolean[size];
        dfs(visited, 0, size, k, 0);
        return cnt;
    }

    private void dfs(boolean[] visited, int depth, int size, int currentPirodo, int count) {
        for (int i = 0; i < size; i++) {
            if (visited[i] == true || currentPirodo < dungeons[i][0]) {
                continue;
            }
            visited[i] = true;
            dfs(visited, depth+1, size, currentPirodo - dungeons[i][1], count+1);
            visited[i] = false;
        }
        if (cnt < count) {
            cnt = count;
        }
    }
}
