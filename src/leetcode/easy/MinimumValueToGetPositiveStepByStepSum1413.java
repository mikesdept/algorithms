package leetcode.easy;

public class MinimumValueToGetPositiveStepByStepSum1413 {

    public int minStartValue(int[] nums) {
        int minSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }
        return 1 - minSum;
    }

    public static void main(String[] args) {
        MinimumValueToGetPositiveStepByStepSum1413 minimumValueToGetPositiveStepByStepSum1413 = new MinimumValueToGetPositiveStepByStepSum1413();
        System.out.println(minimumValueToGetPositiveStepByStepSum1413.minStartValue(new int[]{-3, 2, -3, 4, 2})); // 5
        System.out.println(minimumValueToGetPositiveStepByStepSum1413.minStartValue(new int[]{1, 2})); // 1
        System.out.println(minimumValueToGetPositiveStepByStepSum1413.minStartValue(new int[]{1, -2, -3})); // 5
    }
}
