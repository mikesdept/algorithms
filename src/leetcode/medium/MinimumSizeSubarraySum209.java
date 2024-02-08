package leetcode.medium;

public class MinimumSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = -1;
        int sum = 0;
        int minSubArrayLen = 0;
        while (left < nums.length) {
            if (sum < target) {
                if (minSubArrayLen == 1) {
                    return minSubArrayLen;
                } else if (right == nums.length - 1) {
                    return minSubArrayLen;
                } else if (minSubArrayLen == 0) {
                    right++;
                    sum += nums[right];
                } else {
                    left++;
                    right++;
                    sum += nums[right];
                    sum -= nums[left - 1];
                }
            } else {
                minSubArrayLen = right - left + 1;
                left++;
                sum -= nums[left - 1];
            }
        }
        return minSubArrayLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum209 minimumSizeSubarraySum209 = new MinimumSizeSubarraySum209();
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(4, new int[]{1, 4, 4})); // 1
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 0
    }

}
