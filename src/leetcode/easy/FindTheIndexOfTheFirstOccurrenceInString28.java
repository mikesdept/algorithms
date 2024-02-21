package leetcode.easy;

public class FindTheIndexOfTheFirstOccurrenceInString28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int index = 0;
        while (index <= haystack.length() - needle.length()) {
            if (needle.equals(haystack.substring(index, index + needle.length()))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int strStrUsingPolynomialHashing(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int p = 31;

        long[] pow = new long[haystack.length()];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * p;
        }

        long[] haystackHash = new long[haystack.length()];
        haystackHash[0] = (long) haystack.charAt(0);
        for (int i = 1; i < haystackHash.length; i++) {
            haystackHash[i] = haystackHash[i - 1] + (pow[i] * (long) haystack.charAt(i));
        }

        long[] needleHash = new long[needle.length()];
        needleHash[0] = (long) needle.charAt(0);
        for (int i = 1; i < needleHash.length; i++) {
            needleHash[i] = needleHash[i - 1] + (pow[i] * (long) needle.charAt(i));
        }

        int index = 0;
        while (index < haystack.length() - needle.length() + 1) {
            if (needleHash[needleHash.length - 1] * pow[index] == getHaystackHash(haystackHash, index, index + needle.length() - 1)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private long getHaystackHash(long[] haystackHash, int left, int right) {
        return haystackHash[right] - (left == 0 ? 0 : haystackHash[left - 1]);
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInString28 findTheIndexOfTheFirstOccurrenceInString28 = new FindTheIndexOfTheFirstOccurrenceInString28();
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStr("sadbutsad", "sad")); // 0
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStr("leetcode", "leeto")); // -1
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStr("a", "a")); // 0
        System.out.println("==========");
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStrUsingPolynomialHashing("sadbutsad", "sad")); // 0
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStrUsingPolynomialHashing("leetcode", "leeto")); // -1
        System.out.println(findTheIndexOfTheFirstOccurrenceInString28.strStrUsingPolynomialHashing("a", "a")); // 0
    }

}
