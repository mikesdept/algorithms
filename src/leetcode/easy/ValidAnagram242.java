package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            int counter = 1;
            if (map.containsKey(character)) {
                counter = map.get(character) + 1;
            }
            map.put(character, counter);
        }
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if (map.containsKey(character)) {
                if (map.get(character) > 1) {
                    map.put(character, map.get(character) - 1);
                } else {
                    map.remove(character);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public boolean r_isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            if (!map.containsKey(character)) {
                return false;
            } else {
                int count = map.get(character);
                if (count > 1) {
                    map.put(character, count - 1);
                } else {
                    map.remove(character);
                }
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        ValidAnagram242 validAnagram242 = new ValidAnagram242();
        System.out.println(validAnagram242.isAnagram("anagram", "nagaram")); // true
        System.out.println(validAnagram242.isAnagram("rat", "car")); // false

        System.out.println(validAnagram242.r_isAnagram("anagram", "nagaram")); // true
        System.out.println(validAnagram242.r_isAnagram("rat", "car")); // false
    }

}
