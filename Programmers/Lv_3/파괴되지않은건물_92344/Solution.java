package Programmers.Lv_3.파괴되지않은건물_92344;

class Solution {
    private int[][] sumArr;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        sumArr = new int[R + 1][C + 1];
        for (int[] s : skill) {
            int degree = s[0] == 2 ? s[5] : (-1)*s[5];
            applySkill(s[1], s[2], s[3], s[4], degree);
        }

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sumArr[row][col + 1] += sumArr[row][col];
            }
        }
        for (int col = 0; col < C; col++) {
            for (int row = 0; row < R; row++) {
                sumArr[row + 1][col] += sumArr[row][col];
            }
        }
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                answer += (board[row][col] + sumArr[row][col]) > 0 ? 1 : 0;
            }
        }
        return answer;
    }
    private void applySkill(int r1, int c1, int r2, int c2, int degree) {
        sumArr[r1][c1] += degree;
        sumArr[r1][c2 + 1] -= degree;
        sumArr[r2 + 1][c1] -= degree;
        sumArr[r2 + 1][c2 + 1] += degree;
    }
}