package leetcode.easy;

public class PerfectNumber507 {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        if (num % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
            if (sum > num) {
                return false;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        PerfectNumber507 perfectNumber507 = new PerfectNumber507();
        System.out.println(perfectNumber507.checkPerfectNumber(28)); // true
        System.out.println(perfectNumber507.checkPerfectNumber(7)); // false
    }
}
