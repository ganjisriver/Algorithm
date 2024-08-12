package Programmers.Lv_2.무인도_여행_154540;

import java.util.*;
class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rowSize;
    private int columnSize;
    private int count;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        this.rowSize = maps.length;
        this.columnSize = maps[0].length();
        boolean[][] visited = new boolean[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                count = 0;
                dfs(visited, maps, row, column);
                if (count != 0) {
                    answer.add(count);
                }
            }
        }
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        return answer.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    private void dfs(boolean[][] visited, String[] maps, int row, int column) {
        char current = maps[row].charAt(column);
        if (current == 'X' || visited[row][column] == true) {
            return;
        }
        visited[row][column] = true;
        count += Character.getNumericValue(current);
        for (int direction = 0; direction < 4; direction++) {
            int nr = row + directions[direction][0];
            int nx = column + directions[direction][1];
            if (0 <= nr && nr < rowSize && 0 <= nx && nx < columnSize && visited[nr][nx] == false) {
                dfs(visited, maps, nr, nx);
            }
        }
    }
}