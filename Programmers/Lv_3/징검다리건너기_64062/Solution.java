package Programmers.Lv_3.징검다리건너기_64062;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200_000_000;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            boolean flag = true;
            for (int stone : stones) {
                if (mid > stone) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return answer;
    }
}