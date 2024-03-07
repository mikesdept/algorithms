package leetcode.easy;

import java.math.BigInteger;

public class PrimeArrangements1175 {
    private final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        if (n == 1) {
            return 1;
        }

        int primeNumbersCount = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (j < i) {
                        break;
                    } else {
                        primeNumbersCount++;
                    }
                }
            }
        }

        int otherNumbersCount = n - primeNumbersCount;
        return getFactorial(primeNumbersCount)
                .multiply(getFactorial(otherNumbersCount))
                .mod(BigInteger.valueOf(MOD))
                .intValue();
    }

    private BigInteger getFactorial(int x) {
        if (x == 0) {
            return BigInteger.valueOf(0);
        } else if (x == 1) {
            return BigInteger.valueOf(1);
        } else {
            return getFactorial(x - 1).multiply(BigInteger.valueOf(x));
        }
    }

    public static void main(String[] args) {
        PrimeArrangements1175 primeArrangements1175 = new PrimeArrangements1175();
        System.out.println(primeArrangements1175.numPrimeArrangements(5)); // 12
        System.out.println(primeArrangements1175.numPrimeArrangements(100)); // 682289015
        System.out.println(primeArrangements1175.numPrimeArrangements(1)); // 1
    }
}
