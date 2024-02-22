package leetcode.easy;

public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int skippedIndexFromRight = -1;
        int skippedIndexFromLeft = -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (skippedIndexFromRight == -1) {
                    skippedIndexFromRight = right;
                    right--;
                } else if (skippedIndexFromLeft == -1) {
                    right = skippedIndexFromRight;
                    left = s.length() - right;
                    skippedIndexFromLeft = left - 1;
                } else {
                    return false;
                }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome680 validPalindrome680 = new ValidPalindrome680();
        System.out.println(validPalindrome680.validPalindrome("aba")); // true
        System.out.println(validPalindrome680.validPalindrome("abca")); // true
        System.out.println(validPalindrome680.validPalindrome("abc")); // false
        System.out.println(validPalindrome680.validPalindrome("deeee")); // true
        System.out.println(validPalindrome680.validPalindrome("ebcbbececabbacecbbcbe")); // true
    }

}
