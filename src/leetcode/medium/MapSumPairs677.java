package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs677 {

    private final Map<String, Integer> map;

    public MapSumPairs677() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            String key = mapEntry.getKey();
            if (prefix.length() <= key.length() && key.substring(0, prefix.length()).equals(prefix)) {
                sum += mapEntry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSumPairs677 mapSumPairs677 = new MapSumPairs677();
        mapSumPairs677.insert("apple", 3);
        System.out.println(mapSumPairs677.sum("ap")); // 3
        mapSumPairs677.insert("app", 2);
        System.out.println(mapSumPairs677.sum("ap")); // 5
    }

}
