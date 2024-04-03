package leetcode.medium;

public class MaxConsecutiveOnesThird1004 {

    public int longestOnes(int[] nums, int k) {
        int zeroesCount = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            if (zeroesCount <= k) {
                if (nums[right] == 0) {
                    zeroesCount++;
                }
                if (zeroesCount <= k) {
                    result = Math.max(result, right - left + 1);
                }
                right++;
            } else {
                if (nums[left] == 0) {
                    zeroesCount--;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesThird1004 maxConsecutiveOnesThird1004 = new MaxConsecutiveOnesThird1004();
        System.out.println(maxConsecutiveOnesThird1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
        System.out.println(maxConsecutiveOnesThird1004.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)); // 10
    }
}
