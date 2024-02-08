package leetcode.medium;

public class FindMinimumInRotatedSortedArray153 {

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (int) Math.ceil((left + right) / 2.0);
            if (middle == 0 || nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] > nums[0]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray153 findMinimumInRotatedSortedArray153 = new FindMinimumInRotatedSortedArray153();
        System.out.println(findMinimumInRotatedSortedArray153.findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(findMinimumInRotatedSortedArray153.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(findMinimumInRotatedSortedArray153.findMin(new int[]{11, 13, 15, 17})); // 11
        System.out.println(findMinimumInRotatedSortedArray153.findMin(new int[]{2, 1})); // 1
    }

}
