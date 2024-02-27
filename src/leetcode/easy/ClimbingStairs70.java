package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!map.containsKey(n)) {
            map.put(n, climbStairs(n - 1, map) + climbStairs(n - 2, map));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();
        System.out.println(climbingStairs70.climbStairs(2)); // 2
        System.out.println(climbingStairs70.climbStairs(3)); // 3
    }

}
