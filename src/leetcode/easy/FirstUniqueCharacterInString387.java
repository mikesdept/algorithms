package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString387 {

    public int firstUniqChar(String s) {
        int result = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString387 firstUniqueCharacterInString387 = new FirstUniqueCharacterInString387();
        System.out.println(firstUniqueCharacterInString387.firstUniqChar("leetcode")); // 0
        System.out.println(firstUniqueCharacterInString387.firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqueCharacterInString387.firstUniqChar("aabb")); // -1
        System.out.println(firstUniqueCharacterInString387.firstUniqChar("aadadaad")); // -1
    }

}
