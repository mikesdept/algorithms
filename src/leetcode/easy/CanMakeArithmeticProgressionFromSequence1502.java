package leetcode.easy;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanMakeArithmeticProgressionFromSequence1502 canMakeArithmeticProgressionFromSequence1502 = new CanMakeArithmeticProgressionFromSequence1502();
        System.out.println(canMakeArithmeticProgressionFromSequence1502.canMakeArithmeticProgression(new int[]{3, 5, 1})); // true
        System.out.println(canMakeArithmeticProgressionFromSequence1502.canMakeArithmeticProgression(new int[]{1, 2, 4})); // false
    }

}
