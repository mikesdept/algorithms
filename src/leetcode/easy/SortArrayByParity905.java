package leetcode.easy;

import java.util.Arrays;

public class SortArrayByParity905 {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0 && nums[right] % 2 == 0) {
                left++;
            } else if (nums[left] % 2 != 0 && nums[right] % 2 != 0) {
                right--;
            } else if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                left++;
            } else if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity905 sortArrayByParity905 = new SortArrayByParity905();
        System.out.println(Arrays.toString(sortArrayByParity905.sortArrayByParity(new int[]{3, 1, 2, 4}))); // [4, 2, 1, 3]
        System.out.println(Arrays.toString(sortArrayByParity905.sortArrayByParity(new int[]{0}))); // [0]
    }
}
