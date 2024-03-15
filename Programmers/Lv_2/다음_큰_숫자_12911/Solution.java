package Programmers.Lv_2.다음_큰_숫자_12911;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int binaryCount = Integer.bitCount(n);
        int candidate = n+1;
        while (true) {
            if (Integer.bitCount(candidate) == binaryCount) {
                return candidate;
            }
            candidate++;

        }

    }
}