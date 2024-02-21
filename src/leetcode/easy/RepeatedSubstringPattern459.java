package leetcode.easy;

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

    public static void main(String[] args) {
        RepeatedSubstringPattern459 repeatedSubstringPattern459 = new RepeatedSubstringPattern459();
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("abab")); // true
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("aba")); // false
        System.out.println(repeatedSubstringPattern459.repeatedSubstringPattern("abcabcabcabc")); // true
    }

}
