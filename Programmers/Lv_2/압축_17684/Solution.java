package Programmers.Lv_2.압축_17684;

import java.util.*;
class Solution {
    private Map<String, Integer> dictionary;
    private List<Integer> answer;
    private int lastIndex = 26;

    public int[] solution(String msg) {
        this.answer = new ArrayList<>();
        this.dictionary = new HashMap<String, Integer>();
        setDictionary();
        int msgLength = msg.length();
        int currentIndex = 0;
        while (currentIndex < msgLength) {
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            int answerIndex = 0;
            while (flag == false) {

                sb.append(msg.charAt(currentIndex));
                String w = sb.toString();

                if (dictionary.containsKey(w)) {
                    answerIndex = dictionary.get(w);
                    currentIndex++;
                } else {
                    dictionary.put(w, lastIndex+1);
                    lastIndex++;
                    answer.add(answerIndex);
                    flag = true;
                }
                if(currentIndex == msgLength) {
                    answer.add(answerIndex);
                    break;
                }

            }
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }


    private void setDictionary() {
        for (int i = 65; i < 91; i++) {
            char charWord = (char) i;
            String word = Character.toString(charWord);
            dictionary.put(word, i - 64);
        }
    }
}