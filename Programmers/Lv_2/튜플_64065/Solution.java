package Programmers.Lv_2.튜플_64065;

import java.util.*;
class Solution {
    public int[] solution(String s) {

        List<String[]> list = setList(s);

        Set<Integer> set = new HashSet<>();
        int listSize = list.size();
        int[] answer = new int[listSize];
        for (int idx = 0; idx < listSize; idx++) {
            String[] arr = list.get(idx);
            int arrSize = arr.length;
            for (int i = 0; i < arrSize; i++) {
                int value = Integer.parseInt(arr[i]);
                if (!set.contains(value)) {
                    answer[idx] = value;
                    set.add(value);
                    break;
                }
            }
        }

        return answer;
    }
    private List<String[]> setList(String s) {
        List<String[]> list = new ArrayList<>();

        int size = s.length();
        boolean open = false;
        StringBuilder sb = new StringBuilder();
        for (int i =1; i < size-1; i++) {
            char letter = s.charAt(i);
            if (letter == '{') {
                open = true;
                continue;
            }
            if (letter =='}') {
                open = false;
                String[] tuple = sb.toString().split(",");
                list.add(tuple);
                sb.setLength(0);
                continue;
            }
            if (open) {
                sb.append(letter);
            }
        }
        list.sort((arr1, arr2) -> {
            if (arr1.length > arr2.length) {
                return 1;
            } else if (arr1.length == arr2.length) {
                return 0;
            } else {
                return -1;
            }
        });

        return list;
    }
}
