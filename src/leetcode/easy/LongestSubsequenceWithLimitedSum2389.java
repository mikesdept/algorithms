package leetcode.easy;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = 0;
            int end = nums.length - 1;
            int index = -1;
            while (start <= end) {
                int middle = (start + end) / 2;
                if (queries[i] >= nums[middle]) {
                    start = middle + 1;
                    index = middle;
                } else if (queries[i] < nums[middle]) {
                    end = middle - 1;
                }
            }
            queries[i] = index + 1;
        }
        return queries;
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum2389 longestSubsequenceWithLimitedSum2389 = new LongestSubsequenceWithLimitedSum2389();
        System.out.println(Arrays.toString(longestSubsequenceWithLimitedSum2389.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}))); // [2, 3, 4]
        System.out.println(Arrays.toString(longestSubsequenceWithLimitedSum2389.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1}))); // [0]
        System.out.println(Arrays.toString(longestSubsequenceWithLimitedSum2389.answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450}))); // [2, 2, 1, 1, 2, 3, 3]
    }
}
