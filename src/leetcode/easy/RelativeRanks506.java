package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks506 {

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item : score) {
            queue.add(item);
        }

        int position = score.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            map.put(queue.poll(), position);
            position--;
        }

        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int currentPosition = map.get(score[i]);
            String positionUi;
            if (currentPosition == 3) {
                positionUi = "Bronze Medal";
            } else if (currentPosition == 2) {
                positionUi = "Silver Medal";
            } else if (currentPosition == 1) {
                positionUi = "Gold Medal";
            } else {
                positionUi = String.valueOf(currentPosition);
            }
            result[i] = positionUi;
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeRanks506 relativeRanks506 = new RelativeRanks506();
        System.out.println(Arrays.toString(relativeRanks506.findRelativeRanks(new int[]{5, 4, 3, 2, 1}))); // ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        System.out.println(Arrays.toString(relativeRanks506.findRelativeRanks(new int[]{10, 3, 8, 9, 4}))); // ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    }
}
