package leetcode.easy;

public class CalculateMoneyInLeetcodeBank1716 {

    public int totalMoney(int n) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int firstWeekSum = 0;
        for (int item : array) {
            firstWeekSum += item;
        }
        int addition = n / array.length;
        int index = n % array.length - 1;

        int additionFullWeeks = 0;
        if (addition >= 1) {
            for (int i = 0; i < addition; i++) {
                additionFullWeeks += firstWeekSum + i * array.length;
            }
        }

        if (index == -1) {
            return additionFullWeeks;
        } else {
            int intermediateResult = 0;
            for (int i = 0; i <= index; i++) {
                intermediateResult += array[i] + addition;
            }
            return additionFullWeeks + intermediateResult;
        }
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank1716 calculateMoneyInLeetcodeBank1716 = new CalculateMoneyInLeetcodeBank1716();
        System.out.println(calculateMoneyInLeetcodeBank1716.totalMoney(4)); // 10
        System.out.println(calculateMoneyInLeetcodeBank1716.totalMoney(10)); // 37
        System.out.println(calculateMoneyInLeetcodeBank1716.totalMoney(20)); // 96
    }

}
