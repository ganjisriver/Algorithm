package Programmers.Lv_2.프로세스_42587;

import java.util.*;
class Solution {
    Map<Integer, Integer> map;
    Queue<Node> q;
    public int solution(int[] priorities, int location) {
        this.map = new HashMap<>();
        this.q = new LinkedList<>();

        for (int i = 1; i < 10; i++){
            map.put(i, 0);
        }

        int answer = 0;
        int size = priorities.length;
        int currentMaxPriority = 1;
        for (int idx = 0; idx < size; idx++) {
            int value = priorities[idx];
            Node node = new Node(idx, value);
            q.offer(node);

            map.put(value, map.get(value) +1);
            if (currentMaxPriority < value) {
                currentMaxPriority = value;
            }

        }

        while(!q.isEmpty()) {
            if (map.get(currentMaxPriority) == 0) {
                currentMaxPriority--;
                continue;
            }
            Node node = q.poll();
            int first = node.value;
            int idx = node.idx;
            if (first != currentMaxPriority) {
                q.offer(node);
            } else {
                answer++;
                if (idx == location) {
                    return answer;
                } else {
                    map.put(first, map.get(first)-1);

                }

            }

        }


        return answer;
    }




    public class Node {
        int idx, value;

        public Node(int index, int value) {
            this.idx = index;
            this.value = value;
        }
    }
}
