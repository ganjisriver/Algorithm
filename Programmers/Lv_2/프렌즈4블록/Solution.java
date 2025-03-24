package Programmers.Lv_2.프렌즈4블록;
// 이런 문제 나올 때마다 자료구조에 대한 고민이 많은데 코테 풀기 전 하기 좋은 문제 인듯
import java.util.*;
class Solution {
    private int answer = 0;
    private char[][] blockBoard;
    private int R;
    private int C;
    private Set<Node> removalBlockList = new HashSet<>();
    public int solution(int m, int n, String[] board) {
        this.blockBoard = new char[m][n];
        for (int index = 0; index < m; index++) {
            blockBoard[index] = board[index].toCharArray();
        }
        this.R = m;
        this.C = n;
        while (checkBlock() > 0) {
            dropBlock();
            removalBlockList = new HashSet<>();
        }
        return answer;
    }
    private void dropBlock() {
        for (Node node : removalBlockList) {
            blockBoard[node.x][node.y] = '-';
        }

        for (int col = 0; col < C; col++) {
            Queue<Node> removalBlockQueue = new ArrayDeque<>();
            for (int row = R - 1; row >= 0; row--) {
                if (blockBoard[row][col] == '-') {
                    removalBlockQueue.add(new Node(row, col));
                    continue;
                }
                if (!removalBlockQueue.isEmpty()) {
                    Node node = removalBlockQueue.poll();
                    blockBoard[node.x][node.y] = blockBoard[row][col];
                    blockBoard[row][col] = '-';
                    removalBlockQueue.add(new Node(row, col));
                }
            }
        }
    }
    private int checkBlock() {
        for (int row = 0; row < R -1; row++) {
            for (int col = 0; col < C - 1; col++) {
                if (blockBoard[row][col] == '-') {
                    continue;
                }
                char block = blockBoard[row][col];
                if (blockBoard[row + 1][col] == block && blockBoard[row][col + 1] == block && blockBoard[row + 1][col + 1] == block) {
                    removalBlockList.add(new Node(row, col));
                    removalBlockList.add(new Node(row + 1, col));
                    removalBlockList.add(new Node(row, col + 1));
                    removalBlockList.add(new Node(row + 1, col + 1));
                }
            }
        }
        answer += removalBlockList.size();
        return removalBlockList.size();
    }
}
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        return this.x == node.x && this.y == node.y;
    }
    public int hashCode() {
        return Objects.hash(x, y);
    }
}