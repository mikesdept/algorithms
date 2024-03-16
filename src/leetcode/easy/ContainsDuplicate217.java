package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        System.out.println(containsDuplicate217.containsDuplicate(new int[]{1, 2, 3, 1})); // true
        System.out.println(containsDuplicate217.containsDuplicate(new int[]{1, 2, 3, 4})); // false
        System.out.println(containsDuplicate217.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
