package Programmers.Lv_2.다리를_지나는_트럭_42583;

import java.util.*;
class Solution {
    Deque<Integer> bridge;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        this.bridge = new ArrayDeque();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int answer = 0;

        int lastTruckCount = 0;

        int currentWeight = 0;
        int currentTruck = 0;
        int truckSize = truck_weights.length;

        while (lastTruckCount < truckSize) {
            int first = bridge.pollFirst();
            if (first != 0) {
                currentWeight -= first;
                lastTruckCount++;
            }
            if (currentTruck < truckSize) {
                if (currentWeight + truck_weights[currentTruck] <= weight) {
                    bridge.addLast(truck_weights[currentTruck]);
                    currentWeight += truck_weights[currentTruck];
                    currentTruck++;
                } else {
                    bridge.addLast(0);
                }
            }
            answer++;
            /*
            1. 덱에 있는 첫번째 요소 확인 후 빼라. 0이면 걍 빼고 0이 아니면 넣는다.
            2. 다리에 있는 트럭 빠지고 나서 currentWeight 갱신, 새로운 트럭 넣을 수 있는지 확인 후 0또는 트럭 넣기
            3. 넣을 수 있으면 currentTruck 갱신
            */


        }



        return answer;
    }
}
