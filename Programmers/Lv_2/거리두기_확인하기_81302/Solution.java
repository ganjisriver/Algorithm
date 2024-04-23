package Programmers.Lv_2.거리두기_확인하기_81302;

import java.util.*;
class Solution {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int idx = 0; idx < places.length; idx++) {
            String[] place = places[idx];
            answer[idx] = searchPerson(place) ? 1 : 0;
        }
        return answer;
    }

    private boolean searchPerson(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P') {
                    if(!checkDistance(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkDistance(String[] place, int r, int c) {
        Deque<int[]> dq = new ArrayDeque();
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        int[] first = {r, c, 0};
        dq.addLast(first);
        while(!dq.isEmpty()) {
            int[] current = dq.pollFirst();
            for (int idx = 0; idx < 4; idx++) {
                int dr = current[0] + direction[idx][0];
                int dc = current[1] + direction[idx][1];
                int count = current[2];
                if (dr < 0 || 5 <= dr || dc < 0 || 5 <= dc || visited[dr][dc] == true || place[dr].charAt(dc) == 'X') {
                    continue;
                }
                if (place[dr].charAt(dc) == 'P') {
                    return false;
                }
                if (count >= 1) {
                    continue;
                }
                int[] newIndex = {dr, dc, count+1};
                visited[dr][dc] = true;
                dq.addLast(newIndex);

            }
        }
        return true;
    }
}
