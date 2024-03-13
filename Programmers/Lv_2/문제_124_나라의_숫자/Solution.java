package Programmers.Lv_2.문제_124_나라의_숫자;

class Solution {
    public String solution(int n) {

        StringBuilder answer = new StringBuilder();
        while (n != 0) {
            n = n-1;
            int share = n/3;
            String rest = Integer.toString(n%3);
            switch (rest) {
                case "0":
                    answer = answer.insert(0, "1");
                    break;
                case "1":
                    answer = answer.insert(0, "2");
                    break;
                case "2":
                    answer = answer.insert(0, "4");
                    break;
            }
            n = share;
        }

        return answer.toString();
    }
}
