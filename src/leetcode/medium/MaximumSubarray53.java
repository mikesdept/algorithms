package leetcode.medium;

public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            int tempSum = sum + nums[i];
            if (nums[i] > tempSum) {
                sum = nums[i];
            } else {
                sum = tempSum;
            }
            if (sum > max) {
                max = sum;
            }
            if (nums[i] > max) {
                sum = nums[i];
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
        System.out.println(maximumSubarray53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maximumSubarray53.maxSubArray(new int[]{1})); // 1
        System.out.println(maximumSubarray53.maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
        System.out.println(maximumSubarray53.maxSubArray(new int[]{8, -19, 5, -4, 20})); // 21
    }

}
