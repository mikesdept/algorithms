package leetcode.easy;

public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        // int sum = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += i;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber268 missingNumber268 = new MissingNumber268();
        System.out.println(missingNumber268.missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(missingNumber268.missingNumber(new int[]{0, 1})); // 2
        System.out.println(missingNumber268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
    }
}
