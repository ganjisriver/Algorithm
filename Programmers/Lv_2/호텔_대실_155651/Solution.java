package Programmers.Lv_2.호텔_대실_155651;

import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = convertTimeArray(book_time);
        Arrays.sort(bookTime, Comparator.comparingInt(x -> x[0]));
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (int[] book : bookTime) {
            if (pq.isEmpty()) {
                pq.add(book);
            } else {
                int[] first = pq.peek();
                int start = first[0];
                int end = first[1];
                if (book[0] >= end + 10) {
                    pq.poll();
                }
                pq.add(book);
            }
        }

        return pq.size();
    }

    private int[][] convertTimeArray(String[][] book_time) {
        int size = book_time.length;
        int[][] convertedTime = new int[size][2];
        for (int idx = 0; idx < size; idx++) {
            convertedTime[idx] = convertTime(book_time[idx]);
        }
        return convertedTime;
    }
    private int[] convertTime(String[] book) {
        int start = convertTimeType(Integer.parseInt(book[0].replace(":", "")));
        int end = convertTimeType(Integer.parseInt(book[1].replace(":", "")));
        return new int[]{start, end};
    }
    private int convertTimeType(int time) {
        return (time / 100)*60 + (time % 100);
    }
}
