package Programmers.Lv_2.영어_끝말잇기_12981;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> alreadyWords = new HashSet<>();

        int wordsLength = words.length;
        char lastChar = words[0].charAt(0);

        for(int i = 0; i < wordsLength; i++) {
            int wordLength = words[i].length();

            // 한 글자인 단어는 인정되지 않습니다.
            if (wordLength == 1) {
                answer = returnAnswer(i, n);
                break;
            }

            // 이전에 등장했던 단어는 사용할 수 없습니다.
            if (alreadyWords.contains(words[i])) {
                answer = returnAnswer(i, n);
                break;
            }

            // 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
            if (words[i].charAt(0) != lastChar) {
                answer = returnAnswer(i, n);
                break;
            }

            lastChar = words[i].charAt(wordLength-1);
            alreadyWords.add(words[i]);
        }

        return answer;
    }

    private int[] returnAnswer(int i, int n) {
        int personIdx = (i % n) + 1;
        int turnCount = (i / n) + 1;
        int[] answer = {personIdx, turnCount};
        return answer;
    }
}
