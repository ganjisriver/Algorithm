package Programmers.Lv_2.연속_부분_수열_합의_개수_131701;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> groups = new HashSet<Integer>();

        int maxSize = elements.length;
        for(int size = 1; size <= maxSize; size++){
            for(int index =0; index <= maxSize; index++){
                int candidate = 0;
                for(int element = index ; element < index + size; element++){
                    candidate += elements[element % elements.length];
                }
                groups.add(candidate);
            }
        }

        return groups.size();
    }
}
