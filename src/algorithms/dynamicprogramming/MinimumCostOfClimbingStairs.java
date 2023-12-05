package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostOfClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] costWithZeroInTheEnd = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            costWithZeroInTheEnd[i] = cost[i];
        }
        costWithZeroInTheEnd[cost.length] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        return recursiveSolution(costWithZeroInTheEnd, cost.length, map);
    }

    private int recursiveSolution(int[] cost, int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return cost[n];
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, cost[n] + Math.min(recursiveSolution(cost, n - 1, map), recursiveSolution(cost, n - 2, map)));
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        MinimumCostOfClimbingStairs minimumCostOfClimbingStairs = new MinimumCostOfClimbingStairs();
        System.out.println(minimumCostOfClimbingStairs.minCostClimbingStairs(new int[]{}));
        System.out.println(minimumCostOfClimbingStairs.minCostClimbingStairs(new int[]{20}));
        System.out.println(minimumCostOfClimbingStairs.minCostClimbingStairs(new int[]{20, 15}));
        System.out.println(minimumCostOfClimbingStairs.minCostClimbingStairs(new int[]{15, 20}));
        System.out.println(minimumCostOfClimbingStairs.minCostClimbingStairs(new int[]{20, 15, 30, 5}));
    }

}
