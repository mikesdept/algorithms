package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosetElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int startIndex = 0;
        int endIndex = k - 1;
        for (int i = endIndex + 1; i < arr.length; i++) {
            int candidateDifference = Math.abs(arr[i] - x);
            int firstElementDifference = Math.abs(arr[startIndex] - x);
            if (candidateDifference < firstElementDifference || arr[i] == arr[startIndex]) {
                startIndex++;
                endIndex++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosetElements658 findKClosetElements658 = new FindKClosetElements658();
        System.out.println(findKClosetElements658.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)); // [1, 2, 3, 4]
        System.out.println(findKClosetElements658.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)); // [1, 2, 3, 4]
        System.out.println(findKClosetElements658.findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2)); // [1, 3]
    }
}
