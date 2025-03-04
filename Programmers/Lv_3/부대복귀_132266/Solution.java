package Programmers.Lv_3.부대복귀_132266;

import java.util.*;
class Solution {
    int maxValue = 100001;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int index = 1; index < n + 1; index++) {
            graph[index] = new ArrayList<>();
        }
        for (int[] road: roads) {
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, maxValue);
        distance[destination] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{destination, 0});
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentIndex = current[0];
            int currentDistance = current[1];
            for (int next : graph[currentIndex]) {
                if(distance[next] == maxValue) {
                    distance[next] = currentDistance + 1;
                    q.add(new int[]{next, currentDistance + 1});
                }
            }
        }
        int length = sources.length;
        int[] answer = new int[length];
        for (int index = 0; index < length; index++) {
            int value = distance[sources[index]];
            if (value == maxValue) {
                answer[index] = -1;
                continue;
            }
            answer[index] = value;
        }
        return answer;
    }
}