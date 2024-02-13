package leetcode.medium;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted167 {

    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            } else if (numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex++;
            } else {
                break;
            }
        }
        return new int[]{leftIndex + 1, rightIndex + 1};
    }

    public static void main(String[] args) {
        TwoSumInputArrayIsSorted167 twoSumInputArrayIsSorted167 = new TwoSumInputArrayIsSorted167();
        System.out.println(Arrays.toString(twoSumInputArrayIsSorted167.twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
        System.out.println(Arrays.toString(twoSumInputArrayIsSorted167.twoSum(new int[]{2, 3, 4}, 6))); // [1, 3]
        System.out.println(Arrays.toString(twoSumInputArrayIsSorted167.twoSum(new int[]{-1, 0}, -1))); // [1, 2]
    }
}
