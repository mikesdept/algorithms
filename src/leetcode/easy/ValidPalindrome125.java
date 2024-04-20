package leetcode.easy;

public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex) {
            if (!isAlphaNumeric(s.charAt(startIndex))) {
                startIndex++;
            } else if (!isAlphaNumeric(s.charAt(endIndex))) {
                endIndex--;
            } else if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) {
                return false;
            } else {
                startIndex++;
                endIndex--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char character) {
        return Character.isDigit(character) || Character.isLetter(character);
    }

    public static void main(String[] args) {
        ValidPalindrome125 validPalindrome125 = new ValidPalindrome125();
        System.out.println(validPalindrome125.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(validPalindrome125.isPalindrome("race a car")); // false
        System.out.println(validPalindrome125.isPalindrome(" ")); // true
    }
}
