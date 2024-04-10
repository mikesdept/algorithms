package leetcode.easy;

import java.util.PriorityQueue;

public class KthLargestElementInStream703 {

    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargestElementInStream703(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInStream703 kthLargestElementInStream703 = new KthLargestElementInStream703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargestElementInStream703.add(3)); // 4
        System.out.println(kthLargestElementInStream703.add(5)); // 5
        System.out.println(kthLargestElementInStream703.add(10)); // 5
        System.out.println(kthLargestElementInStream703.add(9)); // 8
        System.out.println(kthLargestElementInStream703.add(4)); // 8
    }

}
