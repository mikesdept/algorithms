package leetcode.medium;

public class MinimumOperationsToMakeArrayEqual1551 {

    public int minOperations(int n) {
        int result = 0;
        int addition = 1;
        int additionCount = 0;
        for (int i = 2; i <= n; i++) {
            if (additionCount == 2) {
                additionCount = 0;
                addition++;
            }
            result += addition;
            additionCount++;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayEqual1551 minimumOperationsToMakeArrayEqual1551 = new MinimumOperationsToMakeArrayEqual1551();
        System.out.println(minimumOperationsToMakeArrayEqual1551.minOperations(3)); // 2
        System.out.println(minimumOperationsToMakeArrayEqual1551.minOperations(6)); // 9
    }
}
