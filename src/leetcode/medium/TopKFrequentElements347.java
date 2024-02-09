package leetcode.medium;

import java.util.*;

public class TopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            int counter = 1;
            if (map.containsKey(number)) {
                counter += map.get(number);
            }
            map.put(number, counter);
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) ->
                map.get(a) > map.get(b) ? -1 : 1
        );
        for (int number : map.keySet()) {
            queue.add(number);
        }
        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            result[index] = queue.poll();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 topKFrequentElements347 = new TopKFrequentElements347();
        System.out.println(Arrays.toString(topKFrequentElements347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1, 2]
        System.out.println(Arrays.toString(topKFrequentElements347.topKFrequent(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(topKFrequentElements347.topKFrequent(new int[]{1, 2}, 2))); // [1, 2]
    }

}
