package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character character = magazine.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character character = ransomNote.charAt(i);
            int updatedCount = map.getOrDefault(character, 0) - 1;
            if (updatedCount < 0) {
                return false;
            } else {
                map.put(character, updatedCount);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote383 ransomNote383 = new RansomNote383();
        System.out.println(ransomNote383.canConstruct("a", "b")); // false
        System.out.println(ransomNote383.canConstruct("aa", "ab")); // false
        System.out.println(ransomNote383.canConstruct("aa", "aab")); // true
    }

}
