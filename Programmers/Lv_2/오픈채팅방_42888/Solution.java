package Programmers.Lv_2.오픈채팅방_42888;

import java.util.*;
class Solution {
    Map<String, String> map;
    public String[] solution(String[] record) {
        this.map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String log :record) {
            String[] info = log.split(" ");
            String act = info[0];
            String id = info[1];


            if(act.equals("Change")) {

            } else {
                result.add(List.of(id, act));
            }
            if (!act.equals("Leave")) {
                String nickname = info[2];
                map.put(id, nickname);
            }
        }

        int size = result.size();
        String[] answer = new String[size];
        for(int i = 0; i < size; i++) {
            List<String> info = result.get(i);
            String id = info.get(0);
            String act = info.get(1);
            if (act.equals("Enter")) {
                answer[i] = map.get(id)+"님이 들어왔습니다.";
            } else {
                answer[i] = map.get(id)+"님이 나갔습니다.";
            }
        }
        return answer;
    }


}