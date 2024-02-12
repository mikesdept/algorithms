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
    }

}
