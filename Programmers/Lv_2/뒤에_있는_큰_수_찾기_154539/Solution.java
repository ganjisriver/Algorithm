package Programmers.Lv_2.뒤에_있는_큰_수_찾기_154539;

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for (int i = numbers.length-2; i >= 0; i--) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                } else if(numbers[i] >= numbers[j]) {
                    if(answer[j] == -1) {
                        answer[i] = -1;
                        break;
                    }
                    else if (numbers[i] < answer[j]) {
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
