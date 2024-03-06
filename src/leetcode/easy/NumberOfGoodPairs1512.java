package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs1512 {

    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += calculatePairs(entry.getValue());
        }
        return result;
    }

    private int calculatePairs(int count) {
        if (count == 1) {
            return 0;
        } else {
            return calculatePairs(count - 1) + (count - 1);
        }
    }

    public static void main(String[] args) {
        NumberOfGoodPairs1512 numberOfGoodPairs1512 = new NumberOfGoodPairs1512();
        System.out.println(numberOfGoodPairs1512.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3})); // 4
        System.out.println(numberOfGoodPairs1512.numIdenticalPairs(new int[]{1, 1, 1, 1})); // 6
        System.out.println(numberOfGoodPairs1512.numIdenticalPairs(new int[]{1, 2, 3})); // 0
    }

}
