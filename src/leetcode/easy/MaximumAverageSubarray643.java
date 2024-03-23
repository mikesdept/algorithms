package leetcode.easy;

public class MaximumAverageSubarray643 {

    public double findMaxAverage(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = k - 1; i < prefixSum.length; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - k + 1] + nums[i - k + 1]);
        }
        return (double) maxSum / (double) k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray643 maximumAverageSubarray643 = new MaximumAverageSubarray643();
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{5}, 1)); // 5.0
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{-1}, 1)); // -1.0
    }
}
