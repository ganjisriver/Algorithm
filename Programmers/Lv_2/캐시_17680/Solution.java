package Programmers.Lv_2.캐시_17680;

import java.util.*;
class Solution {
    private Set<String> cacheServer;
    private int maxSize;
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5*cities.length;
        }
        this.cacheServer = new LinkedHashSet<>();
        this.maxSize = cacheSize;

        int answer = 0;

        for(String c: cities) {
            String city = c.toLowerCase();
            answer += check(city);
        }


        return answer;
    }

    private int check(String city) {
        // 캐시히트 된 경우
        if (cacheServer.contains(city) == true) {
            cacheHit(city);
            return 1;
        } else {
            cacheMiss(city);
            return 5;
        }
    }

    private void cacheHit(String city) {
        cacheServer.remove(city);
        touchData(city);
    }

    private void cacheMiss(String city) {
        int currentSize = cacheServer.size();
        if (currentSize == maxSize) {
            Iterator<String> cacheIter = cacheServer.iterator();
            String first = cacheIter.next();
            cacheServer.remove(first);
        }
        touchData(city);
    }

    private void touchData(String city) {
        cacheServer.add(city);
    }
}