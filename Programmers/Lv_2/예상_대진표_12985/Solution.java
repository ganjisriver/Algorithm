package Programmers.Lv_2.예상_대진표_12985;

import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        int count = 0;
        int nCopy = n;
        while (nCopy >= 1) {
            nCopy = nCopy/2;
            count++;
        }

        int answer = bfs(1, n, a, b, count);

        return answer;

    }

    public int bfs(int first, int last, int a, int b, int num) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[] firstArray = new int[]{first, last, num};
        dq.add(firstArray);
        while(!dq.isEmpty()) {
            int[] poped = dq.pollFirst();
            int start = poped[0];
            int end = poped[1];
            int count = poped[2];
            if (start <= a && a < end+1 && start <= b && b < end+1) {
                dq.add(new int[]{start, (start+end)/2, count-1});
                dq.add(new int[]{(start + end)/2+1, end, count-1});
            } else if(!(start <= a && a < end+1) && !(start <= b && b < end +1)){

            } else {
                return count;
            }
        }
        return -1;
    }

    public class Others {

        // BinaryString을 활용하면 &, ^, | 등을 통해 각각 AND, XOR, OR을 메서드 안에서 할 수 있다.
        // 해당 방식을 비트연산을 이용해 푼 것이 굉장하다.
        public int solution1(int n, int a, int b) {
            return Integer.toBinaryString((a-1)^(b-1)).length();
        }

        /* 위에서 이진법을 활용한 방식이랑 원리는 비슷하다.
        a와 b가 각각 5, 7이라고 가정할 때,
        1라운드 후 a, b는 각각 3, 4 이다.
        2라운드에서 a, b는 각각 2, 2가 되어 2라운드에서 매칭이 된다.
        이진법 원리 자체가 2를 나누고 1이 될때까지 나머지를 붙여주는 원리
        */
        public int solution2(int n, int a, int b) {
            int round = 0;
            while(a != b) {
                a = a/2 + a%2;
                b = b/2 + b%2;
                round++;
            }
            return round;
        }
    }
}
