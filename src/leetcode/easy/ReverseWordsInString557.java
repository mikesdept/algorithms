package leetcode.easy;

public class ReverseWordsInString557 {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
                stringBuilder.append(words[i].charAt(j));
            }
            if (i < words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString557 reverseWordsInString557 = new ReverseWordsInString557();
        System.out.println(reverseWordsInString557.reverseWords("Let's take LeetCode contest")); // s'teL ekat edoCteeL tsetnoc
        System.out.println(reverseWordsInString557.reverseWords("Mr Ding")); // rM gniD
    }
}
