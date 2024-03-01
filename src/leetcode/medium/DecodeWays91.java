package leetcode.medium;

public class DecodeWays91 {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] decodings = new int[s.length() + 1];
        decodings[0] = 1;
        decodings[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int currentSymbolIndex = i - 1;
            int lastOneDigit = Integer.parseInt(String.valueOf(s.charAt(currentSymbolIndex)));
            int lastTwoDigit = Integer.parseInt(s.substring(currentSymbolIndex - 1, i));
            if (lastOneDigit != 0) {
                decodings[i] += decodings[i - 1];
            }
            if (10 <= lastTwoDigit && lastTwoDigit <= 26) {
                decodings[i] += decodings[i - 2];
            }
        }
        return decodings[decodings.length - 1];
    }

    public static void main(String[] args) {
        DecodeWays91 decodeWays91 = new DecodeWays91();
        System.out.println(decodeWays91.numDecodings("12")); // 2
        System.out.println(decodeWays91.numDecodings("226")); // 3
        System.out.println(decodeWays91.numDecodings("06")); // 0
        System.out.println(decodeWays91.numDecodings("2101")); // 1
    }
}
