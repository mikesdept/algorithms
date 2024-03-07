package leetcode.easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int lastIndex = nums.length - 1;
        int first = nums[0] * nums[1] * nums[lastIndex];
        int second = nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2];
        return Math.max(first, second);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers628 maximumProductOfThreeNumbers628 = new MaximumProductOfThreeNumbers628();
        System.out.println(maximumProductOfThreeNumbers628.maximumProduct(new int[]{1, 2, 3})); // 6
        System.out.println(maximumProductOfThreeNumbers628.maximumProduct(new int[]{1, 2, 3, 4})); // 24
        System.out.println(maximumProductOfThreeNumbers628.maximumProduct(new int[]{-1, -2, -3})); // -6
    }
}
