package Programmers.Lv_2.혼자_놀기의_달인_131130;

import java.util.*;
class Solution {
    private List<Integer> groups;
    private int[] cards;
    public int solution(int[] cards) {
        this.cards = cards;
        groups = new ArrayList<>();


        execute();
        int groupSize = groups.size();
        if (groupSize == 1) {
            return 0;
        }
        groups.sort(Comparator.reverseOrder());



        return groups.get(0)*groups.get(1);
    }
    private void execute() {
        int size = cards.length;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if(visited[i] == true) {
                continue;
            }
            makeGroup(i, visited);
        }
    }
    private void makeGroup(int index, boolean[] visited) {
        int cnt = 0;
        while (true) {

            if (visited[index] == true) {
                groups.add(cnt);
                return;
            }
            visited[index] = true;
            index = cards[index]-1;
            cnt++;
        }
    }
}
