package leetcode.easy;

public class PerfectNumber507 {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            sum += num % i == 0 ? i : 0;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        PerfectNumber507 perfectNumber507 = new PerfectNumber507();
        System.out.println(perfectNumber507.checkPerfectNumber(28)); // true
        System.out.println(perfectNumber507.checkPerfectNumber(7)); // false
    }
}
