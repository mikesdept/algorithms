package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int number : nums) {
            sum += number;
            int key = sum - k;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            int counter = 1;
            if (map.containsKey(sum)) {
                counter += map.get(sum);
            }
            map.put(sum, counter);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK560 subarraySumEqualsK560 = new SubarraySumEqualsK560();
        System.out.println(subarraySumEqualsK560.subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println(subarraySumEqualsK560.subarraySum(new int[]{1, 2, 3}, 3)); // 2
        System.out.println(subarraySumEqualsK560.subarraySum(new int[]{-1, -1, 1}, 0)); // 1
    }

}
