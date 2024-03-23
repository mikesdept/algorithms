package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                result = Math.max(result, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                result = Math.max(result, map.get(num) + map.get(num - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence594 longestHarmoniousSubsequence594 = new LongestHarmoniousSubsequence594();
        System.out.println(longestHarmoniousSubsequence594.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7})); // 5
        System.out.println(longestHarmoniousSubsequence594.findLHS(new int[]{1, 2, 3, 4})); // 2
        System.out.println(longestHarmoniousSubsequence594.findLHS(new int[]{1, 1, 1, 1})); // 0
    }
}
