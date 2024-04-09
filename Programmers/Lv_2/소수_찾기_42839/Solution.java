package Programmers.Lv_2.소수_찾기_42839;

import java.util.*;
class Solution {
    Set<Integer> set;
    int size;
    String numbers;
    public int solution(String numbers) {
        int answer = 0;
        this.set = new HashSet<>();
        this.size = numbers.length();
        this.numbers = numbers;
        boolean[] visited = new boolean[size];
        StringBuilder sb = new StringBuilder();
        permutations(sb, 0, visited);
        StringBuilder maxSize = new StringBuilder();
        maxSize.append("1");
        for (int i = 0 ; i < size; i++) {
            maxSize.append("0");
        }


        // 소수 체크 세팅
        int maxNumber = Integer.parseInt(maxSize.toString());

        boolean[] isSosu = new boolean[maxNumber];
        isSosu[0] = isSosu[1] = true;
        for (int i = 2; i < Math.sqrt(maxNumber); i++) {
            if(isSosu[i] == false) {
                for (int j = i*i; j < maxNumber; j = j+i) {
                    isSosu[j] = true;
                }
            }

        }
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
            if (isSosu[number] == false) {
                answer++;
            }
        }

        return answer;

    }


    private void permutations(StringBuilder sb, int count, boolean[] visited) {
        if (count == size) {
            return;
        }
        for (int i = 0; i < size; i++) { // 0(0) -> 01(1) -> 012(2)
            if (visited[i] == true) {
                continue;
            } else {
                String number = Character.toString(numbers.charAt(i));
                StringBuilder newSB = new StringBuilder(sb);
                newSB.append(number);
                set.add(Integer.parseInt(newSB.toString()));
                visited[i] = true;
                permutations(newSB, count+1, visited);
                visited[i] = false;
            }
        }


    }
}