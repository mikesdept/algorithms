package leetcode.medium;

public class MinimumPenaltyForShop2483 {

    public int bestClosingTime(String customers) {
        int[] array = new int[customers.length()];
        int currentSum = 0;
        for (int i = 0; i < customers.length(); i++) {
            array[i] = customers.charAt(i) == 'Y' ? 1 : 0;
            currentSum += array[i];
        }

        int minSum = currentSum;
        int minHour = 0;

        for (int i = 0; i < array.length; i++) {
            int addition = array[i] == 1 ? -1 : 1;
            currentSum += addition;
            if (currentSum < minSum) {
                minSum = currentSum;
                minHour = i + 1;
            }
        }

        return minHour;
    }

    public static void main(String[] args) {
        MinimumPenaltyForShop2483 minimumPenaltyForShop2483 = new MinimumPenaltyForShop2483();
        System.out.println(minimumPenaltyForShop2483.bestClosingTime("YYNY")); // 2
        System.out.println(minimumPenaltyForShop2483.bestClosingTime("NNNNN")); // 0
        System.out.println(minimumPenaltyForShop2483.bestClosingTime("YYYY")); // 4
    }
}
