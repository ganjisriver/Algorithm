package BOJ.백트래킹;

// 설명이 제일 좋음
// https://thdbs523.tistory.com/296


import java.io.*;
import java.util.*;

class 색종이_붙이기_17136 {
    static int[][] board = new int[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int answer = Integer.MAX_VALUE;
    static int[] paper = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int row = 0; row < 10; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 10; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }

    static void DFS(int x, int y, int cnt) {
        if (x > 9) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (board[x][y] == 0 || visited[x][y]) {
            if (y == 9) {
                DFS(x + 1, 0, cnt);
            } else {
                DFS(x, y + 1, cnt);
            }
        }
        for (int size = 1; size < 6; size++) {
            if (check(x, y, size)) {
                attach(x, y, size);
                if (y == 9) {
                    DFS(x + 1, 0, cnt + 1);
                } else {
                    DFS(x, y + 1, cnt + 1);
                }
                detach(x, y, size);
            }
        }
    }
    static boolean check(int x, int y, int size) {
        if (paper[size] == 5) {
            return false;
        }
        for (int nx = x; nx < x + size; nx++) {
            for (int ny = y; ny < y + size; ny++) {
                if (!isValidRange(nx, ny) || board[nx][ny] == 0 || visited[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void attach(int x, int y, int size) {
        for (int nx = x; nx < x + size; nx++) {
            for (int ny = y; ny < y + size; ny++) {
                visited[nx][ny] = true;
            }
        }
        paper[size]++;
    }
    static void detach(int x, int y, int size) {
        for (int nx = x; nx < x + size; nx++) {
            for (int ny = y; ny < y + size; ny++) {
                visited[nx][ny] = false;
            }
        }
        paper[size]--;
    }
    static boolean isValidRange(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 10;
    }

}

