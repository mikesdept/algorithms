package algorithms.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int indexToFind = -1;
        while (left <= right && indexToFind == -1) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                indexToFind = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (indexToFind == -1) {
            return new int[]{indexToFind, indexToFind};
        } else {
            int leftIndexToFind = indexToFind;
            int rightIndexToFind = indexToFind;
            while (leftIndexToFind > 0) {
                if (nums[leftIndexToFind - 1] == target) {
                    leftIndexToFind--;
                } else {
                    break;
                }
            }
            while (rightIndexToFind < nums.length - 1) {
                if (nums[rightIndexToFind + 1] == target) {
                    rightIndexToFind++;
                } else {
                    break;
                }
            }
            return new int[]{leftIndexToFind, rightIndexToFind};
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9}, 5))); // 4, 8
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{1, 2, 3, 4, 5, 5, 6, 7, 8, 9}, 5))); // 4, 5
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5))); // 4, 4
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, 5))); // -1, -1
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{1, 5}, 5))); // 1, 1
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 6}, 5))); // 0, 0
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 5}, 5))); // 0, 1
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5}, 5))); // 0, 0
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{}, 5))); // -1, -1
    }
}
