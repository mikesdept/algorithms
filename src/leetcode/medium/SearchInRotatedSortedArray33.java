package leetcode.medium;

public class SearchInRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > nums[right]) {
            while (left < right) {
                int middle = (left + right) / 2;
                if (middle > 0 && nums[middle - 1] > nums[middle]) {
                    left = middle;
                    break;
                } else if (nums[right] < nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            if (target == nums[left]) {
                return left;
            }

            if (target > nums[0]) {
                right = left - 1;
                left = 0;
            } else if (target < nums[0]) {
                right = nums.length - 1;
            } else {
                return 0;
            }
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();
        System.out.println(searchInRotatedSortedArray33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(searchInRotatedSortedArray33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(searchInRotatedSortedArray33.search(new int[]{1}, 0)); // -1
        System.out.println(searchInRotatedSortedArray33.search(new int[]{1, 3}, 3)); // 1
        System.out.println(searchInRotatedSortedArray33.search(new int[]{3, 1}, 3)); // 0
        System.out.println(searchInRotatedSortedArray33.search(new int[]{8, 9, 2, 3, 4}, 9)); // 1
    }
}
