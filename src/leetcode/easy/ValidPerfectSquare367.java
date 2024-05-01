package leetcode.easy;

public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        while (left <= right) {
            long middle = (left + right) / 2;
            long square = middle * middle;
            if (square > num) {
                right = (int) middle - 1;
            } else if (square < num) {
                left = (int) middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare367 validPerfectSquare367 = new ValidPerfectSquare367();
        System.out.println(validPerfectSquare367.isPerfectSquare(16)); // true
        System.out.println(validPerfectSquare367.isPerfectSquare(14)); // false
        System.out.println(validPerfectSquare367.isPerfectSquare(1)); // true
        System.out.println(validPerfectSquare367.isPerfectSquare(808201)); // true
    }
}
