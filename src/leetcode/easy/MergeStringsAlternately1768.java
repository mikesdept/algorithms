package leetcode.easy;

public class MergeStringsAlternately1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int length = Math.max(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately1768 mergeStringsAlternately1768 = new MergeStringsAlternately1768();
        System.out.println(mergeStringsAlternately1768.mergeAlternately("abc", "pqr")); // apbqcr
        System.out.println(mergeStringsAlternately1768.mergeAlternately("ab", "pqrs")); // apbqrs
        System.out.println(mergeStringsAlternately1768.mergeAlternately("abcd", "pq")); // apbqcd
    }
}
