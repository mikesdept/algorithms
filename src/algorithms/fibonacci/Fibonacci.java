package algorithms.fibonacci;

// Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
// Given a number N return the index value of the Fibonacci sequence
// Example: N = 8, return 21
public class Fibonacci {

    // O(2^n) - which is very bad. Because it looks like a tree with each element and grows bigger and bigger
    public Integer fibonacciRecursive(int n) {
        if (n < 0) {
            return null;
        }
        if (n < 2) {
            return n;
        } else {
            return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
        }
    }

    // O(n) - which is better than recursive example
    public Integer fibonacciIterative(int n) {
        if (n < 0) {
            return null;
        } else if (n < 2) {
            return n;
        } else {
            int first = 0;
            int second = 1;
            Integer candidate = null;
            for (int i = 2; i <= n; i++) {
                candidate = first + second;
                first = second;
                second = candidate;
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Iterative method");
        System.out.println("find -2 -> " + fibonacci.fibonacciIterative(-2));
        System.out.println("find -1 -> " + fibonacci.fibonacciIterative(-1));
        System.out.println("find 0 -> " + fibonacci.fibonacciIterative(0));
        System.out.println("find 1 -> " + fibonacci.fibonacciIterative(1));
        System.out.println("find 2 -> " + fibonacci.fibonacciIterative(2));
        System.out.println("find 3 -> " + fibonacci.fibonacciIterative(3));
        System.out.println("find 5 -> " + fibonacci.fibonacciIterative(5));
        System.out.println("find 8 -> " + fibonacci.fibonacciIterative(8));
        System.out.println("find 10 -> " + fibonacci.fibonacciIterative(10));
        System.out.println("Recursive method");
        System.out.println("find -2 -> " + fibonacci.fibonacciRecursive(-2));
        System.out.println("find -1 -> " + fibonacci.fibonacciRecursive(-1));
        System.out.println("find 0 -> " + fibonacci.fibonacciRecursive(0));
        System.out.println("find 1 -> " + fibonacci.fibonacciRecursive(1));
        System.out.println("find 2 -> " + fibonacci.fibonacciRecursive(2));
        System.out.println("find 3 -> " + fibonacci.fibonacciRecursive(3));
        System.out.println("find 5 -> " + fibonacci.fibonacciRecursive(5));
        System.out.println("find 8 -> " + fibonacci.fibonacciRecursive(8));
        System.out.println("find 10 -> " + fibonacci.fibonacciRecursive(10));

    }

}
