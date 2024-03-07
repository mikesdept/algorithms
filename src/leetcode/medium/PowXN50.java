package leetcode.medium;

public class PowXN50 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (x == 1) {
            return 1;
        } else if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }

        double result = 1;

        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        while (n != 0) {
            if (result == 0) {
                return result;
            }
            result *= x;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        PowXN50 powXN50 = new PowXN50();
        System.out.println(powXN50.myPow(2, 10)); // 1024
        System.out.println(powXN50.myPow(2.1, 3)); // 9.261
        System.out.println(powXN50.myPow(2, -2)); // 0.25
    }
}
