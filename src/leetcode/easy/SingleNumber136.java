package leetcode.easy;

import java.util.Arrays;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && (i == nums.length - 1 || nums[i] != nums[i + 1])) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber136 singleNumber136 = new SingleNumber136();
        System.out.println(singleNumber136.singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println(singleNumber136.singleNumber(new int[]{4, 1, 2, 1, 2})); // 4
        System.out.println(singleNumber136.singleNumber(new int[]{1})); // 1
    }

}
