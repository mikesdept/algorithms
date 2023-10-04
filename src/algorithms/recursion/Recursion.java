package algorithms.recursion;

public class Recursion {

    public int findFactorialRecursive(int number) {
        int numberToFindFactorial = number - 1;
        if (numberToFindFactorial <= 1) {
            return number;
        } else {
            return number * findFactorialRecursive(numberToFindFactorial);
        }
    }

    public int findFactorialIterative(int number) {
        int result = number;
        for (int i = 1; i < number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println("findFactorialIterative(5) -> " + recursion.findFactorialIterative(5));
        System.out.println("findFactorialRecursive(5) -> " + recursion.findFactorialRecursive(5));

        System.out.println("findFactorialIterative(-2) -> " + recursion.findFactorialIterative(-2));
        System.out.println("findFactorialRecursive(-2) -> " + recursion.findFactorialRecursive(-2));

        System.out.println("findFactorialIterative(-1) -> " + recursion.findFactorialIterative(-1));
        System.out.println("findFactorialRecursive(-1) -> " + recursion.findFactorialRecursive(-1));

        System.out.println("findFactorialIterative(0) -> " + recursion.findFactorialIterative(0));
        System.out.println("findFactorialRecursive(0) -> " + recursion.findFactorialRecursive(0));

        System.out.println("findFactorialIterative(1) -> " + recursion.findFactorialIterative(1));
        System.out.println("findFactorialRecursive(1) -> " + recursion.findFactorialRecursive(1));

        System.out.println("findFactorialIterative(2) -> " + recursion.findFactorialIterative(2));
        System.out.println("findFactorialRecursive(2) -> " + recursion.findFactorialRecursive(2));

        System.out.println("findFactorialIterative(3) -> " + recursion.findFactorialIterative(3));
        System.out.println("findFactorialRecursive(3) -> " + recursion.findFactorialRecursive(3));
    }

}
