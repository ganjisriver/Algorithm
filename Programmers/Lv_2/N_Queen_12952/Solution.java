package Programmers.Lv_2.N_Queen_12952;

import java.util.*;
class Solution {
    private int answer = 0;
    public int solution(int n) {


        List<Integer> candidates = new ArrayList<>();
        dfs(n, 0, candidates);

        return answer;
    }

    public void dfs(int n, int currentRow, List<Integer> candidates) {
        if (currentRow == n) {
            answer++;
            return;
        }

        for(int currentColumn = 0; currentColumn < n; currentColumn++) {
            if(isAvailable(currentColumn, candidates)) {

                candidates.add(currentColumn);

                dfs(n, currentRow+1, candidates);

                candidates.remove(candidates.size()-1);

            }
        }


    }

    public boolean isAvailable(int currentColumn, List<Integer> candidates) {
        int currentRow = candidates.size();

        for(int i = 0; i < currentRow; i++) {

            if(candidates.get(i) == currentColumn || Math.abs(currentColumn - candidates.get(i)) == currentRow - i) {
                return false;
            }
        }
        return true;
    }

    /*
    백트래킹은 기본적으로 트리구조 기반 dfs 탐색
    https://kang-james.tistory.com/entry/알고리즘-백트래킹backtracking-알아보기-N-Queen-문제-풀이
    */


}