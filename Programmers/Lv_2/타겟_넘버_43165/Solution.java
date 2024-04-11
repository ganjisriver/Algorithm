package Programmers.Lv_2.타겟_넘버_43165;

class Solution {
    int[] numbers;
    int answer;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.answer = 0;

        dfs(target, 0, 0);
        return answer;
    }

    private void dfs(int target, int depth, int value) {
        if (depth == numbers.length) {
            if (target == value) {
                answer++;
            }
            return;
        }

        dfs(target, depth+1, value + numbers[depth]);
        dfs(target, depth+1, value - numbers[depth]);

    }
}