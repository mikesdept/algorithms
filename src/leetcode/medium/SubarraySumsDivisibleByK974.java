package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK974 {

    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < prefixSum.length; i++) {
            int remain = prefixSum[i] % k;
            if (remain < 0) {
                remain += k;
            }
            int count = map.getOrDefault(remain, 0);
            result += count;
            map.put(remain, count + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK974 subarraySumsDivisibleByK974 = new SubarraySumsDivisibleByK974();
        System.out.println(subarraySumsDivisibleByK974.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)); // 7
        System.out.println(subarraySumsDivisibleByK974.subarraysDivByK(new int[]{5}, 9)); // 0
        System.out.println(subarraySumsDivisibleByK974.subarraysDivByK(new int[]{-1, 2, 9}, 2)); // 2
    }
}
