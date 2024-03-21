package Programmers.Lv_2.하노이의_탑_12946;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<int[]> ansList;

    public static int[][] solution(int n) {

        ansList = new ArrayList<>();
        dfs(n, 1, 2, 3);


        int[][] answer = new int[ansList.size()][];
        for(int i=0; i < ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    private static void dfs(int n, int start, int mid, int end) {
        if(n == 1){
            // 모든 옮기기의 시작점
            ansList.add(new int[]{start, end});
            return;
        }

        // n-1까지의 기둥을 2번 목적지에 모두 옮기는 과정
        dfs(n-1, start, end, mid);

        // 맨 아래 있던 n번 기둥을 3번 기둥으로 옮김
        ansList.add(new int[]{start, end});

        // n-1의 기둥을 2번 목적지까지 옮겼기 때문에, 2번에서 3번 기둥을 향해 다 옮기기
        dfs(n-1, mid, start, end);


    }
}