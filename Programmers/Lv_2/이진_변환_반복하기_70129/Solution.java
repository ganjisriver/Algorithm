package Programmers.Lv_2.이진_변환_반복하기_70129;

class Solution {
    int[] answer;
    public int[] solution(String s) {
        this.answer = new int[2];
        chagneToBinary(s);
        return answer;
    }

    private void chagneToBinary(String s) {
        if (s.length() == 1) {
            return;
        }
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        // 1. x의 모든 0을 제거하는 과정
        for (int idx = 0; idx < size; idx++) {
            if (s.charAt(idx) == '1') {
                sb.append('1');
            } else {
                answer[1] += 1;
            }
        }
        // 2. 변환된 x의 길이를 나타내는 2진법으로 바꾼다.
        String newS = Integer.toBinaryString(sb.length());
        answer[0] += 1;
        chagneToBinary(newS);
    }
}