package leetcode.medium;

import java.util.*;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String string : strs) {
            String sortedString = sortString(string);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, map.size());
            }
            addToList(result, map.get(sortedString), string);
        }
        return result;
    }

    public List<List<String>> groupAnagramsOptimalSolution(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String word : strs) {
            Map<Character, Integer> mapKey = new HashMap<>();
            for (Character character : word.toCharArray()) {
                mapKey.put(character, mapKey.getOrDefault(character, 0) + 1);
            }
            List<String> list;
            if (map.containsKey(mapKey)) {
                list = map.get(mapKey);
            } else {
                list = new ArrayList<>();
            }
            list.add(word);
            map.put(mapKey, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            result.add(group);
        }
        return result;
    }

    private String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    private void addToList(List<List<String>> result, int index, String string) {
        if (result.size() > index) {
            List<String> anagramList = result.get(index);
            anagramList.add(string);
        } else {
            List<String> anagramList = new ArrayList<>();
            anagramList.add(string);
            result.add(index, anagramList);
        }
    }

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        System.out.println(groupAnagrams49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); // [["eat","tea","ate"],["tan","nat"],["bat"]]
        System.out.println(groupAnagrams49.groupAnagrams(new String[]{""})); // [[]]
        System.out.println(groupAnagrams49.groupAnagrams(new String[]{"a"})); // [["a"]]
        System.out.println(groupAnagrams49.groupAnagramsOptimalSolution(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); // [["eat","tea","ate"],["tan","nat"],["bat"]]
        System.out.println(groupAnagrams49.groupAnagramsOptimalSolution(new String[]{""})); // [[]]
        System.out.println(groupAnagrams49.groupAnagramsOptimalSolution(new String[]{"a"})); // [["a"]]
    }

}
