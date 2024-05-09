package Programmers.Lv_2.택배상자_131704;

import java.util.*;
class Solution {
    private int[] order;
    private int count = 0;
    public int solution(int[] order) {
        this.order = order;

        Queue<Integer> mainBelt = new LinkedList<>();
        int size = order.length;
        for (int i = 1; i <= size; i++) {
            mainBelt.add(i);
        }
        Deque<Integer> subBelt = new ArrayDeque<>();

        return execute(mainBelt, subBelt);
    }
    private int execute(Queue<Integer> mainBelt, Deque<Integer> subBelt) {
        int index = 0;
        int size = mainBelt.size();
        while(index < size) {
            int currentBox = order[index];

            if (checkMainBelt(mainBelt, currentBox)) {
                mainBelt.poll();
                index++;
                continue;
            } else if (checkSubBelt(subBelt, currentBox)) {
                subBelt.pollLast();
                index++;
                continue;
            }
            if (mainBelt.isEmpty()) {
                return index;
            }
            int popped = mainBelt.poll();
            subBelt.addLast(popped);

        }
        return index;
    }
    private boolean checkSubBelt(Deque<Integer> subBelt, int currentBox) {
        if (subBelt.isEmpty()) {
            return false;
        }
        if (subBelt.peekLast() == currentBox) {
            return true;
        }
        return false;
    }
    private boolean checkMainBelt(Queue<Integer> mainBelt, int currentBox) {
        if (mainBelt.isEmpty()) {
            return false;
        }
        if (mainBelt.peek() == currentBox) {
            return true;
        }
        return false;
    }
}