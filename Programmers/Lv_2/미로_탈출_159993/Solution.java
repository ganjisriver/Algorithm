package Programmers.Lv_2.미로_탈출_159993;

import java.util.*;
class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[] lebberIndex;
    private int answer = -1;
    public int solution(String[] maps) {
        int[] startIndex = findStartIndex(maps);
        String lebberVersion = "lebberVersion";
        String answerVersion = "answerVersion";
        execute(startIndex, maps, lebberVersion);
        if (lebberIndex == null) {
            return answer;
        }
        execute(lebberIndex, maps, answerVersion);
        return answer;
    }

    private void execute(int[] startIndex, String[] maps, String version) {
        int rowSize = maps.length;
        int columnSize = maps[0].length();
        boolean[][] visited = new boolean[rowSize][columnSize];
        Queue<int[]> q = new LinkedList<>();
        q.add(startIndex);
        visited[startIndex[0]][startIndex[1]] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentCount = current[2];
            for (int[] direction : directions) {
                int nr = current[0] + direction[0];
                int nc = current[1] + direction[1];
                if (nr < 0 || nr >= rowSize || nc < 0 || nc >= columnSize || maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                    continue;
                }
                if (decide(maps, nr, nc, currentCount, version) == true) {
                    return;
                }
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, currentCount+1});
            }
        }
    }
    private boolean decide(String[] maps, int row, int column, int count, String version) {
        if (version.equals("lebberVersion")) {
            if(maps[row].charAt(column) == 'L') {
                lebberIndex = new int[]{row, column, count+1};
                return true;
            }
        } else {
            if (maps[row].charAt(column) == 'E') {
                answer = count+1;
                return true;
            }
        }
        return false;
    }

    private int[] findStartIndex(String[] maps) {
        int rowSize = maps.length;
        int columnSize = maps[0].length();
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                if (maps[row].charAt(column) == 'S') {
                    return new int[]{row, column, 0};
                }
            }
        }
        throw new IllegalStateException("'S' not found in the maps");
    }
}
