package Programmers.Lv_2.N2_배열_자르기_87390;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
        long temp = left;
        while(temp <= right) {
            if ((temp / n) > (temp % n)) {
                answer[(int)temp - (int)left] = (int)(temp / (long) n)+1;
            } else {
                answer[(int)temp - (int)left] = (int)(temp % (long)n)+1;
            }
            temp++;
        }
        return answer;

    }
}
