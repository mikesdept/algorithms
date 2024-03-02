package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int ans = dfs(coins, amount, cache);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        List<Integer> results = new ArrayList<>();
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, cache);
            if (res != Integer.MAX_VALUE) results.add(res + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int res : results) ans = Math.min(ans, res);
        cache.put(amount, ans);
        return ans;
    }

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        System.out.println(coinChange322.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(coinChange322.coinChange(new int[]{2}, 3)); // -1
        System.out.println(coinChange322.coinChange(new int[]{1}, 0)); // 0
    }
}
