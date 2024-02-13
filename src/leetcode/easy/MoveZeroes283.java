package leetcode.easy;

import java.util.Arrays;

public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int currentIndex = 0;
        while (zeroIndex < nums.length && currentIndex < nums.length) {
            if (nums[zeroIndex] == 0 && nums[currentIndex] != 0) {
                nums[zeroIndex] = nums[currentIndex];
                nums[currentIndex] = 0;
                zeroIndex++;
                currentIndex++;
            } else if (nums[zeroIndex] != 0) {
                if (zeroIndex == currentIndex) {
                    currentIndex++;
                }
                zeroIndex++;
            } else if (nums[currentIndex] == 0) {
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0};
        moveZeroes283.moveZeroes(nums1);
        moveZeroes283.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums1)); // 1, 3, 12, 0, 0
        System.out.println(Arrays.toString(nums2)); // 0
    }
}
