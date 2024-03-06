package leetcode.medium;

public class TheKthFactorOfN1492 {

    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        return count == k - 1 ? n : -1;
    }

    public static void main(String[] args) {
        TheKthFactorOfN1492 theKthFactorOfN1492 = new TheKthFactorOfN1492();
        System.out.println(theKthFactorOfN1492.kthFactor(12, 3)); // 3
        System.out.println(theKthFactorOfN1492.kthFactor(7, 2)); // 7
        System.out.println(theKthFactorOfN1492.kthFactor(4, 4)); // -1
    }
}
