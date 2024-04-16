package Programmers.Lv_2.메뉴_리뉴얼_72411;

import java.util.*;
class Solution {
    private Map<Integer, Map<String, Integer>> courseCandidates;
    public String[] solution(String[] orders, int[] course) {
        this.courseCandidates  = new HashMap<>();


        for (int number : course) {
            courseCandidates.put(number, new HashMap<>());
        }
        for (String order: orders) {
            makeSubSet(order);
        }

        List<String> answerList = new ArrayList<>();
        for (int number: course) {
            int maxCount = 2;
            Map<Integer, List<String>> storage = new HashMap<>();
            Map<String, Integer> map = courseCandidates.get(number);
            for (String key: map.keySet()) {
                int value = map.get(key);
                if (value >= maxCount) {
                    maxCount = value;
                    if (storage.containsKey(value)) {
                        storage.get(value).add(key);
                    } else {
                        List<String> tempList = new ArrayList<>();
                        tempList.add(key);
                        storage.put(value, tempList);
                    }
                }

            }
            List<String> maxList = storage.get(maxCount);
            if(maxList != null) {
                for(int i = 0; i< maxList.size(); i++) {
                    answerList.add(maxList.get(i));
                }
            }



        }
        String[] answer = answerList.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    private void makeSubSet(String order) {
        int orderSize = order.length();
        for (int i = 1; i < (1 << orderSize); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < orderSize; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(order.charAt(j));
                }
            }

            int sbSize = sb.length();
            if (courseCandidates.containsKey(sbSize)) {
                Map<String, Integer> candidate = courseCandidates.get(sbSize);
                String course = sb.toString();
                char[] courseCharArray = course.toCharArray();
                Arrays.sort(courseCharArray);
                String sortedCourse = new String(courseCharArray);
                if (candidate.containsKey(sortedCourse)) {
                    candidate.put(sortedCourse, candidate.get(sortedCourse)+1);
                } else {
                    candidate.put(sortedCourse, 1);
                }
            }
        }
    }
}
