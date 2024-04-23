package leetcode.medium;

import java.util.Arrays;

public class RotateArray189 {

    public int[] rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int steps = k % nums.length;
        if (steps == 0) {
            return nums;
        }

        int currentIndex = 0;
        for (int i = nums.length - steps; i < nums.length; i++) {
            result[currentIndex] = nums[i];
            currentIndex++;
        }
        for (int i = 0; i < (nums.length - steps); i++) {
            result[currentIndex] = nums[i];
            currentIndex++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        RotateArray189 rotateArray189 = new RotateArray189();
        System.out.println(Arrays.toString(rotateArray189.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3))); // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateArray189.rotate(new int[]{-1, -100, 3, 99}, 2))); // [3, 99, -1, -100]
        System.out.println(Arrays.toString(rotateArray189.rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, 38))); // [17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    }
}
