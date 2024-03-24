package Programmers.Lv_2.배달_12978;

import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 필요한 자료구조
        // 1. 경로를 표현할 graph
        List<List<Node>> graph = new ArrayList<>();

        // 2. 방문한 노드를 표시할 visited 배열
        boolean[] visited = new boolean[N+1];

        // 3. 탐색할 노드를 넣어줄 우선순위큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 4. 출발지와의 거리를 기록할 distArray
        int[] distArray = new int[N+1];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[1] = 0; // 출발지 거리 초기화
        // 5. 우선순위 큐에 넣어줄 Comparable, Comparator를 상속한 클래스(임의로 정의한 클래스)
        // 아래 구현한 Node 클래스

        // graph의 idx가 노드이고, 그 안에 담기는 List는 해당 노드와 연결된 노드들의 리스트이다.
        for (int i= 0; i < N+1; i++) {
            graph.add(new ArrayList<Node>());
        }

        // graph에 데이터 삽입
        for(int[] info: road) {
            int start = info[0];
            int end = info[1];
            int dist = info[2];
            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }

        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.idx] == true) {
                continue;
            }
            visited[current.idx] = true;

            int roadNum = graph.get(current.idx).size();

            for(int nextIdx = 0; nextIdx < roadNum; nextIdx++) {
                Node next = graph.get(current.idx).get(nextIdx);
                if (distArray[next.idx] > distArray[current.idx] + next.distance) {
                    distArray[next.idx] = distArray[current.idx] + next.distance;
                    pq.offer(new Node(next.idx, distArray[next.idx]));
                }
            }
        }


        for (int i = 1; i <= N; i++) {
            if (distArray[i] <= K) {
                answer++;
            }
        }



        return answer;
    }

    public class Node implements Comparable<Node> {
        int idx, distance;

        // 생성자
        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        // Comparable을 상속하여 구현할 compareTo 메서드
        @Override
        public int compareTo(Node node) {

            // 0이상을 반환하면 우선순위가 낮아지고, 음수를 반환하면 우선순위가 높아진다.
            if (this.distance >= node.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}