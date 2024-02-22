package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = -1;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (map.containsKey(character)) {
                length = Math.max(length, i - map.get(character) - 1);
            } else {
                map.put(character, i);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters1624 largestSubstringBetweenTwoEqualCharacters1624 = new LargestSubstringBetweenTwoEqualCharacters1624();
        System.out.println(largestSubstringBetweenTwoEqualCharacters1624.maxLengthBetweenEqualCharacters("aa")); // 0
        System.out.println(largestSubstringBetweenTwoEqualCharacters1624.maxLengthBetweenEqualCharacters("abca")); // 2
        System.out.println(largestSubstringBetweenTwoEqualCharacters1624.maxLengthBetweenEqualCharacters("cbzxy")); // -1
        System.out.println(largestSubstringBetweenTwoEqualCharacters1624.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv")); // 18
    }

}
