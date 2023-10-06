package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoized {

    private int fibonacciCounter = 0;

    private Map<Integer, Integer> cache = new HashMap<>();

    private int fibonacciMemoizedCounter = 0;

    public int getFibonacciCounter() {
        return fibonacciCounter;
    }

    public int getFibonacciMemoizedCounter() {
        return fibonacciMemoizedCounter;
    }

    // 3 -> 1 + f(2) -> 1 + 0 + 1 -> 2
    // 4 -> f(2) + f(3) -> 0 + 1 + 1 + f(2) -> 0 + 1 + 1 + 0 + 1 -> 3
    // 5 -> f(3) + f(4) -> 1 + 0 + 1 + 0 + 1 + 1 + 0 + 1 -> 5
    // 6 -> 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 -> 8
    public int fibonacci(int n) {
        fibonacciCounter++;
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public int fibonacciMemoized(int n) {
        fibonacciMemoizedCounter++;
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int value = fibonacciMemoized(n - 2) + fibonacciMemoized(n - 1);
        cache.put(n, value);
        return value;
    }

    public int fibonacciMemoized2(int n) {
        if (n < 2) {
            return n;
        }
        int previous = 1;
        int previousBeforePrevious = 0;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = previous + previousBeforePrevious;
            previousBeforePrevious = previous;
            previous = current;
        }
        return current;
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55

    public static void main(String[] args) {
        FibonacciMemoized fibonacciMemoized = new FibonacciMemoized();
        System.out.println("fibonacci(6) -> " + fibonacciMemoized.fibonacci(6));
        System.out.println("fibonacci(6) counter -> " + fibonacciMemoized.getFibonacciCounter());
        System.out.println("fibonacciMemoized(6) -> " + fibonacciMemoized.fibonacciMemoized(6));
        System.out.println("fibonacciMemoized(6) counter -> " + fibonacciMemoized.getFibonacciMemoizedCounter());
        System.out.println("fibonacciMemoized2(6) -> " + fibonacciMemoized.fibonacciMemoized2(6));
    }

}
