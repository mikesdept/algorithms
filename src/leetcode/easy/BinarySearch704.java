package leetcode.easy;

public class BinarySearch704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch704 binarySearch704 = new BinarySearch704();
        System.out.println(binarySearch704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(binarySearch704.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
    }
}
