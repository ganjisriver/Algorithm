package Programmers.Lv_2.후보키_42890;

import java.util.*;
class Solution {
    String[][] relation;
    int answer;
    Set<List<Integer>> candidateKeys;
    public int solution(String[][] relation) {
        this.relation = relation;
        this.answer = 0;
        this.candidateKeys = new HashSet<>();
        int columnSize = relation[0].length;

        for (int r = 1; r < columnSize+1; r++) {
            combinations(new ArrayList<Integer>(), 0, columnSize, r);
        }

        return candidateKeys.size();

    }
    private void combinations(List<Integer> candidate, int start, int columnSize, int r) {
        if (r == 0) {
            Set<List<String>> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < candidate.size(); j++) {
                    list.add(relation[i][candidate.get(j)]);
                }
                if (set.contains(list)) {
                    return;
                } else {
                    set.add(list);
                }
            }


            candidateKeys.add(candidate);
            return;
        }

        for (int i = start; i < columnSize; i++) {
            List<Integer> newList = new ArrayList<>(candidate);
            newList.add(i);
            Iterator<List<Integer>> iter = candidateKeys.iterator();
            boolean flag = true;
            while (iter.hasNext()) {
                if(newList.containsAll(iter.next())) {
                    flag = false;
                    continue;
                }
            }
            if(flag == false) {
                continue;
            }
            combinations(newList, i+1, columnSize, r-1);

        }

    }
}
