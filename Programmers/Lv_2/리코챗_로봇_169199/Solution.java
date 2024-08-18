package Programmers.Lv_2.리코챗_로봇_169199;

// 단순히 한칸씩 옮기면서 칸 수세는 정석적인 그래프탐색이 아닌 미끄러지면서 벽이나 장애물에 걸릴때까지 가는 변형 탐색
import java.util.*;

class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우;
    private int answer = -1;

    public int solution(String[] board) {
        int rowSize = board.length;
        int columnSize = board[0].length();
        int[] startingPoint = findStartingPoint(board);
        int[][] visited = new int[rowSize][columnSize];
        execute(startingPoint, board, visited);
        return answer;
    }

    private void execute(int[] startingPoint, String[] board, int[][] visited) {
        int rowSize = board.length;
        int columnSize = board[0].length();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startingPoint[0], startingPoint[1], 0});
        visited[startingPoint[0]][startingPoint[1]] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int count = current[2];

            for (int[] direction: directions) {
                int nr = current[0];
                int nc = current[1];

                // 현재 방향으로 계속 이동
                while (true) {
                    nr += direction[0];
                    nc += direction[1];

                    // 경계나 장애물에 도달하면 멈춤
                    if (nr < 0 || nr >= rowSize || nc < 0 || nc >= columnSize || board[nr].charAt(nc) == 'D') {
                        nr -= direction[0];
                        nc -= direction[1];
                        break;
                    }
                }

                // 목표 지점(G)에 도달하면 정답 업데이트 후 종료
                if (board[nr].charAt(nc) == 'G') {
                    answer = count + 1;
                    return;
                }

                // 방문하지 않은 위치만 큐에 추가
                if (visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    q.add(new int[]{nr, nc, count + 1});
                }
            }
        }
    }

    private int[] findStartingPoint(String[] board) {
        int rowSize = board.length;
        int columnSize = board[0].length();

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                char current = board[row].charAt(column);
                if (current == 'R') {
                    return new int[]{row, column};
                }
            }
        }
        throw new IllegalArgumentException("R can't be found in board");
    }
}