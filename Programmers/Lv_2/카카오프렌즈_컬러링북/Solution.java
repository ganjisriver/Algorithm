package Programmers.Lv_2.카카오프렌즈_컬러링북;

import java.util.*;

public class Solution {
    public void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] s = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer = solution(m, n, s);
        System.out.println(answer);
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] visited = new int[m][n];
        for (int current_column = 0; current_column < m; current_column++) {
            for (int current_row = 0; current_row < n; current_row++) {
                int area = picture[current_column][current_row];
                if (area == 0){
                    visited[current_column][current_row] = 1;
                    continue;
                }
                if (visited[current_column][current_row] == 1) {
                    continue;
                }
                Queue<List<Integer>> q = new LinkedList<>();
                q.add(Arrays.asList(current_column, current_row));
                visited[current_column][current_row] = 1;
                int area_size = 0;
                while (!q.isEmpty()) {
                    List<Integer> current_index = q.poll();
                    area_size++;
                    for(int idx = 0; idx < 4; idx++) {
                        int column = current_index.get(0) + direction[idx][0];
                        int row = current_index.get(1) + direction[idx][1];
                        if (0 <= column && column < m && 0 <= row && row< n) {
                            if(visited[column][row] == 0 && area == picture[column][row]) {
                                visited[column][row] = 1;
                                q.add(Arrays.asList(column, row));
                            }
                        }
                    }
                }
                if (area_size > maxSizeOfOneArea) {
                    maxSizeOfOneArea = area_size;
                }
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}