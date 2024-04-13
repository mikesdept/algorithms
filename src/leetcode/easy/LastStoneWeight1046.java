package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[stones.length - 1];
        }
        Arrays.sort(stones);
        while (stones[stones.length - 2] != 0) {
            int firstIndex = stones.length - 2;
            int secondIndex = stones.length - 1;
            if (stones[firstIndex] > stones[secondIndex]) {
                stones[firstIndex] = stones[firstIndex] - stones[secondIndex];
                stones[secondIndex] = 0;
            } else if (stones[secondIndex] > stones[firstIndex]) {
                stones[secondIndex] = stones[secondIndex] - stones[firstIndex];
                stones[firstIndex] = 0;
            } else {
                stones[firstIndex] = 0;
                stones[secondIndex] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

    public int lastStoneWeightWithPriorityQueue(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new StonesComparator());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int result = Math.abs(first - second);
            if (result > 0) {
                queue.add(result);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

    class StonesComparator implements Comparator<Integer> {

        public int compare(Integer int1, Integer int2) {
            return int1 > int2 ? -1 : 1;
        }

    }

    public static void main(String[] args) {
        LastStoneWeight1046 lastStoneWeight1046 = new LastStoneWeight1046();
        System.out.println(lastStoneWeight1046.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(lastStoneWeight1046.lastStoneWeight(new int[]{1})); // 1
        System.out.println(lastStoneWeight1046.lastStoneWeightWithPriorityQueue(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(lastStoneWeight1046.lastStoneWeightWithPriorityQueue(new int[]{1})); // 1
    }

}
