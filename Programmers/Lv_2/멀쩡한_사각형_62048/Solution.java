package Programmers.Lv_2.멀쩡한_사각형_62048;

class Solution {
    public long solution(int w, int h) {
        long y;
        long x;
        if (w > h) {
            y = w;
            x = h;
        } else {
            y = h;
            x = w;
        }
        long answer = y*x;
        double prev = 0.0;
        for (long i = 1; i < x+1; i++) {
            double current = y*i/(double) x;
            long tearedPage = ((long)Math.ceil(current)) - ((long) Math.floor(prev));
            answer -= tearedPage;

            prev = current;
        }


        return answer;
    }
}