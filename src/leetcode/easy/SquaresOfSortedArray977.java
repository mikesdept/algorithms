package leetcode.easy;

import java.util.Arrays;

public class SquaresOfSortedArray977 {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int currentIndex = result.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            if (leftValue > rightValue) {
                result[currentIndex] = leftValue;
                left++;
            } else {
                result[currentIndex] = rightValue;
                right--;
            }
            currentIndex--;
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray977 squaresOfSortedArray977 = new SquaresOfSortedArray977();
        System.out.println(Arrays.toString(squaresOfSortedArray977.sortedSquares(new int[]{-4, -1, 0, 3, 10}))); // [0, 1, 9, 16, 100]
        System.out.println(Arrays.toString(squaresOfSortedArray977.sortedSquares(new int[]{-7, -3, 2, 3, 11}))); // [4, 9, 9, 49, 121]
    }
}
