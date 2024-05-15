package Programmers.Lv_2.귤_고르기_138476;

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = setMap(tangerine);
        Queue<Node> pq = setPriorityQueue(map);
        int cnt = 0;
        while (k > cnt && !pq.isEmpty()) {
            Node node = pq.poll();
            cnt += node.cnt;
            answer++;
        }
        return answer;
    }

    private Queue<Node> setPriorityQueue(Map<Integer, Integer> map) {
        Queue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            Node node = new Node(mapEntry.getKey(), mapEntry.getValue());
            pq.add(node);
        }
        return pq;
    }

    private Map<Integer, Integer> setMap(int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = tangerine.length;
        for (int i = 0; i < size; i++) {
            int tangerSize = tangerine[i];
            if (map.containsKey(tangerSize)) {
                map.put(tangerSize, map.get(tangerSize)+1);
            } else {
                map.put(tangerSize, 1);
            }
        }
        return map;
    }

    public static class Node implements Comparable<Node> {
        int size, cnt;

        public Node(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if (this.cnt > node.cnt) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}