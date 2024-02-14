package leetcode.easy;

public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (left == right || nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                right++;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 removeDuplicatesFromSortedArray26 = new RemoveDuplicatesFromSortedArray26();
        System.out.println(removeDuplicatesFromSortedArray26.removeDuplicates(new int[]{1, 1, 2})); // 2
        System.out.println(removeDuplicatesFromSortedArray26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})); // 5
    }
}
