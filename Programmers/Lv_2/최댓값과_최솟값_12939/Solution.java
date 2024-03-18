package Programmers.Lv_2.최댓값과_최솟값_12939;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int n = arr.length;
        for (String value: arr) {
            int intValue = Integer.valueOf(value);
            if (maxValue < intValue) {
                maxValue = intValue;
            }
            if (minValue > intValue) {
                minValue = intValue;
            }
        }

        String answer = minValue + " " + maxValue;

        return answer;
    }
}
