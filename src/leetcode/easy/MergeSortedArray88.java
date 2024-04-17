package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray88 {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = nums1.length - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (mIndex >= 0 && nIndex >= 0) {
            if (nums1[mIndex] > nums2[nIndex]) {
                nums1[currentIndex] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[currentIndex] = nums2[nIndex];
                nIndex--;
            }
            currentIndex--;
        }
        while (mIndex >= 0) {
            nums1[currentIndex] = nums1[mIndex];
            mIndex--;
            currentIndex--;
        }
        while (nIndex >= 0) {
            nums1[currentIndex] = nums2[nIndex];
            nIndex--;
            currentIndex--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        System.out.println(Arrays.toString(mergeSortedArray88.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3))); // [1, 2, 2, 3, 5, 6]
    }
}
