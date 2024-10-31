package Programmers.Lv_2.퍼즐_게임_챌린지_340212;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // diff <= level = time_cur
        // diff > level = (diff - level)*(time_cur + time_prev)
        int size = diffs.length;
        long left = 1L;
        long right = (long) Math.pow(10, 15);
        long level;
        long candidate = 0;
        while (left <= right) {
            level = (left + right) / 2;
            long totalTime = times[0];
            for (int index = 1; index < size; index++) {
                long diff = Long.valueOf(diffs[index]);
                long time_cur = Long.valueOf(times[index]);
                long time_prev = Long.valueOf(times[index-1]);
                if (diff > level) {
                    totalTime += (diff - level)*(time_cur + time_prev) + time_cur;
                } else {
                    totalTime += time_cur;
                }
                if (totalTime > limit) {
                    left = level+1;
                    break;
                }
            }

            if (Long.valueOf(totalTime) < limit) {
                candidate = Long.valueOf(level).intValue();
                right = level-1;
            }
            if (limit == (long) Long.valueOf(totalTime)) {
                return Long.valueOf(level).intValue();
            }
        }

        return Long.valueOf(candidate).intValue();
    }
}