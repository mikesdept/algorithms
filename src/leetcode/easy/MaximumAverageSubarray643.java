package leetcode.easy;

public class MaximumAverageSubarray643 {

    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum * 1.0 / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray643 maximumAverageSubarray643 = new MaximumAverageSubarray643();
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{5}, 1)); // 5.0
        System.out.println(maximumAverageSubarray643.findMaxAverage(new int[]{-1}, 1)); // -1.0
    }
}
