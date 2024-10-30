package Programmers.Lv_2.도넛과_막대_그래프_258711;
import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> inputSet = new HashSet<>();

        // 1. 인접 리스트 만들기, edge의 최고 숫자가 정해져 있지 않아서 Map으로 구현
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if(!graph.containsKey(start)) {
                graph.put(start, new ArrayList<>());

            }
            graph.get(start).add(end);
            inputSet.add(end);
        }

        // 2. 임의의 정점 찾기
        // 임의의 정점은 진입 차수가 0개이면서 진출 차수가 2개 이상인 것을 찾으면 된다.
        // 진출차수가 2개 이상인 것은 8자 모양의 정점에도 있지만, 8자 모양에 존재하는 진출차수 2개인 정점은
        // 진입차수도 존재하고, 임의의 정점은 진입차수가 없다. 이 점을 이용하여 임의의 정점 탐색
        for (Integer key : graph.keySet()) {
            if (!inputSet.contains(key) && graph.get(key).size() > 1) {
                answer[0] = key;

            }
        }

        // 3. 임의의 정점에서 그래프 탐색을 실행하여 그래프 모양 확인
        for (int start : graph.get(answer[0])) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(start);
            boolean isEightShape = false;
            boolean isBarShape = false;
            while(!q.isEmpty()) {
                int current = q.poll();

                // 막대그래프는 도착점에서 진출차수가 없는 특징 이용하여 확인
                if (!graph.containsKey(current)) {
                    isBarShape = true;
                    break;
                }
                List<Integer> nextList = graph.get(current);

                // 8자 그래프는 진출차수가 2개인 정점이 존재하는 것을 이용하여 확인
                if (nextList.size() > 1){
                    isEightShape = true;
                    break;
                }

                // 방문 체크하며 그래프 순회
                int next = nextList.get(0);
                if (!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                }
            }
            if(isEightShape) {
                answer[3]++;
                continue;
            }
            if (isBarShape) {
                answer[2]++;
                continue;
            }
            answer[1]++;

        }

        return answer;
    }
}