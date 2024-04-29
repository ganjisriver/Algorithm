package Programmers.Lv_2.전력망을_둘로_나누기_86791;
import java.util.*;
class Solution {
    private int cnt;
    private List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        cnt = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        int size = wires.length;
        for (int i = 0; i < size; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            boolean[] visited = new boolean[n+1];
            getCnt(visited, n, v1);
            graph[v1].add(v2);
            graph[v2].add(v1);
            if (cnt == 0) {
                break;
            }
        }
        return cnt;
    }

    private void getCnt(boolean[] visited,int n, int start) {
        int connectedNode = 1;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()) {
            int current = q.poll();
            for (int node :graph[current]) {
                if (visited[node] == true) {
                    continue;
                }
                visited[node] = true;
                connectedNode++;
                q.add(node);
            }
        }
        int candidate = Math.abs(connectedNode - (n - connectedNode));
        if(cnt > candidate) {
            cnt = candidate;
        }
    }
}
