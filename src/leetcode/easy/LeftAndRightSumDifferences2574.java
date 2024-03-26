package leetcode.easy;

import java.util.Arrays;

public class LeftAndRightSumDifferences2574 {

    public int[] leftRightDifference(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int leftSum = i == 0 ? 0 : prefixSum[i - 1] - prefixSum[0] + nums[0];
            int rightSum = i == result.length - 1 ? 0 : prefixSum[result.length - 1] - prefixSum[i + 1] + nums[i + 1];
            int absSum = Math.abs(leftSum - rightSum);
            result[i] = absSum;
        }
        return result;
    }

    public static void main(String[] args) {
        LeftAndRightSumDifferences2574 leftAndRightSumDifferences2574 = new LeftAndRightSumDifferences2574();
        System.out.println(Arrays.toString(leftAndRightSumDifferences2574.leftRightDifference(new int[]{10, 4, 8, 3}))); // [15, 1, 11, 22]
        System.out.println(Arrays.toString(leftAndRightSumDifferences2574.leftRightDifference(new int[]{1}))); // [0]
    }
}
