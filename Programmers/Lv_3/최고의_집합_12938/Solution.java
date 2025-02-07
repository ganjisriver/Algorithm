package Programmers.Lv_3.최고의_집합_12938;

import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int minValue = s / n;
        int maxValueCnt = s % n;
        Arrays.fill(answer, minValue);
        for (int index = n - 1; index >= n - maxValueCnt; index--) {
            answer[index] = minValue + 1;
        }
        return answer;
    }
}