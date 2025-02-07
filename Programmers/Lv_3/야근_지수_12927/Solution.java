package Programmers.Lv_3.야근_지수_12927;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int left = 1;
        int right = 50000;
        int size = works.length;
        int maxWork = -1;
        int workSum = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int workCnt = 0;
            for (int index = 0; index < size; index++) {
                int work = works[index];
                if (work >= mid) {
                    sum += work - mid;
                    workCnt++;
                }
            }
            if (sum > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                maxWork = mid;
                workSum = sum;
            }
        }
        n -= workSum;
        for (int index = 0; index < size; index++) {
            int work = works[index];
            if (work >= maxWork) {
                if (n > 0) {
                    answer += (int) Math.pow(maxWork - 1, 2);
                    n -= 1;
                } else {
                    answer += (int) Math.pow(maxWork, 2);
                }
                continue;
            }
            answer += (int) Math.pow(work, 2);
        }
        return answer;
    }
}