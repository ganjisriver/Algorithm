package Programmers.Lv_2.택배_배달과_수거하기_150369;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                continue;
            }
            calculateDistance(i, deliveries, cap);
            calculateDistance(i, pickups, cap);

            answer += (i+1)*2;
            if(deliveries[i] != 0 || pickups[i] != 0) {
                i++;
            }
        }


        return answer;
    }
    private void calculateDistance(int index, int[] arr, int cap) {
        while (index >= 0) {
            if (arr[index] >= cap) {
                arr[index] -= cap;
                break;
            } else {
                int gap = cap - arr[index];
                arr[index] = 0;
                index--;
                cap = gap;
            }
        }

    }
}