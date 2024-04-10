package Programmers.Lv_2.카펫_42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int multiply = yellow + brown;
        int plus = (brown + 4) / 2;

        for (int row = 1; row < plus; row++) {
            int column = plus - row;
            if (row*column == multiply) {
                answer[0] = row;
                answer[1] = column;
            }
        }
        return answer;
    }
}
