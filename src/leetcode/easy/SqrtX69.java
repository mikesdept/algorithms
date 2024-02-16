package leetcode.easy;

public class SqrtX69 {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long latestCandidate = -1;
        while (left <= right) {
            long squareRoot = (left + right) / 2;
            if (squareRoot * squareRoot > x) {
                right = squareRoot - 1;
            } else if (squareRoot * squareRoot < x) {
                left = squareRoot + 1;
                latestCandidate = squareRoot;
            } else {
                return (int) squareRoot;
            }
        }
        return (int) latestCandidate;
    }

    public int r_mySqrt(int x) {
        long left = 0;
        long right = x;
        long valueRoundedDown = 0;
        while (left <= right) {
            long value = (left + right) / 2;
            if (value * value > x) {
                right = value - 1;
            } else if (value * value < x) {
                valueRoundedDown = value;
                left = value + 1;
            } else {
                return (int) value;
            }
        }
        return (int) valueRoundedDown;
    }

    public static void main(String[] args) {
        SqrtX69 sqrtX69 = new SqrtX69();
        System.out.println(sqrtX69.mySqrt(4)); // 2
        System.out.println(sqrtX69.mySqrt(8)); // 2
        System.out.println(sqrtX69.mySqrt(1)); // 1
        System.out.println(sqrtX69.mySqrt(2147395599)); // 46339

        System.out.println(sqrtX69.r_mySqrt(4)); // 2
        System.out.println(sqrtX69.r_mySqrt(8)); // 2
        System.out.println(sqrtX69.r_mySqrt(1)); // 1
        System.out.println(sqrtX69.r_mySqrt(2147395599)); // 46339
    }

}
