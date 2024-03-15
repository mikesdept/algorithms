package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) > nums.length / 2) {
                return number;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement169 majorityElement169 = new MajorityElement169();
        System.out.println(majorityElement169.majorityElement(new int[]{3, 2, 3})); // 3
        System.out.println(majorityElement169.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }
}
