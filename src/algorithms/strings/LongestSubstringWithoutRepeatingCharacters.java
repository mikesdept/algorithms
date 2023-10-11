package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringBruteForce(String s) {
        int max = 0;
        if (s == null) {
            return max;
        }
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int maxCandidate = 1;
            map.put(s.charAt(i), i);
            for (int j = i + 1; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), j);
                    maxCandidate++;
                } else {
                    break;
                }
            }
            if (maxCandidate > max) {
                max = maxCandidate;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce(null)); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("")); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("a")); // 1
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcdef")); // 6
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcdabb")); // 4
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcaerfqwawsx")); // 8
    }
}
