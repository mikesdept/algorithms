package leetcode.easy;

import java.util.Arrays;

public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MissingNumber268 missingNumber268 = new MissingNumber268();
        System.out.println(missingNumber268.missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(missingNumber268.missingNumber(new int[]{0, 1})); // 2
        System.out.println(missingNumber268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
    }
}
