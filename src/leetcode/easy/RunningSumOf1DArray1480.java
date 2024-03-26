package leetcode.easy;

import java.util.Arrays;

public class RunningSumOf1DArray1480 {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        RunningSumOf1DArray1480 runningSumOf1DArray1480 = new RunningSumOf1DArray1480();
        System.out.println(Arrays.toString(runningSumOf1DArray1480.runningSum(new int[]{1, 2, 3, 4}))); // [1, 3, 6, 10]
        System.out.println(Arrays.toString(runningSumOf1DArray1480.runningSum(new int[]{1, 1, 1, 1, 1}))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(runningSumOf1DArray1480.runningSum(new int[]{3, 1, 2, 10, 1}))); // [3, 4, 6, 16, 17]
    }
}
