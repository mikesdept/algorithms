package leetcode.medium;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal1962 {

    public int minStoneSum(int[] piles, int k) {
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a > b ? -1 : 1);
        for (int stones : piles) {
            queue.add(stones);
            result += stones;
        }
        int counter = k;
        while (counter > 0) {
            int stones = queue.poll();
            int leftStones = stones / 2;
            if (stones % 2 != 0) {
                leftStones += 1;
            }
            result -= (stones - leftStones);
            queue.add(leftStones);
            counter--;
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal1962 removeStonesToMinimizeTheTotal1962 = new RemoveStonesToMinimizeTheTotal1962();
        System.out.println(removeStonesToMinimizeTheTotal1962.minStoneSum(new int[]{5, 4, 9}, 2)); // 12
        System.out.println(removeStonesToMinimizeTheTotal1962.minStoneSum(new int[]{4, 3, 6, 7}, 3)); // 12
    }
}
