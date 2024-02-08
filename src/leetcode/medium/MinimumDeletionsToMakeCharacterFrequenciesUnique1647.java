package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique1647 {

    public int minDeletions(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        char currentChar = array[0];
        int count = 1;
        int deletions = 0;
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 1; i <= array.length; i++) {
            if (i == array.length || currentChar != array[i]) {
                if (map.containsKey(count)) {
                    while (map.containsKey(count)) {
                        count--;
                        deletions++;
                    }
                    if (count > 0) {
                        map.put(count, currentChar);
                    }
                } else {
                    map.put(count, currentChar);
                }
                if (i < array.length) {
                    currentChar = array[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique1647 minimumDeletionsToMakeCharacterFrequenciesUnique1647 = new MinimumDeletionsToMakeCharacterFrequenciesUnique1647();
        System.out.println(minimumDeletionsToMakeCharacterFrequenciesUnique1647.minDeletions("aab")); // 0
        System.out.println(minimumDeletionsToMakeCharacterFrequenciesUnique1647.minDeletions("aaabbbcc")); // 2
        System.out.println(minimumDeletionsToMakeCharacterFrequenciesUnique1647.minDeletions("ceabaacb")); // 2
    }

}
