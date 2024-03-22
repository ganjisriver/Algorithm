package Programmers.Lv_2.행렬의_곱셈_12949;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Column = arr1.length;
        int arr2Row = arr2[0].length;

        int arr1Row = arr1[0].length;
        int[][] answer = new int[arr1Column][arr2Row];

        for (int i = 0; i < arr1Column; i++) {
            for (int j = 0; j < arr2Row; j++) {
                int count = 0;
                for(int k = 0; k < arr1Row; k++) {
                    count += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = count;
            }
        }

        return answer;
    }
}