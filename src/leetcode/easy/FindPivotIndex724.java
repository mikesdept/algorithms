package leetcode.easy;

public class FindPivotIndex724 {

    public int pivotIndex(int[] nums) {
        int pivotIndex = -1;
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
        return pivotIndex;
    }

    public static void main(String[] args) {
        FindPivotIndex724 findPivotIndex724 = new FindPivotIndex724();
        System.out.println(findPivotIndex724.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3
        System.out.println(findPivotIndex724.pivotIndex(new int[]{1, 2, 3})); // -1
        System.out.println(findPivotIndex724.pivotIndex(new int[]{2, 1, -1})); // 0
    }
}
