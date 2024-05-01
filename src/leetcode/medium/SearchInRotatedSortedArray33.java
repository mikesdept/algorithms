package leetcode.medium;

public class SearchInRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        int minIndex = findMinimum(nums, 0, nums.length - 1);
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, minIndex, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, minIndex - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private int findMinimum(int[] nums, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[middle + 1]) {
                return middle + 1;
            } else if (nums[middle] < nums[middle - 1]) {
                return middle;
            } else if (nums[middle] > nums[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return 0;
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
