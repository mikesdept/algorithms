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

    public static void main(String[] args) {
        SqrtX69 sqrtX69 = new SqrtX69();
        System.out.println(sqrtX69.mySqrt(4)); // 2
        System.out.println(sqrtX69.mySqrt(8)); // 2
        System.out.println(sqrtX69.mySqrt(2147395599)); // 46339
    }

}
