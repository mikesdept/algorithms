package leetcode.medium;

import java.util.Arrays;

public class SortColors75 {

    public int[] sortColors(int[] nums) {
        int[] counter = new int[3];
        for (int color : nums) {
            counter[color]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < counter[0]) {
                nums[i] = 0;
            } else if (i < counter[0] + counter[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortColors75 sortColors75 = new SortColors75();
        System.out.println(Arrays.toString(sortColors75.sortColors(new int[]{2, 0, 2, 1, 1, 0}))); // [0, 0, 1, 1, 2, 2]
        System.out.println(Arrays.toString(sortColors75.sortColors(new int[]{2, 0, 1}))); // [0, 1, 2]
    }
}
