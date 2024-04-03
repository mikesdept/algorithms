package leetcode.medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int left = 0;
        int right = 0;
        long sum = nums[0];
        while (right < nums.length) {
            if (left < right) {
                sum += nums[right];
                int numbersCount = right - left + 1;
                long targetSum = (long) numbersCount * nums[right];
                long operationsCount = targetSum - sum;
                if (operationsCount <= k) {
                    result = numbersCount;
                } else {
                    sum -= nums[left];
                    left++;
                }
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement1838 frequencyOfTheMostFrequentElement1838 = new FrequencyOfTheMostFrequentElement1838();
        System.out.println(frequencyOfTheMostFrequentElement1838.maxFrequency(new int[]{1, 2, 4}, 5)); // 3
        System.out.println(frequencyOfTheMostFrequentElement1838.maxFrequency(new int[]{1, 4, 8, 13}, 5)); // 2
        System.out.println(frequencyOfTheMostFrequentElement1838.maxFrequency(new int[]{3, 9, 6}, 2)); // 1
    }
}
