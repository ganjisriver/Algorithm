package Programmers.Lv_2.양궁_대회_93242;

import java.util.*;
// 순열로 풀면 시간초과 나오는데 어떻게 해야 백트래킹 할 수 있을지 다른 방법이 있는지 고민이 됨.
class Solution {
    private int maxScore;
    private int[] answer;
    private int[] info;
    public int[] solution(int n, int[] info) {
        maxScore = 0;
        answer = new int[11];
        this.info = info;
        permutations(new int[11], 0, n);

        if (maxScore == 0) {
            return new int[]{-1};
        }

        return answer;
    }

    private void permutations(int[] arr, int depth, int n) {
        if (n == depth) {
            checkArr(arr);
            return;
        }
        int size = 11;

        for (int i = 0; i < 11; i++) {
            // 백트래킹으로 효율성 처리 -> 근데 continue가 아니라 break가 되는 이유는?
            if (arr[i] > info[i]) {
                break;
            }
            int[] newArr = arr.clone();
            newArr[i] += 1;
            permutations(newArr, depth+1, n);

        }

    }

    private void checkArr(int[] arr) {
        int apeachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] < arr[i]) {
                ryanScore += 10-i;
            } else if(info[i] >= arr[i] && info[i] != 0) {
                apeachScore += 10-i;
            }
        }
        int candidate = ryanScore - apeachScore;
        if (maxScore < candidate) {
            maxScore = candidate;
            answer = arr;
        } else if (maxScore == candidate) {
            checkAnswer(arr);
        }
        return;
    }

    private void checkAnswer(int[] arr) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] < arr[i]) {
                answer = arr;
                return;
            } else if(answer[i] > arr[i]) {
                return;
            }
        }
    }

}