package Programmers.Lv_2.H_index_42747;

import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int maxValue = Arrays.stream(citations).max().getAsInt();
        int size = citations.length;
        int h = 0;
        for (int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < size; j++) {
                if (citations[j] >= i) {
                    if (size - j == i) {
                        h = i;
                    }
                }
            }
        }
        return h;
    }
}
