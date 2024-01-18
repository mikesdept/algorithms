package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringAnotherOptimalSolution(String s) {
        if (s == null) {
            return 0;
        }
        int leftIndex = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (map.containsKey(character) && map.get(character) >= leftIndex) {
                leftIndex = map.get(character) + 1;
            }
            map.put(character, i);
            max = Math.max(max, i - leftIndex + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringOptimalSolution(String s) {
        int leftIndex = 0;
        int max = 0;
        if (s == null) {
            return max;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            if (!map.containsKey(s.charAt(rightIndex))) {
                map.put(s.charAt(rightIndex), rightIndex);
            } else {
                if (map.get(s.charAt(rightIndex)) >= leftIndex) {
                    leftIndex = map.get(s.charAt(rightIndex)) + 1;
                }
                map.put(s.charAt(rightIndex), rightIndex);
            }
            int maxCandidate = rightIndex - leftIndex + 1;
            if (maxCandidate > max) {
                max = maxCandidate;
            }
        }
        return max;
    }

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
        System.out.println("Brute force solution");
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce(null)); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("")); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("a")); // 1
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcdef")); // 6
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcdabb")); // 4
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("abcaerfqwawsx")); // 8
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringBruteForce("aabaab!bb")); // 3
        System.out.println("Optimal solution");
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution(null)); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("")); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("a")); // 1
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("abcdef")); // 6
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("abcdabb")); // 4
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("abcaerfqwawsx")); // 8
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringOptimalSolution("aabaab!bb")); // 3
        System.out.println("Another optimal solution");
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution(null)); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("")); // 0
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("a")); // 1
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("abcdef")); // 6
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("abcdabb")); // 4
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("abcaerfqwawsx")); // 8
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringAnotherOptimalSolution("aabaab!bb")); // 3
    }
}
