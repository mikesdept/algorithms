package leetcode.easy;

import java.util.*;

public class IntersectionOfTwoArrays350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int counter = 1;
            if (map.containsKey(nums1[i])) {
                counter += map.get(nums1[i]);
            }
            map.put(nums1[i], counter);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                int counter = map.get(nums2[i]);
                if (counter > 1) {
                    map.put(nums2[i], counter - 1);
                } else {
                    map.remove(nums2[i]);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays350 intersectionOfTwoArrays350 = new IntersectionOfTwoArrays350();
        System.out.println(Arrays.toString(intersectionOfTwoArrays350.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // [2, 2]
        System.out.println(Arrays.toString(intersectionOfTwoArrays350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [9, 4]
    }
}
