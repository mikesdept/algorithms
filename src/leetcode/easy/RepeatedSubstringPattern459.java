package leetcode.easy;

import java.math.BigInteger;

public class RepeatedSubstringPattern459 {

    public boolean repeatedSubstringPattern(String s) {
        int firstStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int firstEndIndex = i;
            if (s.length() % (firstEndIndex + 1) == 0 && firstEndIndex != s.length() - 1) {
                String string = s.substring(firstStartIndex, firstEndIndex + 1);
                int secondStartIndex = firstEndIndex + 1;
                int secondEndIndex = secondStartIndex + (firstEndIndex - firstStartIndex);
                while (secondEndIndex < s.length()) {
                    if (!s.substring(secondStartIndex, secondEndIndex + 1).equals(string)) {
                        break;
                    } else {
                        secondStartIndex = secondEndIndex + 1;
                        secondEndIndex = secondStartIndex + (firstEndIndex - firstStartIndex);
                    }
                }
                if (secondStartIndex == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Approach using polynomial hashing but with big integer due to large strings which performance is not so good
    public boolean repeatedSubstringPattern2(String s) {
        int p = 2;

        BigInteger[] pow = new BigInteger[s.length()];
        pow[0] = BigInteger.ONE;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1].multiply(BigInteger.valueOf(p));
        }

        BigInteger[] hashS = new BigInteger[s.length()];
        hashS[0] = BigInteger.valueOf(s.charAt(0));
        for (int i = 1; i < hashS.length; i++) {
            hashS[i] = hashS[i - 1].add(pow[i].multiply(BigInteger.valueOf(s.charAt(i))));
        }

        int firstStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int firstEndIndex = i;
            if (s.length() % (firstEndIndex + 1) == 0 && firstEndIndex != s.length() - 1) {
                BigInteger hashCheck = getHash(hashS, pow, firstStartIndex, firstEndIndex);
                int secondStartIndex = firstEndIndex + 1;
                int secondEndIndex = secondStartIndex + (firstEndIndex - firstStartIndex);
                while (secondEndIndex < s.length()) {
                    if (!hashCheck.equals(getHash(hashS, pow, secondStartIndex, secondEndIndex))) {
                        break;
                    } else {
                        secondStartIndex = secondEndIndex + 1;
                        secondEndIndex = secondStartIndex + (firstEndIndex - firstStartIndex);
                    }
                }
                if (secondStartIndex == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    private BigInteger getHash(BigInteger[] hash, BigInteger[] pow, int leftIndex, int rightIndex) {
        return (hash[rightIndex].subtract(leftIndex == 0 ? BigInteger.ZERO : hash[leftIndex - 1])).divide(pow[leftIndex]);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern459 repeatedSubstringPattern459 = new RepeatedSubstringPattern459();
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("abab")); // true
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("aba")); // false
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("abcabcabcabc")); // true
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("abababababababababababababababababababababababababababababababababababababababababababababababab")); // true

        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abab")); // true
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("aba")); // false
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abcabcabcabc")); // true
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern2("abababababababababababababababababababababababababababababababababababababababababababababababab")); // true
    }

}
