package leetcode.easy;

public class FindTheMiddleIndexInArray1991 {

    public int findMiddleIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = i == 0 ? 0 : nums[i - 1];
            int rightSum = i == nums.length - 1 ? 0 : nums[nums.length - 1] - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheMiddleIndexInArray1991 findTheMiddleIndexInArray1991 = new FindTheMiddleIndexInArray1991();
        System.out.println(findTheMiddleIndexInArray1991.findMiddleIndex(new int[]{2, 3, -1, 8, 4})); // 3
        System.out.println(findTheMiddleIndexInArray1991.findMiddleIndex(new int[]{1, -1, 4})); // 2
        System.out.println(findTheMiddleIndexInArray1991.findMiddleIndex(new int[]{2, 5})); // -1
    }
}
