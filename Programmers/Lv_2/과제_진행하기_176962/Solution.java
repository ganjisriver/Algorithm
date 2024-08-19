package Programmers.Lv_2.과제_진행하기_176962;

import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = execute(plans);
        return answer;
    }

    private String[] execute(String[][] plans) {
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        Stack<String[]> stack = new Stack<>();
        int size = plans.length;
        List<String> answer = new ArrayList<>();
        for (int idx = 0; idx < size-1; idx++) {
            String[] plan = plans[idx];
            String[] nextPlan = plans[idx+1];
            int time = Integer.parseInt(plan[2]);
            int timeDiff = calculateTimeDifference(plan[1], nextPlan[1]);
            if (timeDiff < time) {
                time -= timeDiff;
                stack.push(new String[]{plan[0], plan[1], Integer.toString(time)});
            } else if (timeDiff == time) {
                answer.add(plan[0]);
            } else {
                answer.add(plan[0]);
                timeDiff -= time;
                while(!stack.isEmpty() && timeDiff > 0) {
                    String[] first = stack.pop();
                    int firstTime = Integer.parseInt(first[2]);
                    // 다음 시작까지 20분남았고 처리 못한 과제 15 15라고 가정
                    if (timeDiff >= firstTime) {
                        answer.add(first[0]);
                    } else {
                        stack.add(new String[]{first[0], first[1], Integer.toString(firstTime-timeDiff)});
                    }
                    timeDiff -= firstTime;
                }
            }

        }
        answer.add(plans[size-1][0]);
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        return answer.toArray(new String[answer.size()]);
    }
    private int calculateTimeDifference(String currentTime, String nextTime) {
        String[] current = currentTime.split(":");
        String[] next = nextTime.split(":");

        int currentTotalMinutes = Integer.parseInt(current[0]) * 60 + Integer.parseInt(current[1]);
        int nextTotalMinutes = Integer.parseInt(next[0]) * 60 + Integer.parseInt(next[1]);

        return nextTotalMinutes - currentTotalMinutes;
    }
}