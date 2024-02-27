package leetcode.medium;

public class ArithmeticSlices413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        if (nums.length >= 2) {
            int left = 0;
            int right = 1;
            int difference = nums[right] - nums[left];
            right++;
            while (right < nums.length) {
                if (nums[right] - nums[right - 1] != difference) {
                    result += calculateSlices(left, right);
                    left = right - 1;
                    difference = nums[right] - nums[left];
                }
                right++;
            }
            result += calculateSlices(left, right);
        }
        return result;
    }

    private int calculateSlices(int left, int right) {
        int slices = 0;
        if (right - left >= 3) {
            int count = 0;
            for (int i = right - left; i >= 3; i--) {
                count++;
                slices += count;
            }
        }
        return slices;
    }

    public static void main(String[] args) {
        ArithmeticSlices413 arithmeticSlices413 = new ArithmeticSlices413();
        System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[]{1})); // 0
    }

}
