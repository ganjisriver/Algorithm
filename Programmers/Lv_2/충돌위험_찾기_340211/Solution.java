package Programmers.Lv_2.충돌위험_찾기_340211;

import java.util.*;
class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        // 로봇의 개수만큼 List<Node>를 만들어 놓는다.
        int robotNum = routes.length;
        Queue<Node>[] robotsRoutes = new ArrayDeque[robotNum];
        for (int index = 0; index < robotNum; index++) {
            robotsRoutes[index] = new ArrayDeque<>();
        }

        // robotRoutes에 경로 넣기
        for (int i = 0; i < robotNum; i++) {
            int[] route = routes[i];

            int routeLength = route.length;
            for (int index = 0; index < routeLength-1; index++) {
                int[] startPoint = points[route[index]-1];
                int[] endPoint = points[route[index+1]-1];
                int x1 = startPoint[0];
                int y1 = startPoint[1];
                int x2 = endPoint[0];
                int y2 = endPoint[1];
                while(x1 != x2 || y1 != y2) {
                    robotsRoutes[i].add(new Node(x1, y1));
                    if (x1 > x2) {
                        x1 -= 1;
                    } else if (x1 < x2) {
                        x1 += 1;
                    } else {
                        if(y1 > y2) {
                            y1 -= 1;
                        } else if (y1 < y2) {
                            y1 += 1;
                        }
                    }
                    if(index == routeLength-2 && x1 == x2 && y1 == y2) {
                        robotsRoutes[i].add(new Node(x1, y1));
                    }

                }
            }
        }
        // 경로를 넣은 후 겹치는 부분이 있는지 체크
        int second = 0;
        while(true) {
            Map<Node, Integer> checkMap = new HashMap<>();
            // 한번에 움직임1회
            boolean flag = false;
            for (int index = 0; index < robotNum; index++) {
                Queue<Node> robotRoute = robotsRoutes[index];
                if(!robotRoute.isEmpty()) {
                    flag = true;
                    Node node = robotRoute.poll();
                    if(checkMap.containsKey(node)) {
                        checkMap.put(node, checkMap.get(node)+1);
                    } else {
                        checkMap.put(node, 1);
                    }
                }
            }
            for (Node node : checkMap.keySet()) {
                if (checkMap.get(node) > 1) {
                    answer++;
                }
            }
            second++;
            if (!flag) {
                break;
            }
        }


        return answer;
    }


}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
