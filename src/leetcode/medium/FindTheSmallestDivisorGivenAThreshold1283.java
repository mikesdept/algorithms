package leetcode.medium;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        int result = -1;
        while (left <= right) {
            int divider = (left + right) / 2;
            int sum = checkSum(nums, divider, threshold);
            if (sum <= threshold) {
                result = divider;
                right = divider - 1;
            } else if (sum > threshold) {
                left = divider + 1;
            }
        }
        return result;
    }

    private int checkSum(int[] nums, int divider, int threshold) {
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            double divideResult = Math.ceil(nums[i] / (double) divider);
            sum += divideResult;
            if (sum > threshold) {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FindTheSmallestDivisorGivenAThreshold1283 findTheSmallestDivisorGivenAThreshold1283 = new FindTheSmallestDivisorGivenAThreshold1283();
        System.out.println(findTheSmallestDivisorGivenAThreshold1283.smallestDivisor(new int[]{1, 2, 5, 9}, 6)); // 5
        System.out.println(findTheSmallestDivisorGivenAThreshold1283.smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5)); // 44
        System.out.println(findTheSmallestDivisorGivenAThreshold1283.smallestDivisor(new int[]{200, 100, 14}, 10)); // 34
    }
}
