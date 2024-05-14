package Programmers.Lv_2.우박수열_정적분_134239;

import java.util.*;
class Solution {
    private List<int[]> graph;
    private List<Double> rangeGraph;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        this.graph = new ArrayList<>();
        this.rangeGraph = new ArrayList<>();
        execute(k, 0);
        int size = graph.size();
        int n = size-1;
        rangeGraph.add(0.0);
        for (int i = 1; i < size; i++) {
            rangeGraph.add(findArea(i));
        }
        int rangeSize = ranges.length;
        for (int index = 0; index < rangeSize; index++) {
            int[] range = ranges[index];
            int start = range[0];
            int end = n + range[1];
            if (start > end) {
                answer[index] = -1.0;
            } else if (start == end) {
                answer[index] = 0.0;
            } else {
                answer[index] = rangeGraph.get(end) - rangeGraph.get(start);
            }
        }
        return answer;
    }

    private double findArea(int index) {
        int prevIndex = index-1;
        int prevHeight = graph.get(prevIndex)[1];
        int currentHeight = graph.get(index)[1];
        double currentArea = calculateArea(prevHeight, currentHeight);
        double prevArea = rangeGraph.get(prevIndex);
        return prevArea + currentArea;

    }

    private double calculateArea(int prevHeight, int currentHeight) {
        int x, y;
        if (prevHeight > currentHeight) {
            x = prevHeight;
            y = currentHeight;
        } else {
            x = currentHeight;
            y = prevHeight;
        }
        double triangleArea = (double)(x - y) / 2;
        double squareArea = (double) y;
        return triangleArea + squareArea;
    }

    private void execute(int k, int count) {
        if (k == 1) {
            graph.add(new int[]{count, k});
            return;
        }
        graph.add(new int[]{count, k});
        if (k % 2 == 1) {
            execute(k*3 + 1, count + 1);
        } else {
            execute(k/2, count + 1);
        }
    }
}