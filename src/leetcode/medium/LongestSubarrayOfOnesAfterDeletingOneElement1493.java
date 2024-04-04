package leetcode.medium;

public class LongestSubarrayOfOnesAfterDeletingOneElement1493 {

    public int longestSubarray(int[] nums) {
        int startIndex = 0;
        int firstAfterZeroIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (startIndex != firstAfterZeroIndex) {
                    maxLength = Math.max(maxLength, i - startIndex - 1);
                    startIndex = firstAfterZeroIndex;
                }
                firstAfterZeroIndex = i + 1;
            }
        }
        int finalCheck = nums.length - startIndex == nums.length ? nums.length - 1 : nums.length - startIndex - 1;
        return Math.max(maxLength, finalCheck);
    }

    public static void main(String[] args) {
        LongestSubarrayOfOnesAfterDeletingOneElement1493 longestSubarrayOfOnesAfterDeletingOneElement1493 = new LongestSubarrayOfOnesAfterDeletingOneElement1493();
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement1493.longestSubarray(new int[]{1, 1, 0, 1})); // 3
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement1493.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})); // 5
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement1493.longestSubarray(new int[]{1, 1, 1})); // 2
        System.out.println(longestSubarrayOfOnesAfterDeletingOneElement1493.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1})); // 4
    }
}
