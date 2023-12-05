package algorithms.dynamicprogramming;

public class MinimumCostOfClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] costWithZeroInTheEnd = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            costWithZeroInTheEnd[i] = cost[i];
        }
        costWithZeroInTheEnd[cost.length] = 0;
        return recursiveSolution(costWithZeroInTheEnd, cost.length);
    }

    private int recursiveSolution(int[] cost, int n) {
        if (n == 0 || n == 1) {
            return cost[n];
        } else {
            return cost[n] + Math.min(recursiveSolution(cost, n - 1), recursiveSolution(cost, n - 2));
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
