package Programmers.Lv_2.마법의_엘레베이터_148653;


class Solution {
    public int solution(int storey) {
        int answer = 0;

        String standard = Integer.toString(storey);
        while (storey != 0) {
            int size = standard.length();
            int lastInt = storey % 10;
            if (lastInt < 5) {
                answer += lastInt;
                storey /= 10;
            } else if (lastInt > 5) {
                answer += 10-lastInt;
                storey = (storey/10) +1;
            } else {
                if (size == 1) {
                    return answer + 5;
                }
                int prevInt = standard.charAt(size-2) - '0';
                if (prevInt >= 5) {
                    storey = (storey/10) +1;
                } else {
                    storey = (storey/10);
                }
                answer += 5;
            }

            standard = Integer.toString(storey);
        }

        return answer;
    }
}