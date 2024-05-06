package Programmers.Lv_2.주차_요금_계산_92341;

import java.util.*;
class Solution {
    private int[] fees;
    private Map<String, Integer> outCheckMap;
    private Map<String, Integer> timeMap;
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        this.outCheckMap = new HashMap<>();
        this.timeMap = new HashMap<>();

        for (String recordString : records) {
            String[] record = recordString.split(" ");
            String currentTime = record[0];
            String number = record[1];
            String inOutCheck = record[2];
            int convertedTime = convertTime(currentTime);
            applyTime(number, convertedTime, inOutCheck);
        }
        if(!outCheckMap.isEmpty()) {
            for(Map.Entry<String, Integer> map : outCheckMap.entrySet()) {
                applyTimeAtLast(map.getKey(), convertTime("23:59"), "OUT");
            }
        }


        int size = timeMap.size();
        String[][] numberFeeArr = new String[size][2];
        int index = 0;

        for(Map.Entry<String, Integer> map : timeMap.entrySet()) {
            String number = map.getKey();
            int time = map.getValue();
            int fee = calculateFee(time);
            numberFeeArr[index] = new String[]{number, Integer.toString(fee)};
            index++;
        }

        int[] answer = new int[size];
        Arrays.sort(numberFeeArr, Comparator.comparingInt(o -> Integer.parseInt(o[0])));
        for (int i = 0; i < size; i++) {
            answer[i] = Integer.parseInt(numberFeeArr[i][1]);
        }
        return answer;
    }

    private int calculateFee(int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) {
            return baseFee;
        }

        int restTime = time - baseTime;
        if (restTime % unitTime == 0) {
            return baseFee + (restTime / unitTime)*unitFee;
        }
        return baseFee + ((restTime / unitTime)+1)*unitFee;
    }

    private void applyTimeAtLast(String number, int convertedTime, String inoutCheck) {
        int inTime = outCheckMap.get(number);
        int time = convertedTime - inTime;
        if (timeMap.containsKey(number)) {
            timeMap.put(number, timeMap.get(number) + time);
        } else {
            timeMap.put(number, time);
        }
    }

    private void applyTime(String number, int convertedTime, String inoutCheck) {
        if (inoutCheck.equals("IN")) {
            outCheckMap.put(number, convertedTime);
        } else {
            int inTime = outCheckMap.get(number);
            int time = convertedTime - inTime;
            if (timeMap.containsKey(number)) {
                timeMap.put(number, timeMap.get(number) + time);
            } else {
                timeMap.put(number, time);
            }
            outCheckMap.remove(number);
        }
    }

    private int convertTime(String currentTime) {
        String[] timeArr = currentTime.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        return hour*60 + minute;
    }
}