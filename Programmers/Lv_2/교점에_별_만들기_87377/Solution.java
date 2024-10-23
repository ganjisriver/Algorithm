package Programmers.Lv_2.교점에_별_만들기_87377;

import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
    }
    private int[] leftUp = null;
    private int[] leftDown = null;
    private int[] rightUp = null;
    private int[] rightDown = null;
    private List<int[]> combiArr;
    public String[] solution(int[][] line) {
        combiArr = new ArrayList<>();
        String[] answer = {};
        int size = line.length;
        int[] arr = new int[size];
        combinations(arr, new int[2], 0, 0);
        System.out.println(combiArr);
        // int parent = A*D - B*C;
        // if (parent == 0) {
        //     continue;
        // }
        // int x = B*F - E*D / parent;
        // int y = E*C - A*F / parent;

        return answer;
    }

    private void combinations(int[] arr, int[] candidate, int current, int depth) {
        if (depth == 2) {
            combiArr.add(candidate);
            return;
        }
        int size = arr.length;
        for (int i = current; i < size; i++) {
            int[] newCandidate = candidate.clone();
            System.out.println(depth);
            int node = arr[i];
            newCandidate[depth] = node;
            combinations(arr, newCandidate, current+1, depth+1);
        }
    }
}