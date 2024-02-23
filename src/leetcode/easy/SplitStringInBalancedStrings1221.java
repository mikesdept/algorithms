package leetcode.easy;

public class SplitStringInBalancedStrings1221 {

    public int balancedStringSplit(String s) {
        char firstCharacter = s.charAt(0);
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == firstCharacter) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SplitStringInBalancedStrings1221 splitStringInBalancedStrings1221 = new SplitStringInBalancedStrings1221();
        System.out.println(splitStringInBalancedStrings1221.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(splitStringInBalancedStrings1221.balancedStringSplit("RLRRRLLRLL")); // 2
        System.out.println(splitStringInBalancedStrings1221.balancedStringSplit("LLLLRRRR")); // 1
    }
}
