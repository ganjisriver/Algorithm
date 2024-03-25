package Programmers.Lv_2.뉴스_클러스터링_17677;

import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        // 자카드 유사도
        // A, B 두 집합의 교집합 크기를 합집합의 크기로 나눈 값으로 정의
        // 자바 Set
        // 합집합 메소드: addAll()
        // 교집합 메소드: retainAll()
        // 차집합 메소드: removeAll()
        // 자카드 유사도는 집합의 원소 중복이 일어나는 집합에도 적용 가능..
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        addToMap(str1Map, str1);
        addToMap(str2Map, str2);
        System.out.println("str1Map: " + str1Map.toString());
        System.out.println("str2Map: " + str2Map.toString());
        int answer = getJakad(str1Map, str2Map);
        return answer;
    }
    private void addToMap(Map<String, Integer> map, String str) {
        int strLength = str.length();
        for (int i = 1; i < strLength; i++) {
            if (Character.toLowerCase(str.charAt(i)) == (Character.toUpperCase(str.charAt(i)))) {
                continue;
            }
            if (Character.toLowerCase(str.charAt(i-1)) == (Character.toUpperCase(str.charAt(i-1)))) {
                continue;
            }
            try {
                String slicedStr = str.substring(i-1, i+1);
                String lowerStr = slicedStr.toLowerCase();
                if (map.containsKey(lowerStr)) {
                    int count = map.get(lowerStr);
                    map.put(lowerStr, count+1);
                } else {
                    map.put(lowerStr, 1);
                }
            } catch(Exception e) {
                continue;
            }
        }
    }

    private int getJakad(Map<String, Integer> map1, Map<String, Integer> map2) {
        // 합집합 수 map1.size() + map2.size() - (sum(겹치는 key중 Math.min(count1, count2))
        int hapziphapCount = 0;

        int kyozipCount = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (map2.containsKey(key)) {
                int count = Math.min(value, map2.get(key));
                hapziphapCount -= count;
                kyozipCount += count;
            }
            hapziphapCount += value;
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            hapziphapCount += value;
        }
        if (hapziphapCount == 0) {
            return 65536;
        }
        System.out.println("kyo:" + kyozipCount + " hap: " + hapziphapCount);
        return (int) ((kyozipCount * 65536) / hapziphapCount);
    }

}