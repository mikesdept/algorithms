package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Memoized {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int memoizedAddTo80(int n) {
        if (cache.containsKey(n)) {
            System.out.println("cached");
        } else {
            System.out.println("long time");
            int result = n + 80;
            cache.put(n, result);
        }
        return cache.get(n);
    }

    public static void main(String[] args) {
        Memoized memoized = new Memoized();
        System.out.println("result 5 -> " + memoized.memoizedAddTo80(5));
        System.out.println("result 5 -> " + memoized.memoizedAddTo80(5));
        System.out.println("result 8 -> " + memoized.memoizedAddTo80(8));
        System.out.println("result 5 -> " + memoized.memoizedAddTo80(5));
    }

}
