package Programmers.Lv_2.행렬_테두리_회전하기_77485;

import java.util.*;
class Solution {
    private int[][] board;
    private int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        board = new int[rows][columns];
        int[][] copyBoard = new int[rows][columns];
        setBoard(board, rows, columns);
        int size = queries.length;
        for (int idx = 0; idx < size; idx++) {
            rotate(idx, copyBoard, queries[idx]);
        }

        return answer;
    }

    private void rotate(int idx, int[][] copyBoard, int[] query) {
        int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;
        int candidate1 = moveRight(copyBoard, x1, y1, y2);
        int candidate2 = moveDown(copyBoard, x1, x2, y2);
        int candidate3 = moveLeft(copyBoard, x2, y1, y2);
        int candidate4 = moveUp(copyBoard, x1, x2, y1);
        int[] candidates = {candidate1, candidate2, candidate3, candidate4};

        applyToBoard(copyBoard, x1, x2, y1, y2);
        getMinValue(candidates, idx);

    }
    private void getMinValue(int[] candidates, int idx) {
        int answerCandidate = Integer.MAX_VALUE;
        int size = candidates.length;
        for (int i = 0; i < size; i++) {
            if (answerCandidate > candidates[i]) {
                answerCandidate = candidates[i];
            }
        }
        answer[idx] = answerCandidate;
    }

    private void applyToBoard(int[][] copyBoard, int x1, int x2, int y1, int y2) {
        for(int i = x1; i <= x2; i++) {
            if (i == x1 || i == x2) {
                for (int j = y1; j <= y2; j++) {
                    board[i][j] = copyBoard[i][j];
                }
            } else {
                board[i][y1] = copyBoard[i][y1];
                board[i][y2] = copyBoard[i][y2];
            }
        }
    }

    private int moveRight(int[][] copyBoard, int x1, int y1, int y2) {
        int candidate = Integer.MAX_VALUE;
        while (y1 < y2) {
            copyBoard[x1][y1+1] = board[x1][y1];
            if (candidate > board[x1][y1]) {
                candidate = board[x1][y1];
            }
            y1++;
        }
        return candidate;
    }
    private int moveDown(int[][] copyBoard, int x1, int x2, int y2) {
        int candidate = Integer.MAX_VALUE;
        while(x1 < x2) {
            copyBoard[x1+1][y2] = board[x1][y2];
            if (candidate > board[x1][y2]) {
                candidate = board[x1][y2];
            }
            x1++;
        }
        return candidate;
    }
    private int moveLeft(int[][] copyBoard, int x2, int y1, int y2) {
        int candidate = Integer.MAX_VALUE;
        while (y1 < y2) {
            copyBoard[x2][y2-1] = board[x2][y2];
            if (candidate > board[x2][y2]) {
                candidate = board[x2][y2];
            }
            y2--;
        }
        return candidate;
    }

    private int moveUp(int[][] copyBoard, int x1, int x2, int y1) {
        int candidate = Integer.MAX_VALUE;
        while (x1 < x2) {
            copyBoard[x2-1][y1] = board[x2][y1];
            if(candidate > board[x2][y1]) {
                candidate = board[x2][y1];
            }
            x2--;
        }
        return candidate;
    }


    private void setBoard(int[][] board, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = i*columns + (j+1);
            }
        }
    }
}