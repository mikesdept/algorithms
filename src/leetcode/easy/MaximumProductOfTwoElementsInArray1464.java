package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInArray1464 {

    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new NumsComparator());
        for (int num : nums) {
            queue.add(num);
        }

        return (queue.poll() - 1) * (queue.poll() - 1);
    }

    class NumsComparator implements Comparator<Integer> {

        public int compare(Integer int1, Integer int2) {
            return int1 < int2 ? 1 : -1;
        }

    }

    public static void main(String[] args) {
        MaximumProductOfTwoElementsInArray1464 maximumProductOfTwoElementsInArray1464 = new MaximumProductOfTwoElementsInArray1464();
        System.out.println(maximumProductOfTwoElementsInArray1464.maxProduct(new int[]{3, 4, 5, 2})); // 12
        System.out.println(maximumProductOfTwoElementsInArray1464.maxProduct(new int[]{1, 5, 4, 5})); // 16
        System.out.println(maximumProductOfTwoElementsInArray1464.maxProduct(new int[]{3, 7})); // 12
    }
}
