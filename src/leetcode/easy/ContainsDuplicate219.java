package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate219 containsDuplicate219 = new ContainsDuplicate219();
        System.out.println(containsDuplicate219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println(containsDuplicate219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println(containsDuplicate219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
    }
}
