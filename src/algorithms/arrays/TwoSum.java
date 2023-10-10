package algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findTwoSumIndexesBruteForce(int[] array, int target) {
        if (array == null || array.length < 2) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] findTwoSumIndexesOptimalSolution(int[] array, int target) {
        if (array == null || array.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{map.get(target - array[i]), i};
            } else {
                map.put(array[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println("brute force solution -> " + Arrays.toString(twoSum.findTwoSumIndexesBruteForce(new int[]{1, 3, 7, 9, 2}, 11)));
        System.out.println("optimal solution -> " + Arrays.toString(twoSum.findTwoSumIndexesOptimalSolution(new int[]{1, 3, 7, 9, 2}, 11)));
    }

}
