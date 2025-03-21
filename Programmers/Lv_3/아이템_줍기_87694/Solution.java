package Programmers.Lv_3.아이템_줍기_87694;

// map크기를 2배 해야하는 이유에 대해 알려줌 https://keeeeeepgoing.tistory.com/250
import java.util.*;
class Solution {
    private int[][] map = new int[102][102];
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited = new boolean[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        drawRectangles(rectangle);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterY*2, characterX*2, 0});
        visited[characterY*2][characterX*2] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int[] direction : directions) {
                int ny = current[0] + direction[0];
                int nx = current[1] + direction[1];
                if (ny == itemY*2 && nx == itemX*2) {
                    return (current[2] + 1) / 2;
                }
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new int[]{ny, nx, current[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        return answer;
    }
    private void drawRectangles(int[][] rectangle) {
        for (int[] r : rectangle) {
            int leftDownX = r[0]*2;
            int leftDownY = r[1]*2;
            int rightUpX = r[2]*2;
            int rightUpY = r[3]*2;
            for (int y = leftDownY; y <= rightUpY; y++) {
                for (int x = leftDownX; x <= rightUpX; x++) {
                    if (map[y][x] == 2) {
                        continue;
                    }
                    int value = 2;
                    if (y == leftDownY || y == rightUpY || x == leftDownX || x == rightUpX) {
                        value = 1;
                    }
                    map[y][x] = value;
                }
            }
        }
    }
}