package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals1863 {

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsCalculation(nums, 0, new boolean[nums.length], result);
        return calculateSubsetsXORSum(result);
    }

    private void subsetsCalculation(int[] nums, int prefixLength, boolean[] prefix, List<List<Integer>> result) {
        if (prefixLength == nums.length) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < prefix.length; i++) {
                if (prefix[i]) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        } else {
            prefix[prefixLength] = false;
            subsetsCalculation(nums, prefixLength + 1, prefix, result);
            prefix[prefixLength] = true;
            subsetsCalculation(nums, prefixLength + 1, prefix, result);
        }
    }

    private int calculateSubsetsXORSum(List<List<Integer>> result) {
        int xorSum = 0;
        for (List<Integer> subset : result) {
            if (subset.size() == 1) {
                xorSum += subset.get(0);
            } else if (subset.size() > 1) {
                int subsetXorSum = subset.get(0) ^ subset.get(1);
                for (int i = 2; i < subset.size(); i++) {
                    subsetXorSum = subsetXorSum ^ subset.get(i);
                }
                xorSum += subsetXorSum;
            }
        }
        return xorSum;
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals1863 subsetXORTotals1863 = new SumOfAllSubsetXORTotals1863();
        System.out.println(subsetXORTotals1863.subsetXORSum(new int[]{1, 3})); // 6
        System.out.println(subsetXORTotals1863.subsetXORSum(new int[]{5, 1, 6})); // 28
        System.out.println(subsetXORTotals1863.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})); // 480
    }
}
