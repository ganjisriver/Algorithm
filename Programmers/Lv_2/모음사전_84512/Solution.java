package Programmers.Lv_2.모음사전_84512;

import java.util.*;
class Solution {
    private Map<String, Integer> wordDictionary;
    private int count;
    public int solution(String word) {
        wordDictionary = new HashMap<>();
        count = 0;
        char[] charWords = {'A', 'E', 'I', 'O', 'U'};
        setWordDictionary(charWords, new StringBuilder(), 0);
        return wordDictionary.get(word);
    }

    private void setWordDictionary(char[] charWords, StringBuilder sb, int depth) {
        if (depth >= 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(charWords[i]);
            count++;
            wordDictionary.put(newSb.toString(), count);
            setWordDictionary(charWords, newSb, depth+1);
        }
    }
}