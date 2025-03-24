package Programmers.Lv_2.파일명_정렬_17686;

import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        List<File> fileList = new ArrayList<>();
        for (String file : files) {
            StringBuilder headSB = new StringBuilder();
            StringBuilder numberSB = new StringBuilder();
            StringBuilder tailSB = new StringBuilder();
            boolean headFlag = true;
            boolean numberFlag = false;
            for (char c : file.toCharArray()) {
                if (headFlag) {
                    if (Character.isDigit(c)) {
                        numberSB.append(c);
                        headFlag = false;
                        numberFlag = true;
                        continue;
                    }
                    headSB.append(c);
                } else if (numberFlag) {
                    if (Character.isDigit(c)) {
                        numberSB.append(c);
                        continue;
                    }
                    tailSB.append(c);
                    numberFlag = false;
                } else {
                    tailSB.append(c);
                }
            }
            fileList.add(new File(headSB.toString(), numberSB.toString(), tailSB.toString()));
        }
        Collections.sort(fileList);
        for (int index = 0; index < size; index++) {
            answer[index] = fileList.get(index).toString();
        }
        return answer;
    }
}

class File implements Comparable<File> {
    // HEAD 기준 사전 순으로 정렬 대소문자 구분 X A.toUpperCase()로 대소문자 구별 없애기
    // HEAD가 같으면 Number의 숫자 순 정렬
    String HEAD;
    String NUMBER;
    String TAIL;
    public File(String HEAD, String NUMBER, String TAIL) {
        this.HEAD = HEAD;
        this.NUMBER = NUMBER;
        this.TAIL = TAIL;
    }
    public int compareTo(File file) {
        String thisHeadUppder = this.HEAD.toLowerCase();
        String fileHeadUpper = file.HEAD.toLowerCase();
        int thisNumber = Integer.parseInt(this.NUMBER);
        int fileNumber = Integer.parseInt(file.NUMBER);
        if (thisHeadUppder.equals(fileHeadUpper)) {
            if (thisNumber == fileNumber) {
                return 0;
            }
            return thisNumber - fileNumber;
        }
        return thisHeadUppder.compareTo(fileHeadUpper);
    }
    public String toString() {
        return HEAD + NUMBER + TAIL;
    }
}