package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary720 {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String longestWord = "";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (longestWord.length() < word.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        LongestWordInDictionary720 longestWordInDictionary720 = new LongestWordInDictionary720();
        System.out.println(longestWordInDictionary720.longestWord(new String[]{"w", "wo", "wor", "worl", "world"})); // world
        System.out.println(longestWordInDictionary720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
    }

}
