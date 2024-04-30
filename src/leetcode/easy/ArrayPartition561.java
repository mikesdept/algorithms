package leetcode.easy;

public class ArrayPartition561 {

    public int arrayPairSum(int[] nums) {
        int size = 10000;
        int[] counter = new int[size * 2 + 1];
        for (int number : nums) {
            counter[number + size]++;
        }

        boolean isEven = true;
        int result = 0;
        for (int i = 0; i <= 2 * size; i++) {
            while (counter[i] > 0) {
                result += isEven ? (i - size) : 0;
                isEven = !isEven;
                counter[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayPartition561 arrayPartition561 = new ArrayPartition561();
        System.out.println(arrayPartition561.arrayPairSum(new int[]{1, 4, 3, 2})); // 4
        System.out.println(arrayPartition561.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2})); // 9
    }
}
