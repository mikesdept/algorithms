package leetcode.easy;

public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int candidate = nums.length;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                candidate = middle;
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        SearchInsertPosition35 searchInsertPosition35 = new SearchInsertPosition35();
        System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsertPosition35.searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
    }

}
