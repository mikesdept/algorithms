package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsCalculation(nums, 0, new boolean[nums.length], result);
        return result;
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

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        System.out.println(subsets78.subsets(new int[]{1, 2, 3})); // [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
        System.out.println(subsets78.subsets(new int[]{0})); // [[], [0]]
    }

}
