package leetcode.easy;

public class BestTimeToBuyAndSellStock121 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lessPriceIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[lessPriceIndex]) {
                lessPriceIndex = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[lessPriceIndex]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 bestTimeToBuyAndSellStock121 = new BestTimeToBuyAndSellStock121();
        System.out.println(bestTimeToBuyAndSellStock121.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(bestTimeToBuyAndSellStock121.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

}
